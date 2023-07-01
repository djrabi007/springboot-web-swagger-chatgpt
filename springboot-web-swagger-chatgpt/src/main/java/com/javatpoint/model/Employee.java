package com.javatpoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Employee {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	private String name;
	private String email;
	private String headline;
	private String phone;
	private String salary;

	public Employee() {

	}

	public Employee(String name, String email, String headline, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.headline = headline;
		this.phone = phone;

	}

	public Employee(String name, String email, String headline, String phone, String salary) {
		super();
		this.name = name;
		this.email = email;
		this.headline = headline;
		this.phone = phone;
		this.salary = salary;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static Employee fromDO(Object[] empObj) {
		return new Employee((String) empObj[0], (String) empObj[1], (String) empObj[2], (String) empObj[3]);
	}

}
