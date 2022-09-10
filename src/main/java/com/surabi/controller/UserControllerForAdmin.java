package com.surabi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.User;
import com.surabi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserControllerForAdmin {
	
	@Autowired
	UserService userService;

	@GetMapping(value = "displayAllUser")
	public String displayAllUser(HttpServletRequest request) {
		List<String> listOfUserId = userService.getAllUser();
		request.setAttribute("objAllUser", listOfUserId);
		return "displayAllUser";
	}

	@GetMapping(value = "addNewUserPage")
	public String addNewUserPage() {
		return "addNewUser";
	}

	@PostMapping(value = "addNewUser")
	public String addNewUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String signResult = userService.createAccount(new User(email, password));
		String newUser;
		if (signResult.contains("Successful")) {
			newUser = "New User Added Successfully";
			request.setAttribute("objNewUser", newUser);
		} else if (signResult.contains("Failed")) {
			newUser = "Failed To Add New User";
			request.setAttribute("objNewUser", newUser);
		}
		return "addNewUser";
	}

	@GetMapping(value = "updateUserPasswordPage")
	public String openupdateUserPasswordPage() {
		return "updateUserPassword";
	}

	@PostMapping(value = "updatePassword")
	public String updatePassword(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String updateResult = userService.updatePassword(new User(email, password));
		request.setAttribute("objUpdatePass", updateResult);
		return "updateUserPassword";
	}

	@GetMapping(value = "deleteUserPage")
	public String deleteUserPage() {
		return "deleteUser";
	}

	@PostMapping(value = "deleteUser")
	public String deleteUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		String deleteResult = userService.deleteUser(email);
		request.setAttribute("objDelete", deleteResult);
		return "deleteUser";
	}

}
