package com.FMT.books;

public abstract class Invoice {
	private Equipment equipment;
	private Products products;
	private Services service;
	
	public Invoice(Equipment equipment, String type, Products products, Services service) {
		super();
		this.equipment = equipment;
		this.products = products;
		this.service = service;
	}


	public Invoice() {
		// TODO Auto-generated constructor stub
	}


	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}


	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}
	public abstract String getType();
}
