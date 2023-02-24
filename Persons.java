package com.FMT.books;

public class Persons {
	private Name name;
	private String id;
	private Address address;
	private String email;
	public Persons(Name name, String code, Address address, String email) {
		super();
		this.name = name;
		this.id = code;
		this.address = address;
		this.email = email;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getCode() {
		return id;
	}
	public void setCode(String code) {
		this.id = code;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
