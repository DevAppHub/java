package com.devapp.functionalprogramming;

import java.util.List;

public class FP02Functional {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		int sum = addListFunctional(numbers);
		
		System.out.println("Sum--->>"+sum);
	}

	private static int sum(int a, int b) {
		return a+b;
	}
	
	private static int addListFunctional(List<Integer> numbers) {
		return numbers.stream().reduce(0,  FP02Functional::sum);
	}
}
