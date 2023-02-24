package com.FMT.books;

public class Services extends Invoice{
	private String serviceCode;
	private String serviceName;
	private double hourlyRate;
	
	public Services(String serviceCode, String type,  String serviceName, double hourlyRate) {
		super();
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.hourlyRate = hourlyRate;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
