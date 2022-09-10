package com.surabi.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

//Entity class of Menu table
@Entity
public class Menu {
	@Id
	private int itemId;
	private String itemName;
	private float itemPrice;

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int itemId, String itemName, float itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Menu [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}

}
