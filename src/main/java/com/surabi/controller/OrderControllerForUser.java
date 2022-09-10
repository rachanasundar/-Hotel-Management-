package com.surabi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.MyCart;
import com.surabi.bean.Orders;
import com.surabi.service.OrdersService;

@Controller
@RequestMapping("/order")
public class OrderControllerForUser {
	@Autowired
	OrdersService ordersService;

	// to generate bills for user of given orders
	@PostMapping(value = "generateBill")
	public String openbill(HttpServletRequest request, HttpSession hs) {
		String email = (String) hs.getAttribute("objEmail");
		Object obj = hs.getAttribute("objCartList");

		List<MyCart> itemList = (List<MyCart>) obj;
		String result = ordersService.storeOrder(itemList, email);
		request.setAttribute("objOrder", result);
		return "userHome";
	}

	// to get bills generated to the orders done now
	@GetMapping(value = "getBill")
	public String getBill(HttpServletRequest request, HttpSession hs) {
		String email = (String) hs.getAttribute("objEmail");
		List<Orders> listOfOrder = ordersService.getNowOrders(email);
		System.out.println(listOfOrder);
		hs.setAttribute("objBill", listOfOrder);
		return "displayBillForUser";

	}

	// to all the orders done by a sepcific user
	@GetMapping(value = "userOldOrders")
	public String openAllOrders(HttpSession hs, HttpServletRequest request) {
		String email = (String) hs.getAttribute("objEmail");
		List<Orders> listOfOrder = ordersService.getOldOrders(email);
		request.setAttribute("objAllOrder", listOfOrder);
		return "userAllOrders";
	}

}
