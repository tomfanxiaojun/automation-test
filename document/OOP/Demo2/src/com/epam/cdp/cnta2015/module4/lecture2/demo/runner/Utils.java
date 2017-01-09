package com.epam.cdp.cnta2015.module4.lecture2.demo.runner;

import java.util.List;

import com.epam.cdp.cnta2015.module4.lecture2.demo.model.Child;

public class Utils {

	public static void findByName(String searchValue, List<Child> list) {
		for (Child child : list) {
			if(searchValue.equals(child.getFirstName())){
				System.out.println(child.getInfo());
			}
		}
	}
	
}
