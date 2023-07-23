package com.javatpoint.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "change_requests")
public class ChangeRequests {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cr_number")
	private String crNumber;

	@Column(name = "creation_date_time")
	private LocalDateTime creationDateTime;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "account_group")
	private String accountGroup;

	// Add other properties and constructors as needed

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCrNumber() {
		return crNumber;
	}

	public void setCrNumber(String crNumber) {
		this.crNumber = crNumber;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup) {
		this.accountGroup = accountGroup;
	}

	// Override toString() method for debugging and logging purposes
	@Override
	public String toString() {
		return "ChangeRequest{" + "id=" + id + ", crNumber='" + crNumber + '\'' + ", creationDateTime="
				+ creationDateTime + ", createdBy='" + createdBy + '\'' + ", accountGroup='" + accountGroup + '\''
				+ '}';
	}
}



// Define other entities for organizational details, e.g., Company Code, Purchase Organization, etc.
