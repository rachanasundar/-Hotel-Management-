package com.surabi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.Orders;
import com.surabi.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrderControllerForAdmin {
	@Autowired
	OrdersService ordersService;

	// to get today's orders
	@GetMapping(value = "displayTodaysBills")
	public String getTodayOrders(HttpServletRequest request) {
		List<Orders> todaysOrder = ordersService.getTodaysOrders();
		request.setAttribute("objTodaysOrder", todaysOrder);
		return "displayTodaysBills";
	}

	// to get this month's bill
	@GetMapping(value = "displayMonthlyBills")
	public String getMonthlyOrders(HttpServletRequest request) {
		List<Orders> monthlyOrder = ordersService.getMonthlyOrders();
		request.setAttribute("objMonthyOrder", monthlyOrder);
		return "displayMonthlyBills";
	}

	// to open specificUserOrderPage
	@GetMapping(value = "specificUserOrderPage")
	public String openSpecificUserOrderPage() {
		return "specificUserOrder";
	}

	// to get a specificUser email and display all the orders done bu that user
	@PostMapping(value = "specificUserOrder")
	public String specificUserOrder(HttpServletRequest request) {
		String email = request.getParameter("email");
		request.setAttribute("objSpecificUserOrder", ordersService.getOldOrders(email));
		request.setAttribute("fromSubmitted", 1);
		return "specificUserOrder";
	}

}
