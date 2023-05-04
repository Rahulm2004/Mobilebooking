package com.mobilebooking.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Features {

	@Id
	@GeneratedValue
	private int id;
	private String colour;
	private String rating;
	private String waranty;
	
	Features(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getWaranty() {
		return waranty;
	}
	public void setWaranty(String waranty) {
		this.waranty = waranty;
	}
	
}
