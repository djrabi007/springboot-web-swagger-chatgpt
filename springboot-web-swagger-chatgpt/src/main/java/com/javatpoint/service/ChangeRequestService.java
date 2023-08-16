package com.javatpoint.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.ChangeRequests;
import com.javatpoint.repository.ChangeRequestRepository;

@Service
public class ChangeRequestService {
	@Autowired
	private ChangeRequestRepository changeRequestRepository;

	// Service method to fetch all Change Requests
	public List<ChangeRequests> getAllChangeRequests() {
		return changeRequestRepository.findAll();
	}

	// ***************FOR FUTURE USE ONLY ***************

	// Service method to fetch a specific Change Request by ID
	public ChangeRequests getChangeRequestById(Long id) {
		return changeRequestRepository.findById(id).orElse(null);
	}

	// Service method to filter Change Requests based on date range
	public List<ChangeRequests> getChangeRequestsByDateRange(LocalDate startDate, LocalDate endDate) {
		return changeRequestRepository.findByCreationDateTimeBetween(startDate.atStartOfDay(),
				endDate.atTime(LocalTime.MAX));
	}

	// Other service methods for additional filtering or CRUD operations
}
