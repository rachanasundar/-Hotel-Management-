package com.surabi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.User;
import com.surabi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	// to open log in page
	@GetMapping(value = "userLoginPage")
	public String openUserLogIn() {
		return "userLogin";
	}

	// to open sign in page
	@GetMapping(value = "signinPage")
	public String openUserSignIn() {
		return "userSignin";
	}

	// to get bcak to the index page after log out
	@GetMapping(value = "userlogout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "index";
	}

	// to open user home page
	@GetMapping(value = "userHome")
	public String openUserHome() {
		return "userHome";
	}

	// to get user login information and verify password
	@PostMapping(value = "userLogin")
	public String openUserHomePage(HttpServletRequest request, HttpSession hs) {

		String email = request.getParameter("email");
		String name = email.substring(0, email.indexOf('@'));
		String password = request.getParameter("password");
		String loginResult = userService.verifyPassword(new User(email, password));

		if (loginResult.contains("Successful")) {
			request.setAttribute("objLogInResult", loginResult);
			hs.setAttribute("objEmail", email);
			hs.setAttribute("objName", name.toUpperCase());
			return "userHome";
		} else if (loginResult.contains("Failed")) {
			request.setAttribute("objLogInResult", loginResult);
			return "userLogin";
		}
		return "index";

	}

	// to sign in for a new user
	@PostMapping(value = "userSignin")
	public String openHomePage(HttpServletRequest request, HttpSession hs) {
		String email = request.getParameter("email");
		String name = email.substring(0, email.indexOf('@'));
		String password = request.getParameter("password");
		String signResult = userService.createAccount(new User(email, password));
		if (signResult.contains("Successful")) {
			request.setAttribute("objLogInResult", signResult);
			hs.setAttribute("objEmail", email);
			hs.setAttribute("objName", name.toUpperCase());
			return "userHome";
		} else if (signResult.contains("Failed")) {
			request.setAttribute("objLogInResult", signResult);
			return "userLogin";
		}
		return "index";

	}

//	// to 
//	@GetMapping(value = "displayBillForUser")
//	public String openBillPage() {
//		return "displayBillForUser";
//	}

}
