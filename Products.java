package com.FMT.books;

public class Products extends Invoice{
	private String productCode;
	private String productName;
	private String unit;
	private double unitPrice;
	
	public Products(String productCode, String type, String productName, String unit, double unitPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.unit = unit;
		this.unitPrice = unitPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
