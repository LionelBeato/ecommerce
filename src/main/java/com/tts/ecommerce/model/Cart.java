package com.tts.ecommerce.model;

import java.util.HashMap;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Long id; 
	
	public List<HashMap<Product, Integer>> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<HashMap<Product, Integer>> lineItems) {
		this.lineItems = lineItems;
	}

	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
	private List<HashMap<Product, Integer>> lineItems;

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
	
	public Cart(User user) {
		super();
		this.user = user;
	}
	
	public Cart() {
		
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	private Double subTotal; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user; 
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="purchase_order_id")
	private PurchaseOrder purchaseOrder; 
	
}
