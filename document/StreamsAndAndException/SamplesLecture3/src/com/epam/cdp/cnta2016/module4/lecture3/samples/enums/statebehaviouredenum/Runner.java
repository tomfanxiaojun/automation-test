package com.epam.cdp.cnta2016.module4.lecture3.samples.enums.statebehaviouredenum;

public class Runner {

	public static void main(String[] args) {
		for (Cars car : Cars.values()) {
			System.out.println(car.ordinal() + "-" + car.getInfo());		
		}
		
		//direct acess
		System.out.println(Cars.AUDI.ordinal());
		System.out.println(Cars.AUDI.name());
		
		//used in switch-case statements
		Cars car = Cars.AUDI;
		switch(car){
		case AUDI:
			System.out.println("This is Audi: " + car.getInfo());
			break;
		case LAMBORGHINI:
			System.out.println("This is Lamborghini: " + car.getInfo());
			break;
		case TATA:
			System.out.println("This is Tata: " + car.getInfo());
			break;
		case FIAT:
			System.out.println("This is Fiat: " + car.getInfo());
			break;
		case HONDA:
			System.out.println("This is Honda: " + car.getInfo());
			break;
		}
	}
}
