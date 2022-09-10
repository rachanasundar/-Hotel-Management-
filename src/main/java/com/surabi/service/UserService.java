package com.surabi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabi.bean.Admin;
import com.surabi.bean.User;
import com.surabi.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	// to verify the given password from the password stored in the database
	public String verifyPassword(User user) {
		if (userDao.existsById(user.getEmail())) {
			User u = userDao.getById(user.getEmail());

			if (u.getPassword().equals(user.getPassword())) {
				return "Log In Successful";
			} else {
				return "Log In Failed. Wrong Password";
			}
		} else {
			return "Log In Failed. User details not present. Sign In ";

		}
	}

	// to create a new account of a user
	public String createAccount(User user) {
		if (userDao.existsById(user.getEmail())) {
			return "Sign In Failed. User details excist. Please Log In";
		} else {
			userDao.save(user);
			return "Sign In Successful";
		}

	}

	// to get all users from the database
	public List<String> getAllUser() {
		List<User> listOfUser = userDao.findAll();

		// to return only user id not password
		List<String> listOfUserId = new ArrayList<String>();
		for (User user : listOfUser) {
			listOfUserId.add(user.getEmail());
		}
		return listOfUserId;
	}

	// to update the password of a user in the database
	public String updatePassword(User user) {
		if (!userDao.existsById(user.getEmail())) {
			return "User details not present";
		} else {
			User u = userDao.getById(user.getEmail());
			u.setPassword(user.getPassword());
			userDao.saveAndFlush(u);
			return "Password Updated Successfully";
		}
	}

	// to delete a uaer from the database
	public String deleteUser(String email) {
		if (!userDao.existsById(email)) {
			return "User details not present";
		} else {
			userDao.deleteById(email);
			return "User Deleted Successfully";
		}
	}
}
