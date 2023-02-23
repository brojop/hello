package com.cinco.payroll;

public class Staff extends HourlyEmployee{

private static final double TAX_RATE = 0.15;
	
	public Staff(String id, 
				 String firstName, 
				 String lastName, 
				 String title, 
				 double hourlyPayRate, 
				 double hoursWorked) {
		super(id, firstName, lastName, title, hourlyPayRate, hoursWorked);
		// TODO Auto-generated constructor stub
	}


	public double getTaxes() {
		// TODO Auto-generated method stub
		return (getGrossPay() * TAX_RATE);
	}

	public String getType() {
		// TODO Auto-generated method stub
		return "Staff";
	}
	
}