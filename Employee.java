package com.cinco.payroll;

public abstract class Employee implements Payable{
	private final String id;
	private final String firstName;
	private final String lastName;
	private final String title;
	
	public Employee(String id, String firstName, String lastName, String title) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTitle() {
		return title;
	}
	
	public double getNetPay() {
		return getGrossPay() - getTaxes();
	}
	
	public abstract double getGrossPay();	
	
	public abstract double getTaxes();
	
	public abstract String getType();
	
}