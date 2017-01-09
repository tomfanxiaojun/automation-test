package com.epam.cdp.cnta2016.module4.lecture2.saples.encapsulation;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee encap = new Employee();
		encap.setName("James");
		encap.setAge(20);
		encap.setIdNum("12343ms");

		System.out.println("Name : " + encap.getName() + " Age : " + encap.getAge());
		encap.setAge(22);
		System.out.println("After re-setting: \nName : " + encap.getName() + " Age : " + encap.getAge());
		
	}

}
