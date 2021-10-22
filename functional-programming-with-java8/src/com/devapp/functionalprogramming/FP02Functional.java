package com.devapp.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		int sum = addListFunctional(numbers);
		System.out.println("Sum--->>" + sum);
		
		//find distinct numbers from list
		findDistinctNumbersInList(numbers);
		
		//sorted List
		sortList(numbers);
		
		List<Integer> doubleNumbers=doubleList(numbers);
		System.out.println("double numbers"+doubleNumbers);
	}

	private static List<Integer> doubleList(List<Integer> numbers) {
		
		return numbers.stream()
					.map(x-> x*x).collect(Collectors.toList());
	}

	private static void sortList(List<Integer> numbers) {
		numbers.stream().sorted()
		.forEach(System.out::println);
	}

	private static void findDistinctNumbersInList(List<Integer> numbers) {
		numbers.stream().distinct()
				.forEach(System.out::println);
	}

	private static int sum(int a, int b) {
		System.out.println(a + "  " + b);
		return a + b;
	}

	private static int addListFunctional(List<Integer> numbers) {
//		return numbers.stream()
//				.reduce(0,  FP02Functional::sum);
//		OR
//		return numbers.stream()
//				.reduce(0, (x,y)->x+y);

//		OR
		return numbers.stream().reduce(0, Integer::sum);
	}
}
