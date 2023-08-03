package com.javatpoint.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.javatpoint.model.Customer;
import com.javatpoint.model.LoanRecommendation;

public class PdfGenerator {


//	private static final String PDF = ".pdf";
//	private static final String UNDERSCORE = "_";
	// private static final String OUTPUT_FILE_LOCATION = "C:\\Output\\output.pdf";
	// private static final String OUTPUT_FILE_LOCATION = "C:\\Output\\output";
	// private static final String IMAGE_FILE_LOCATION = "C:\\Output\\logo.png";
//	private static final String OUTPUT_FILE_LOCATION = "pdfs/output.pdf";
//	private static final String IMAGE_FILE_LOCATION = "pdfs/logo.png";

	/**
	 * To generate at pdfs folder - "pdfs/output.pdf" putting inside the static
	 * folder so that JSP is able to navigate to the public folder inside
	 * "src/main/resources/static ........." folder
	 * 
	 * By default, Spring Boot serves static files from the "classpath:/static" or
	 * "classpath:/public" directories. Verify that the "pdfs" folder is located
	 * within one of these directories. If not, you may need to configure a custom
	 * static resources location.
	 */

	private static final String OUTPUT_FILE_LOCATION = "src/main/resources/static/pdfs/output.pdf";
	private static final String IMAGE_FILE_LOCATION = "src/main/resources/static/pdfs/logo.png";



	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("Rabi Sankar Podder");
		customer.setIncome(95000);
		customer.setCreditscore(800);
		generatePDF(customer, LoanRecommendationSystem.getLoanRecommendation(customer)); // SUCCESS
		// generatePDF(customer); // FAIL

	}

	/**
	 * PDF for Approved Loan
	 * 
	 * @param customer
	 * @param loanrecommendation
	 */
	public static void generatePDF(Customer customer, LoanRecommendation loanrecommendation) {
		try {

			String DEAR_STRING = "Dear " + customer.getName() + ",";
			String BODY_MESSAGE = "Congratulation!! Your Loan amount " + loanrecommendation.getLoanAmount()
					+ " with interest rate " + loanrecommendation.getInterestRate()
					+ " has been approved for loan type " + loanrecommendation.getLoanType() + ".";
			String REGARDS_MESSAGE_ONE = "Regards,";
			String REGARDS_MESSAGE_TWO = "Truist Bank";
			String REGARDS_MESSAGE_THREE = "Charlotte,NC";
			// Create a new Document
			Document document = new Document();

			// Specify the path and filename of the PDF file to be generated

			// Create a PdfWriter instance to write the document to a file
//			PdfWriter.getInstance(document,
//					new FileOutputStream(OUTPUT_FILE_LOCATION + UNDERSCORE + customer.getName() + PDF));
			PdfWriter.getInstance(document, new FileOutputStream(OUTPUT_FILE_LOCATION));
			

			// Open the document
			document.open();

			addLogo(document); // Add Logo

			// Add content to the document

			document.add(new Paragraph(DEAR_STRING));
			document.add(new Paragraph(BODY_MESSAGE));
			document.add(new Paragraph(REGARDS_MESSAGE_ONE));
			document.add(new Paragraph(REGARDS_MESSAGE_TWO));
			document.add(new Paragraph(REGARDS_MESSAGE_THREE));

			// Close the document
			document.close();

			System.out.println("PDF document generated successfully.");
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void addLogo(Document document)
			throws BadElementException, MalformedURLException, IOException, DocumentException {
		// Load the logo image
		Image logo = Image.getInstance(IMAGE_FILE_LOCATION);
		logo.scaleToFit(100, 100);

		// Set the position of the logo on the page
		logo.setAbsolutePosition(140, 500);

		// Add the logo to the document
		document.add(logo);
	}

	/**
	 * PDF for Rejected Loan
	 * 
	 * @param customer
	 */
	public static void generatePDF(Customer customer) {
		try {
			String DEAR_STRING = "Dear " + customer.getName() + ",";
			String BODY_MESSAGE = "Sorry!! Your Loan has been rejected.";
			String REGARDS_MESSAGE_ONE = "Regards,";
			String REGARDS_MESSAGE_TWO = "Truist Bank";
			String REGARDS_MESSAGE_THREE = "Charlotte,NC";
			// Create a new Document
			Document document = new Document();

			// Specify the path and filename of the PDF file to be generated

			// Create a PdfWriter instance to write the document to a file
			PdfWriter.getInstance(document, new FileOutputStream(OUTPUT_FILE_LOCATION));

			// Open the document
			document.open();

			addLogo(document); // Add Logo
			// Add content to the document

			document.add(new Paragraph(DEAR_STRING));
			document.add(new Paragraph(BODY_MESSAGE));
			document.add(new Paragraph(REGARDS_MESSAGE_ONE));
			document.add(new Paragraph(REGARDS_MESSAGE_TWO));
			document.add(new Paragraph(REGARDS_MESSAGE_THREE));

			// Close the document
			document.close();

			System.out.println("PDF document generated successfully.");
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}
}
