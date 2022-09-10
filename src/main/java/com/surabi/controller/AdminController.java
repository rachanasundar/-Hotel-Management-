package com.surabi.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.Admin;
import com.surabi.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	// open index page
	@GetMapping(value = "/")
	public String openIndexPage() {
		return "index";
	}

	// to open admin log in page
	@GetMapping(value = "adminLoginPage")
	public String openAdminLogIn() {
		return "adminLogin";
	}

	// to log out the admin and go back to index page
	@GetMapping(value = "adminLogout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "index";

	}

	// to open admin home page
	@GetMapping(value = "adminHome")
	public String openAdminHome() {
		return "adminHome";
	}

	// to verify the given password and go to adminHome page if success
	@PostMapping(value = "adminLogin")
	public String openAdminHomePage(HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String loginResult = adminService.verifyPassword(new Admin(email, password));

		if (loginResult.contains("Successful")) {
			request.setAttribute("objLogInResult", loginResult);
			return "adminHome";
		} else if (loginResult.contains("Failed")) {
			request.setAttribute("objLogInResult", loginResult);
			return "adminLogin";
		}
		return "index";

	}

}
