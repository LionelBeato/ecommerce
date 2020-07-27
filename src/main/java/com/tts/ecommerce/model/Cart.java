package com.tts.ecommerce.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Long id; 
	
	private List<HashMap<Product, Integer>> lineItems;
	
	public List<HashMap<Product, Integer>> getLineItems() {
		return lineItems;
	}
	
	public void setLineItems(List<HashMap<Product, Integer>> lineItems) {
		this.lineItems = lineItems;
	}
	
	public Double getSubTotal() {
		return subTotal;
	}
	
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	private Double subTotal; 
	private User user; 
	
}
