package com.epam.cdp.cnta2016.module4.lecture2.saples.abstractclasses;

public class ConcreteDemo extends AbstractDemo {

	public static void main(String args[]) {
		AbstractDemo obj = new ConcreteDemo();
		obj.method1();
		obj.method2();
	}

	@Override
	public void method2() {
		System.out.println("I'm overriding abstract method");
	}

}