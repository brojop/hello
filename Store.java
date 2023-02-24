package com.FMT.books;

public class Store {
	private String store;
	private Name manager;
	private Address storeAddress;
	public Store(String store, Name manager, Address storeAddress) {
		super();
		this.store = store;
		this.manager = manager;
		this.storeAddress = storeAddress;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public Name getManager() {
		return manager;
	}
	public void setManager(Name manager) {
		this.manager = manager;
	}
	public Address getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(Address storeAddress) {
		this.storeAddress = storeAddress;
	}
	
}
