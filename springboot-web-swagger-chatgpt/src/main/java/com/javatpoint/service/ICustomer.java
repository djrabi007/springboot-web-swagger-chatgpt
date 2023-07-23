package com.javatpoint.service;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Customer;

public interface ICustomer extends CrudRepository<Customer, Long> {

}