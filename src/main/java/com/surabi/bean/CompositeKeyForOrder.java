package com.surabi.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKeyForOrder implements Serializable {
	// Composite primary key of Orders table is defined here
	private String dateAndTime;
	private String email;
	private int itemId;

	public CompositeKeyForOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompositeKeyForOrder(String dateAndTime, String email, int itemId) {
		super();
		this.dateAndTime = dateAndTime;
		this.email = email;
		this.itemId = itemId;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "CompositeKeyForOrder [dateAndTime=" + dateAndTime + ", email=" + email + ", itemId=" + itemId + "]";
	}

}
