package com.epam.cdp.cnta2016.module4.lecture2.saples.compare;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainComparatorDemo {

	public static void main(String args[]) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Nick", 19));
		list.add(new Student("Helen", 20));
		list.add(new Student("Ross", 18));
		list.add(new Student("Michel", 23));

		System.out.println("Order of students before sorting is: ");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + "\t"
					+ list.get(i).getAge());
		}

		Collections.sort(list, new AgeComparator());
		System.out.println("Order of students after sorting by student age is");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + "\t"
					+ list.get(i).getAge());
		}

		Collections.sort(list, new NameComparator());
		System.out.println("Order of students after sorting by student name is");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName() + "\t"
					+ list.get(i).getAge());
		}
	}
}

