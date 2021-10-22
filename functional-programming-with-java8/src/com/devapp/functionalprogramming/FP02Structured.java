package com.devapp.functionalprogramming;


import java.util.List;

public class FP02Structured {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		int sum = addListStructured(numbers);
		System.out.println("Sum--->>" + sum);
	}

	private static int addListStructured(List<Integer> numbers) {
		int sum = 0;
		for (Integer n : numbers) {
			sum += n;
		}
		return sum;
	}

}
