package com.javatpoint;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javatpoint.exception.QueryException;
import com.javatpoint.service.EmployeeService;


@Controller
public class HomeController {

	private static final String HOME = "home";
	@Autowired
	EmployeeService empService;

	@RequestMapping("/p")
	public String serveHome(Model model) {
		model.addAttribute("employees", Collections.EMPTY_LIST);
		return HOME;
	}

	@PostMapping("/p")
	public String search(@RequestParam String query, Model model) {
		model.addAttribute("employees", empService.getEmployeeByName(query));
		return HOME;
	}


	@ExceptionHandler(QueryException.class)
	public ResponseEntity<?> handleException(QueryException exec) {
		return ResponseEntity.notFound().build();
	}

}
