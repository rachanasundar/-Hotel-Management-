package com.surabi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.surabi.bean.CompositeKeyForOrder;
import com.surabi.bean.MyCart;
import com.surabi.bean.Orders;

public interface OrdersDao extends JpaRepository<Orders, CompositeKeyForOrder> {

	// to get all orders of a given user with a given email
	@Query("select o from Orders o where o.key.email=:email ")
	public List<Orders> getAllOrders(@Param("email") String email);



}
