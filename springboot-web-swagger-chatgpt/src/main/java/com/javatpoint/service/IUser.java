package com.javatpoint.service;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.User;

public interface IUser extends CrudRepository<User, Long> {

}