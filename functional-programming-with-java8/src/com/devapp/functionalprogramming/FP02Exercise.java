package com.devapp.functionalprogramming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercise {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		int sum = sumOfSquareOfEveryNumber(numbers);
		System.out.println("sum of square of each numbers-->" + sum);

		sum = sumOfCubeOfEachNumber(numbers);
		System.out.println("sum of cube of each numbers-->" + sum);

		sum = sumOfOddNumbers(numbers);
		System.out.println("sum of odd numbers-->" + sum);
		
		List<Integer> evenList = filterListOfEvenNumbers(numbers);
		System.out.println("even number list -->" + evenList);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservice", "AWS", "PCF", "AZURE", "DOCKER",
				"KUBERNATES");
		
		//sort courses in natural order
		sortCoursesInNaturalOrder(courses);
		sortCoursesInReverseOrder(courses);
		sortCoursesBasedOnLengthOfString(courses);
		listOfCharactersLength(courses);
	}

	

	private static void listOfCharactersLength(List<String> courses) {
		List<Integer> list = courses.stream().map(x -> x.length()).collect(Collectors.toList());
		System.out.println("list--->"+list);
		
	}



	private static List<Integer> filterListOfEvenNumbers(List<Integer> numbers) {
		return numbers.stream()
				.filter(n -> n%2==0)
				.collect(Collectors.toList());
	}


	private static void sortCoursesBasedOnLengthOfString(List<String> courses) {
		System.out.println("courses sorted based on length of each character");
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}

	private static void sortCoursesInReverseOrder(List<String> courses) {
		System.out.println("courses sorted in reverse order");
		courses.stream()
			.sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	private static void sortCoursesInNaturalOrder(List<String> courses) {
		System.out.println("courses sorted in natural order");
//		courses.stream()
//			.sorted().forEach(System.out::println);
//		OR
		courses.stream()
			.sorted(Comparator.naturalOrder()).forEach(System.out::println);
	}

	private static int sumOfOddNumbers(List<Integer> numbers) {
		return numbers.stream().filter(n -> n % 2 ==1).reduce(0, Integer::sum);
	}

	private static int sumOfCubeOfEachNumber(List<Integer> numbers) {
		return numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
	}

	private static int sumOfSquareOfEveryNumber(List<Integer> numbers) {
		return numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
	}
}
