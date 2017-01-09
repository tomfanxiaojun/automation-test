package com.epam.cdp.cnta2016.module4.lecture2.saples.compare;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();

		// ascending order (descending order would be: name2.compareTo(name1))
		return name1.compareTo(name2);
	}

}

