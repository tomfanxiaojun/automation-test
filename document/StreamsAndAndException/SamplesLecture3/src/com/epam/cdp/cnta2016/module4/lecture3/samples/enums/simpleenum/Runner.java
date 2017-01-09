package com.epam.cdp.cnta2016.module4.lecture3.samples.enums.simpleenum;

public class Runner {
	
	public static void main(String[] args) {
		for (Cars car : Cars.values()) {
			System.out.println(car.ordinal());
			System.out.println(car.name());			
		}
	}

}
