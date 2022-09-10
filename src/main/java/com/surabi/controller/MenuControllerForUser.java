package com.surabi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.Menu;
import com.surabi.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuControllerForUser {
	@Autowired
	MenuService menuService;
	
	//to open displayMenuForUser and display all menu
	@GetMapping(value = "displayMenuForUser")
	public String openDisplayMenu(HttpServletRequest request, HttpSession hs) {
		List<Menu> listOfMenu = menuService.getAllMenu();
		hs.setAttribute("objMenu", listOfMenu);
		return "displayMenuForUser";
	}
}
