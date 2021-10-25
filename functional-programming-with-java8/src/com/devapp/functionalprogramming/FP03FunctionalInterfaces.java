package com.devapp.functionalprogramming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		
		Predicate<Integer> isEvenFunction = x->x%2==0;
		
	
		
		Function<Integer, ? extends Integer> squareFunction = x->x*x;
		
		
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		numbers.stream()
		.filter(isEvenFunction)
		.map(squareFunction)
		.forEach(sysoutConsumer);
		
		BinaryOperator<Integer> sumBinaryOperator = (x,y)-> x+y;
		
		int sum=numbers.stream()
				.reduce(0, sumBinaryOperator);
		System.out.println("sum "+sum);
	}
}
