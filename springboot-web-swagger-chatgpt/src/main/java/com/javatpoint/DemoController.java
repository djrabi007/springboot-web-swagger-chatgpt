package com.javatpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.model.Customer;
import com.javatpoint.service.ICustomer;
import com.javatpoint.service.IUser;

@Controller
public class DemoController {
	@Autowired
	private IUser userRepo;

	@Autowired
	private ICustomer customerRepo;

	/**
	 * Go to index.html
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String index() {

//returns to index.html
		return "index";
	}

	@RequestMapping("/loan")
	public String loan() {

//returns to index.html
		return "loan";
	}

	/**
	 * 1. Inside index.html 2. user put the value of user and User object populated
	 * 3. User object saved in H2 database Go to user-data.html
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user-data");
		modelAndView.addObject("user", user);
		userRepo.save(user);
		return modelAndView;
	}

	/**
	 * There was issue if Customer.java has no setXXX
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/saveloan", method = RequestMethod.POST)
	public ModelAndView saveLoan(@ModelAttribute Customer customer) {
	//public ModelAndView saveLoan(@RequestParam String name, @RequestParam String income,
		//	@RequestParam String creditscore) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer-data");
		modelAndView.addObject("customer", customer);
		customerRepo.save(customer);
		return modelAndView;
	}
}