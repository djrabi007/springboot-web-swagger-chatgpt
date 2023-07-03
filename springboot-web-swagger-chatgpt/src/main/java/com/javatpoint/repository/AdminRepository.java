package com.javatpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
