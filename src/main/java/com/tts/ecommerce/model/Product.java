package com.tts.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;
	
	@NotBlank(message = "Product name cannot be blank")
	private String name; 
	
	@PositiveOrZero(message = "Product wholesale price cannot be negative")
	private Double wholesalePrice;
	
	@PositiveOrZero(message = "Product wholesale price cannot be negative")
	private Double retailPrice; 
	
	@NotBlank(message = "Product brand cannot be blank")
	private String brand;
	
	@NotBlank(message = "Product category cannot be blank")
	private String category;
	
	private String description;
	private Integer inventory;
	private String image;
	
	@CreationTimestamp
	private Date createdAt;
	@CreationTimestamp
	private Date updatedAt; 
	
	
	@Override
	public int hashCode() {
		final int temp = 14;
		int ans = 1;
		ans = (int)(temp * ans + id); 
		return ans; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product)obj; 
		if(this.id != other.id) {
			return false;
		}
		return true; 
	}
	
	
	

}
