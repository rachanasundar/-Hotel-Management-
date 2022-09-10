package com.surabi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surabi.bean.CompositeKeyForCart;
import com.surabi.bean.MyCart;

@Repository
public interface MyCartDao extends JpaRepository<MyCart, CompositeKeyForCart> {

	// query to get all the items in the cart of a user with given email
	@Query("select c from MyCart c where c.key.email=:email")
	public List<MyCart> getMyCart(@Param("email") String email);

	// query to get the total amount of the user with given email
	@Query("select sum(c.totalPrice) from MyCart c where c.key.email=:email")
	public float getMyTotal(@Param("email") String email);

	// query to delete the all the records from My_cart table of  user with given email
	@Transactional
	@Modifying
	@Query("Delete from MyCart c where c.key.email=:email")
	public void deleteAll(@Param("email") String email);

}
