package com.epam.cdp.cnta2016.module4.lecture2.saples.compare;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {

		// descending order (ascending order would be:
		// o1.getAge()-o2.getAge())
		return o2.getAge() - o1.getAge();
	}
}

