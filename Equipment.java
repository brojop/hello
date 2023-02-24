package com.FMT.books;

public class Equipment extends Invoice {
	private String equipCode;
	private String equipName;
	private String model;
	
	public Equipment(String equipCode, String type, String equipName, String model) {
		super();
		this.equipCode = equipCode;
		this.equipName = equipName;
		this.model = model;
	}

	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Equipment";
	}
	
}
