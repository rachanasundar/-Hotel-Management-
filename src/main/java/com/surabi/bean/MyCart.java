package com.surabi.bean;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.FetchProfile.FetchOverride;

//Entity class of My_Cart table
@Entity
public class MyCart {
	@EmbeddedId
	private CompositeKeyForCart key;
	private String itemName;
	private int numberOfPlates;
	private float totalPrice;

	public MyCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyCart(CompositeKeyForCart key, String itemName, int numberOfPlates, float totalPrice) {
		super();
		this.key = key;
		this.itemName = itemName;
		this.numberOfPlates = numberOfPlates;
		this.totalPrice = totalPrice;
	}

	public CompositeKeyForCart getKey() {
		return key;
	}

	public void setKey(CompositeKeyForCart key) {
		this.key = key;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNumberOfPlates() {
		return numberOfPlates;
	}

	public void setNumberOfPlates(int numberOfPlates) {
		this.numberOfPlates = numberOfPlates;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "MyCart [key=" + key + ", itemName=" + itemName + ", numberOfPlates=" + numberOfPlates + ", totalPrice="
				+ totalPrice + "]";
	}

}
