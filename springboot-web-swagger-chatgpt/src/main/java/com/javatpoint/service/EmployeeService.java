package com.javatpoint.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Employee;
import com.javatpoint.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repositrory;

	@PersistenceContext
	private EntityManager entityManager;

	public void init() {
		// TODO Auto-generated method stub

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Rabi Sankar", "rabi@admin.got", "King of Rabi", "123-456-789", "5000"));
		employees.add(new Employee("Sourodeep Podder", "roddur@admin.got", "King of Roddur", "023-456-789", "7000"));

		this.save(employees);

		List<Employee> returns = repositrory.findAll();
		System.out.println(returns.size());
	}

	public List<Employee> getEmployeeByName(String name){
		String queryStr="Select name,email,headline,phone_no from employee where lower(name) like '%"+name.toLowerCase();
		
		try {
			Query query= entityManager.createNativeQuery(queryStr);
			List results= query.getResultList();
			List<Employee> listOfEmp = (List<Employee>) results.stream().map(o -> Employee.fromDO((Object[]) o))
					.collect(Collectors.toList());
 			
			return listOfEmp;
		} catch (Exception e) {
			// TODO: handle exception
			return Collections.EMPTY_LIST;
		}
		
	}

	public List<Employee> save(List<Employee> employeeList) {
		return repositrory.saveAll(employeeList);
	}

}
