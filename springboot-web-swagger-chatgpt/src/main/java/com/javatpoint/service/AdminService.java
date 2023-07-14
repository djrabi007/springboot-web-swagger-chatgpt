package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Admin;
import com.javatpoint.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;

	public void init() {
		// TODO Auto-generated method stub
		List<Admin> admins = new ArrayList<>();
		admins.add(new Admin("Admin1", "admin1@admin.got", "123-456-789"));
		admins.add(new Admin("Admin2", "admin2@admin.got", "123-456-789"));
		adminRepository.saveAll(admins);
	}

}
