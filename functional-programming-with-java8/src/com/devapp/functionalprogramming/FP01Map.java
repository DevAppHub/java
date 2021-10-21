package com.devapp.functionalprogramming;

import java.util.List;

public class FP01Map {
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		printSquareOfEvenNumbers(numbers);
	}

	private static void printSquareOfEvenNumbers(List<Integer> numbers) {

		// print the squares of even number
		numbers.stream()
				.filter(n -> n % 2 == 0)// filter only allow even numbers
				.map(n -> n * n)
				.forEach(System.out::println);
	}
}
