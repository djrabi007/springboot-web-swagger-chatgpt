package com.javatpoint.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javatpoint.model.ChangeRequests;
import com.javatpoint.service.ChangeRequestService;

/**
 * These controllers expose API endpoints to fetch, filter, and perform CRUD
 * operations on Change Requests and Workflow Items. The service classes
 * (ChangeRequestService and WorkflowItemService) handle the business logic and
 * interact with the repositories to fetch and manipulate data.
 * 
 * Please note that the above code assumes that you have implemented the
 * corresponding service classes (ChangeRequestService and WorkflowItemService)
 * to perform the actual data retrieval and processing. Additionally, you may
 * need to add error handling and validation for the input parameters in the
 * controllers to ensure a robust and secure API.
 * 
 * @author rabi0
 *
 */
//@RestController
@Controller
@RequestMapping("/change-requests")
public class ChangeRequestController {
    @Autowired
    private ChangeRequestService changeRequestService;

	// API endpoint to fetch all Change Requests
	// Invoked by Ajax call
	@GetMapping("/all-report")
	@ResponseBody
	public ResponseEntity<List<ChangeRequests>> getAllChangeRequests() {
		List<ChangeRequests> changeRequests = changeRequestService.getAllChangeRequests();
		return ResponseEntity.ok(changeRequests);
	}

	// USed by JSP thymeleaf
	@GetMapping("/audit-log-report")
	public String showAuditLogReport(Model model) {
		List<ChangeRequests> changeRequests = changeRequestService.getAllChangeRequests();
		model.addAttribute("changeRequests", changeRequests);
		return "auditLogReport"; // Thymeleaf template name
	}




	// ***************FOR FUTURE USE ONLY ***************

	// API endpoint to fetch a specific Change Request by ID
	@GetMapping("/{id}")
	public ResponseEntity<ChangeRequests> getChangeRequestById(@PathVariable Long id) {
		ChangeRequests changeRequest = changeRequestService.getChangeRequestById(id);
		if (changeRequest != null) {
			return ResponseEntity.ok(changeRequest);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// API endpoint to filter Change Requests based on certain criteria
	// For example: /change-requests?startDate=2023-01-01&endDate=2023-12-31
	@GetMapping(params = { "startDate", "endDate" })
	public ResponseEntity<List<ChangeRequests>> getChangeRequestsByDateRange(@RequestParam LocalDate startDate,
			@RequestParam LocalDate endDate) {
		List<ChangeRequests> changeRequests = changeRequestService.getChangeRequestsByDateRange(startDate, endDate);
		return ResponseEntity.ok(changeRequests);
	}


	// Other API endpoints as needed for additional filtering or CRUD operations



}
