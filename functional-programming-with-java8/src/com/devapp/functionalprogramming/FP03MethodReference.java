package com.devapp.functionalprogramming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReference {
	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservice", "AWS", "PCF", "AZURE", "DOCKER",
				"KUBERNATES");
		
		courses.stream().map(str-> str.toUpperCase()).forEach(System.out::println);
		
		//OR
		
		courses.stream()
		.map(String::toUpperCase).forEach(FP03MethodReference::print);
		
		Supplier<String> supplier=String::new;
	}
	
	private static void print(String str) {
		System.out.println(str);
	}
}
