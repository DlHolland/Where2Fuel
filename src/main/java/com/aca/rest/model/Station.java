package com.aca.rest.model;

import java.time.LocalDate;
import java.util.Date;

public class Station implements Comparable<Station>{

	private String name;
	private Double price;
	private String address;
	private Date updateDate;
	private String email;
	
	public Station() {}
	
	public Station(String name, Double price, String address, Date updateDate) {
		
		this.name = name;
		this.price = price;
		this.address = address;
		this.updateDate = updateDate;
	}
	
	public Station(String name, Double price, String address, Date updateDate, String email) {
		this.name = name;
		this.price = price;
		this.address = address;
		this.updateDate = updateDate;
		this.email = email;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(Station station) {
		
		return new Double(price).compareTo( station.price);
		
	}



	

	
	
	
}
