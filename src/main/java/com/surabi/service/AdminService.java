package com.surabi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabi.bean.Admin;
import com.surabi.dao.AdminDao;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	
	//to verify the given password from the password stored in the database
	public String verifyPassword(Admin admin) {
		if (adminDao.existsById(admin.getEmail())) {
			Admin a = adminDao.getById(admin.getEmail());

			if (a.getPassword().equals(admin.getPassword())) {
				return "Admin " + admin.getEmail() + " Log In Successful";
			} else {
				return "Admin " + admin.getEmail() + " Log In Failed. Wrong Password";
			}
		} else {
			return "Admin " + admin.getEmail() + " Log In Failed. Log In with admin credentials";

		}

	}
}
