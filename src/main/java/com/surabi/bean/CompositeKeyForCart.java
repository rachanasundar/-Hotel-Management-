package com.surabi.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKeyForCart implements Serializable {
	// Composite primary key of MyCart table is defined here
	private String email;
	private int itemId;

	public CompositeKeyForCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompositeKeyForCart(String email, int itemId) {
		super();
		this.email = email;
		this.itemId = itemId;
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
		return "CompositeKey [email=" + email + ", itemId=" + itemId + "]";
	}

}
