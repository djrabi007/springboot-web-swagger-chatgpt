package com.javatpoint.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3592858040144484491L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double income;
	private int creditscore;

	public Customer() {

	}

	public Customer(String name, double income, int creditscore) {
		this.name = name;
		this.income = income;
		this.creditscore = creditscore;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return income;
	}

	public int getCreditScore() {
		return creditscore;
	}

	public int getCreditscore() {
		return creditscore;
	}

	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIncome(double income) {
		this.income = income;
	}

}
