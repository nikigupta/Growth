package com.amazonaws.lambda.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	public static void main(String args[]) {
	
 		Student student = new Student();
		student.setId("2");
		Student student1 = new Student();
		student1.setId("2");
		Student student2 = new Student();
		student2.setId("2");
		List<Student> list = new ArrayList<Student>();
		list.add(student2);
		list.add(student1);
		list.add(student);
		List<String> set = list.stream().map(Student::getId).distinct().collect(Collectors.toList());
		System.out.println(set);
	}
}
