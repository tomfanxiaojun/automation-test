package com.epam.cdp.cnta2016.module4.lecture3.samples.enums.statebehaviouredenum;

public enum Cars {
	LAMBORGHINI("Italy", 900), 
	TATA("India", 2), 
	AUDI("German", 50), 
	FIAT("Italy", 15), 
	HONDA("Japan", 12);
	
	private String manufacturer;
	private Integer price;
	
	Cars(String manufacturer, Integer price){
		this.manufacturer = manufacturer;
		this.price = price;
	}
	
	public String getInfo() {
		return this.name() + " " + this.manufacturer + " $" + this.price + " thousands";
	}
}
