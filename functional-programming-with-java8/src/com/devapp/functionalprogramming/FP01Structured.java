package com.devapp.functionalprogramming;

//print all the elements in list in stuctured way
import java.util.List;

public class FP01Structured {
	public static void main(String[] args) {
		printAllNumbersInListStructured(List.of(12, 3, 5, 4, 7, 15, 12, 6));
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// Traditional Way
		for (Integer num : numbers) {
			System.out.println(num);
		}
		
		//print only even number
		for (Integer integer : numbers) {
			if(integer%2==0) {
				System.out.println("only even numbers"+integer);
			}
		}
		
	}

}
