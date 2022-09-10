package com.surabi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DateAndTime;
import com.surabi.bean.CompositeKeyForOrder;
import com.surabi.bean.MyCart;
import com.surabi.bean.Orders;
import com.surabi.dao.OrdersDao;

@Service
public class OrdersService {
	@Autowired
	OrdersDao ordersDao;

	// Store orders in database
	public String storeOrder(List<MyCart> itemList, String email) {
		Orders orders = new Orders();
		Iterator<MyCart> ii = itemList.iterator();
		while (ii.hasNext()) {
			MyCart item = ii.next();
			orders.setKey(new CompositeKeyForOrder(DateAndTime.dateTime(), email, item.getKey().getItemId()));
			orders.setItemName(item.getItemName());
			orders.setNumberOfPlate(item.getNumberOfPlates());
			orders.setTotalPrice(item.getTotalPrice());

			ordersDao.save(orders);
		}
		return "Bill Generated Successfully. Click On View Bill";

	}

	// to get order done in this hour to generate bill
	public List<Orders> getNowOrders(String email) {
		List<Orders> listOfOrders = ordersDao.getAllOrders(email);
		System.out.println(listOfOrders);
		String today = DateAndTime.dateAndHour();
		System.out.println(today);
		List<Orders> myOrders = new ArrayList<Orders>();
		Iterator<Orders> ii = listOfOrders.iterator();
		while (ii.hasNext()) {
			Orders o = ii.next();
			if (o.getKey().getDateAndTime().contains(today)) {
				myOrders.add(o);
			}
		}
		System.out.println(myOrders);
		return myOrders;

	}

	// to get all old orders
	public List<Orders> getOldOrders(String email) {
		return ordersDao.getAllOrders(email);
	}

	// to get all orders done today
	public List<Orders> getTodaysOrders() {

		List<Orders> todaysOrders = new ArrayList<Orders>();
		List<Orders> listOfOrders = ordersDao.findAll();
		Iterator<Orders> ii = listOfOrders.iterator();
		while (ii.hasNext()) {
			Orders o = ii.next();
			if (o.getKey().getDateAndTime().contains(DateAndTime.today())) {
				todaysOrders.add(o);
			}
		}
		return todaysOrders;

	}

	// to get all orders done in this month
	public List<Orders> getMonthlyOrders() {

		List<Orders> monthOrders = new ArrayList<Orders>();
		List<Orders> listOfOrders = ordersDao.findAll();
		Iterator<Orders> ii = listOfOrders.iterator();
		while (ii.hasNext()) {
			Orders o = ii.next();
			if (o.getKey().getDateAndTime().contains(DateAndTime.thisMonth())) {
				monthOrders.add(o);
			}
		}
		return monthOrders;

	}

	

}
