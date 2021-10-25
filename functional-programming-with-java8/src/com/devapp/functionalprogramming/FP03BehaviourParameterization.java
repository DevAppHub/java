package com.devapp.functionalprogramming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 3, 5, 4, 7, 15, 12, 6);

		filterAndPrint(numbers, x -> x % 2 == 0);

		filterAndPrint(numbers, x -> x % 2 != 0);
		
		Function<? super Integer, ? extends Integer> mapper = x->x*x;
		List<Integer> list = mapAndCreateNewList(numbers, mapper);
		System.out.println(list);

	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> mapper) {
		return numbers.stream().map(mapper).collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream().filter(predicate).forEach(System.out::println);
	}
}
