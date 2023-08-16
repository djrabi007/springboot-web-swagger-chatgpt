package com.javatpoint.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.constants.CommonContants;
import com.javatpoint.constants.SQLConstants;
import com.javatpoint.model.Customer;

@Controller
public class XMLGenerationController {


	private final JdbcTemplate jdbcTemplate;

//	String outputDirectory = "D:\\WORKSAPCE\\Test\\xmlfile"; // Specify the output directory

	@Autowired
	public XMLGenerationController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Step-I Landing Home page . It will navigate to "xml-home.html"
	 * 
	 * @return
	 */
	@RequestMapping("/xml-home")
	public String xmlGeneration() {
		return "xml-home";
	}

	/**
	 * 1. Execute SQL -->"SELECT * FROM customer WHERE income >= ? AND income <= ?"
	 * 2. parameter is passed from UI..............................................
	 * 3. XML is generated for each record 3A).generateXMLFiles() will throw
	 * CustomException for Empty record in CUSTOMER table
	 * .........................3B) error message has been set in
	 * modelAndView.addObject("errorMessage", e.getErrorMessage());
	 * ..............3C) It will be visible in html page
	 * 
	 * 
	 * @param startValue
	 * @param endValue
	 * @return
	 */
	@RequestMapping("/xml-generation")
	public ModelAndView xmlGeneration(@RequestParam("startValue") int startValue,
			@RequestParam("endValue") int endValue) {
		// cleanDirectory(); // Remove all the file present in the directory
		ModelAndView modelAndView = new ModelAndView();
		try {
			generateXMLFiles(startValue, endValue);
			List<String> fileNames = prepareFileList();
			modelAndView.addObject("fileNames", fileNames);
			// modelAndView.addObject("sqlName", SQLConstants.CUSTOMER_WHERE_INCOME);
		} catch (CustomException e) {
			modelAndView.addObject("errorMessage", e.getErrorMessage());
		}
		modelAndView.setViewName("xml-home");
		return modelAndView;
		// return "xml-generation";
	}

	@GetMapping("/deleteFiles")
	public String deleteFiles(Model model) {
		try {
			cleanDirectory();
			model.addAttribute("message", "All files in the directory have been deleted.");
		} catch (Exception e) {
			model.addAttribute("message", "Error deleting files: " + e.getMessage());
		}
		return "xml-deletion"; // Replace with the actual Thymeleaf page URL
	}

	private void cleanDirectory() {
		File directory = new File(CommonContants.OUTPUT_FILE_LOCATION);
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					file.delete();
				}
			}
		}
	}

	@GetMapping("/download/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
		String filePath = CommonContants.OUTPUT_FILE_LOCATION + "/" + fileName; // Replace with your directory path
		File file = new File(filePath);
		FileSystemResource resource = new FileSystemResource(file);

		byte[] fileContent = Files.readAllBytes(file.toPath()); // otherwise 0kb file would be downloaded

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);

		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

	private List<String> prepareFileList() {
		// String directoryPath = "C:/WORKSPACE/Test/xmlfile"; // Replace with your
		// directory path
		List<String> fileNames = new ArrayList<>();

		File directory = new File(CommonContants.OUTPUT_FILE_LOCATION);
		if (directory.exists() && directory.isDirectory()) {
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.getName().endsWith(".xml")) {
						fileNames.add(file.getName());
					}
				}
			}
		}
		return fileNames;
	}

	public void generateXMLFiles(int minIncome, int maxIncome) {
		// List<Customer> customers = jdbcTemplate.query(SELECT_FROM_CUSTOMER_ALL, new
		// CustomerMapper());
		List<Customer> customers = getCustomersByIncome(minIncome, maxIncome);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			if (customers.isEmpty()) {
				throw new CustomException("NO_RECORD", "there is no record");
			}

			for (Customer customer : customers) {
				File outputFile = new File(CommonContants.OUTPUT_FILE_LOCATION,
						"customer_" + customer.getId() + "_" + customer.getName() + "_" + customer.getIncome()
								+ ".xml");
				marshaller.marshal(customer, outputFile);
				System.out.println("XML file generated for customer: " + customer.getName());
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public List<Customer> getCustomersByIncome(int minIncome, int maxIncome) {
		List<Customer> customers = jdbcTemplate.query(SQLConstants.CUSTOMER_WHERE_INCOME,
				new Object[] { minIncome, maxIncome }, new CustomerMapper());
		return customers;
	}

	public static class CustomerMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setId(rs.getLong("id"));
			customer.setName(rs.getString("name"));
			customer.setCreditscore(rs.getInt("CREDIT_SCORE"));
			customer.setIncome(rs.getDouble("income"));
			return customer;
		}
	}
}
