package com.devapp.functionalprogramming;

//print all the elements in list in functional way
import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		printAllNumbersInListFunctional(numbers);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
//		numbers.stream()
//			.forEach(FP01Functional::print);  //Method reference
		//OR
		numbers.stream()
			.forEach(System.out::println);
		
		//print only even numbers
//		numbers.stream()
//		.filter(FP01Functional:: isEven) //filter only allow even numbers
//		.forEach(System.out::println);
		
		//print only even numbers using lambda expression
				numbers.stream()
				.filter(n -> n%2==0) //filter only allow even numbers
				.forEach(System.out::println);
	}
	
//	private static boolean isEven(int num) {
//		return num%2==0;
//	}
	
//	private static void print(int n) {
//		System.out.println(n);
//	}
}
