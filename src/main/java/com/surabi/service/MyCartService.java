package com.surabi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surabi.bean.CompositeKeyForCart;
import com.surabi.bean.MyCart;
import com.surabi.dao.MyCartDao;

@Service
public class MyCartService {
	@Autowired
	MyCartDao cartDao;

	// to add item to the cart
	public String addToCart(MyCart cart) {
		if (cartDao.existsById(cart.getKey())) {
			return "Item already present in the cart";
		} else {
			cartDao.save(cart);
			return "Item " + cart.getItemName() + " added to the cart";
		}

	}

	// to get all items in the cart
	public List<MyCart> getMyCart(String emial) {

		return cartDao.getMyCart(emial);
	}

	// to get total amount of item price stroed in the cart
	public float getMyTotal(String email) {
		return cartDao.getMyTotal(email);
	}

	// to delete a itme from the cart
	public String deleteItem(CompositeKeyForCart key) {
		System.out.println(cartDao.getById(key));
		cartDao.deleteById(key);
		return "Item deleted from the cart";
	}

	// to delete all from the cart once amount is paid
	public String deleteAll(String email) {
		cartDao.deleteAll(email);
		return "Amount Paid Suceessfully";
	}

}
