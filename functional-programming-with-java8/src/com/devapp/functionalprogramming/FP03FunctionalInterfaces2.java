package com.devapp.functionalprogramming;

import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FP03FunctionalInterfaces2 {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);
		
		
		Predicate<Integer> isEvenPredicate=new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t%2==0;
			}
		};
		
		
		Function<Integer, Integer> squareFunction2=new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t*t;
			}
		};
		
		
		Consumer<Integer> sysoutConsumer2=new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		
		numbers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction2)
		.forEach(sysoutConsumer2);
		
		
		BinaryOperator<Integer> sumBinaryOperator2=new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer a, Integer b) {
				return a+b;
			}
		};
		
		int sum=numbers.stream()
				.reduce(0, sumBinaryOperator2);
		System.out.println("sum "+sum);
		
		Supplier<Integer> randomIntegerSupplier=()->{
			Random random=new Random();
			return random.nextInt(1000);
		};
		System.out.println(randomIntegerSupplier.get());
}
}
