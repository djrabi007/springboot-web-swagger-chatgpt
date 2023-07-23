package com.javatpoint.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.ChangeRequests;

/**
 * In these interfaces, we extend the JpaRepository interface provided by Spring
 * Data JPA. The JpaRepository provides out-of-the-box CRUD operations and other
 * common methods for interacting with the database.
 * 
 * For ChangeRequestRepository, we define a custom query method
 * findByCreationDateTimeBetween to retrieve Change Requests by their creation
 * date within a specific date range.
 * 
 * For WorkflowItemRepository, we define two custom query methods
 * findByChangeRequestId and findByUserToTakeAction to fetch Workflow Items
 * based on the Change Request ID and the userToTakeAction attribute,
 * respectively.
 * 
 * By extending JpaRepository, we don't need to implement these query methods
 * explicitly. Spring Data JPA automatically generates the queries based on the
 * method names and entity attributes, saving us from writing boilerplate code
 * for basic CRUD operations.
 * 
 * Please note that these repositories will interact with the H2 database (or
 * any other database specified in the Spring Boot configuration) to perform the
 * data retrieval and manipulation operations. The actual implementation of
 * these interfaces is handled by Spring Data JPA behind the scenes.
 * 
 * @author rabi0
 *
 */

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequests, Long> {
	// Custom query method to find Change Requests by creation date between start
	// and end dates
	List<ChangeRequests> findByCreationDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
