package com.epam.cdp.cnta2016.module4.lecture2.saples.inheritance;

public class Runner {

	public static void main(String[] args) {
	
		Person mother = new Person ("Irina", "Ivanova");
		Person father = new Person ("Ivan", "Ivanov");
		
		Person child = new Child ("Ian", "Ivanov", mother, father);
		System.out.println(child.getInfo());
		
	}

}
