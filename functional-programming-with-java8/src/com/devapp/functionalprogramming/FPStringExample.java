package com.devapp.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FPStringExample {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservice", "AWS", "PCF", "AZURE", "DOCKER",
				"KUBERNATES");
		
		List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservice", "AWS", "PCF", "AZURE", "DOCKER",
				"KUBERNATES");
		
		System.out.println(
				courses.stream().collect(Collectors.joining(" "))
				);
		System.out.println(
				courses.stream().collect(Collectors.joining(","))
				);
		System.out.println(
				courses.stream()
				.map(c ->c.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream()
				.flatMap(course ->courses2.stream().map(c->List.of(course, c))).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream()
				.flatMap(course ->courses2.stream().map(c->List.of(course, c))).filter(l->l.get(0).equals(l.get(1))).collect(Collectors.toList())
				);
		
		System.out.println(
				courses.stream()
				.flatMap(course ->courses2.stream().map(c->List.of(course, c))).filter(l->!l.get(0).equals(l.get(1))).collect(Collectors.toList())
				);
		System.out.println(
				courses.stream()
				.flatMap(course ->courses2.stream()
						.filter(course2 -> course2.length()==course.length())
						.map(c->List.of(course, c))).filter(l->!l.get(0).equals(l.get(1))).collect(Collectors.toList())
				);
	}
}
