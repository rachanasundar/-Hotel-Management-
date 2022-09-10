package com.surabi.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//Entity class of Orders table
@Entity
public class Orders {
	@EmbeddedId
	private CompositeKeyForOrder key;
	private String itemName;
	private int numberOfPlate;
	private float totalPrice;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(CompositeKeyForOrder key, String itemName, int numberOfPlate, float totalPrice) {
		super();
		this.key = key;
		this.itemName = itemName;
		this.numberOfPlate = numberOfPlate;
		this.totalPrice = totalPrice;
	}

	public CompositeKeyForOrder getKey() {
		return key;
	}

	public void setKey(CompositeKeyForOrder key) {
		this.key = key;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNumberOfPlate() {
		return numberOfPlate;
	}

	public void setNumberOfPlate(int numberOfPlate) {
		this.numberOfPlate = numberOfPlate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Orders [key=" + key + ", itemName=" + itemName + ", numberOfPlate=" + numberOfPlate + ", totalPrice="
				+ totalPrice + "]";
	}

}
