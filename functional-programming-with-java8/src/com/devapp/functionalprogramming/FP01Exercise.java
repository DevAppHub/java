package com.devapp.functionalprogramming;

import java.util.List;

public class FP01Exercise {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservice", "AWS", "PCF", "AZURE", "DOCKER",
				"KUBERNATES");
		functionalExampleWithString(courses);

		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		functionalExampleWithIntegers(numbers);
	}

	private static void functionalExampleWithIntegers(List<Integer> numbers) {
		System.out.println("Cube of Odd Numbers");
		numbers.stream().filter(n -> n % 2 != 0)// filter only allow odd numbers
				.map(n -> n * n * n).forEach(System.out::println);
	}

	private static void functionalExampleWithString(List<String> courses) {
		
		// print list of courses
		System.out.println("List Of Courses");
		courses.stream().forEach(System.out::println);
		
		// print Courses containing the word "Spring"
		System.out.println("List Of Courses which conatains spring");
		courses.stream().filter(c -> c.contains("Spring")).forEach(System.out::println);

		// print courses whose name has atleast 4 letters
		System.out.println("List Of Courses whose name has atleast four letter");
		courses.stream().filter(c -> c.length() >= 4).forEach(System.out::println);
		
		//print the number of characters for each courses
		System.out.println("Length of each courses");
		courses.stream().map(c -> c.length()).forEach(System.out::println);
	}
}
