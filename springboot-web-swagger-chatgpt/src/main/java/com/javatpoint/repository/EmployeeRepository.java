package com.javatpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
