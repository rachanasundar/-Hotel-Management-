package com.surabi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surabi.bean.CompositeKeyForCart;

import com.surabi.bean.MyCart;
import com.surabi.service.MyCartService;

@Controller
@RequestMapping("/cart")
public class MyCartController {
	@Autowired
	MyCartService cartService;

	// to get orders
	@PostMapping(value = "order")
	public String order(HttpServletRequest request, HttpSession hs) {
		String select = request.getParameter("item");
		String email = (String) hs.getAttribute("objEmail");
		String orderResult;
		if (select != null) {

			String getID = request.getParameter("id");
			String name = request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));
			String plates = request.getParameter("numberOfPlates");
			int numberOfPlates = Integer.parseInt(plates);
			int id = Integer.parseInt(getID);

			MyCart cart = new MyCart();
			cart.setKey(new CompositeKeyForCart(email, id));
			cart.setItemName(name);
			cart.setNumberOfPlates(numberOfPlates);
			cart.setTotalPrice(price * numberOfPlates);

			orderResult = cartService.addToCart(cart);
			request.setAttribute("objSelect", orderResult);

		} else {
			orderResult = "Please Select The Item";
			request.setAttribute("objSelect", orderResult);
		}
		return "displayMenuForUser";

	}

	// to open user cart page with cart items
	@GetMapping(value = "userCart")
	public String userCart(HttpServletRequest request, HttpSession hs) {
		String email = (String) hs.getAttribute("objEmail");

		List<MyCart> listOfCart = cartService.getMyCart(email);

		request.setAttribute("objCart", listOfCart);
		if (!listOfCart.isEmpty()) {
			float total = cartService.getMyTotal(email);
			request.setAttribute("objTotal", total);
		}
		return "userCart";
	}

	// to delete an itme from the cart
	@PostMapping(value = "deleteItem")
	public String deleteItem(HttpServletRequest request, HttpSession hs) {
		String email = (String) hs.getAttribute("objEmail");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String deleteResult = cartService.deleteItem(new CompositeKeyForCart(email, id));
		System.out.println(deleteResult);
		List<MyCart> listOfCart = cartService.getMyCart(email);

		request.setAttribute("objCart", listOfCart);
		if (!listOfCart.isEmpty()) {
			float total = cartService.getMyTotal(email);
			request.setAttribute("objTotal", total);
		}
		request.setAttribute("objDelete", deleteResult);
		return "userCart";
	}

	// to detele all item of a user from the cart once amount is paid
	@PostMapping(value = "deleteAllInCart")
	public String deleteAll(HttpSession hs, HttpServletRequest request) {
		String email = (String) hs.getAttribute("objEmail");
		String claerCart = cartService.deleteAll(email);
		request.setAttribute("objAmount", claerCart);
		return "userHome";
	}

}
