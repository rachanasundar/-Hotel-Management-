package com.surabi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.surabi.bean.Menu;
import com.surabi.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuControllerForAdmin {
	@Autowired
	MenuService menuService;

	// to display all the menu for admin
	@GetMapping(value = "displayMenuForAdmin")
	public String openDisplayAllMenu(HttpServletRequest request) {
		List<Menu> listOfMenu = menuService.getAllMenu();
		request.setAttribute("objMenu", listOfMenu);
		return "displayMenuForAdmin";
	}

	// to open addNewMenu page
	@GetMapping(value = "addNewMenuPage")
	public String openAddMenuPage() {
		return "addNewMenu";
	}

	// to add a new menu
	@PostMapping(value = "addNewMenu")
	public String addNewMenu(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		String addMenuResult = menuService.addNewMenu(new Menu(id, name, price));
		request.setAttribute("objAddMenu", addMenuResult);
		return "addNewMenu";
	}

	// to open updateItemName Page
	@GetMapping(value = "updateItemNamePage")
	public String openUpdateItemNamePage() {
		return "updateItemName";
	}

	// to update item name
	@PostMapping(value = "updateItemName")
	public String updateItemName(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Menu item = new Menu();
		item.setItemId(id);
		item.setItemName(name);
		String updateResult = menuService.updateItemName(item);
		request.setAttribute("objUpdateIName", updateResult);
		return "updateItemName";
	}

	// to open updateItemPricePage
	@GetMapping(value = "updateItemPricePage")
	public String openUpdateItemPricePage() {
		return "updateItemPrice";
	}

	// to update item price
	@PostMapping(value = "updateItemPrice")
	public String UpdateItemPrice(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		float price = Float.parseFloat(request.getParameter("price"));
		Menu item = new Menu();
		item.setItemId(id);
		item.setItemPrice(price);
		String updateResult = menuService.updateItemPrice(item);
		request.setAttribute("objUpdateIPrice", updateResult);
		return "updateItemPrice";
	}

	// to open deleteItemPage
	@GetMapping(value = "deleteItemPage")
	public String openDeleteItemPage() {
		return "deleteItem";
	}

	// to delete item
	@PostMapping(value = "deleteItem")
	public String deleteItem(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String deleteResult = menuService.deleteItem(id);
		request.setAttribute("objDeleteItem", deleteResult);
		return "deleteItem";
	}

}
