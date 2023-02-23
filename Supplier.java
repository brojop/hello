package com.cinco.payroll;

public class Supplier implements Payable{
	private final String companyName;
	private final double amountDue;
	
	public Supplier(String companyName, double amountDue) {
		this.companyName = "";
		this.amountDue = amountDue;
	}
	
	public double getNetPay() {
		return amountDue;
	}
}
