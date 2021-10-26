package com.devapp.functionalprogramming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;

	private String category;

	private int reviewScore;

	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "Course: " + name + ":" + category + ":" + reviewScore + ":" + noOfStudents;
	}

}

public class FPCustomClass {
	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 2000),
				new Course("Spring Boot", "Framework", 95, 2500), new Course("API", "Microservices", 97, 2200),
				new Course("Microservices", "Microservices", 96, 1800), new Course("FullStack", "FullStack", 91, 22000),
				new Course("AWS", "Cloud", 92, 2000), new Course("Azure", "Cloud", 90, 21000),
				new Course("Docker", "Cloud", 93, 2000), new Course("Kubernates", "Cloud", 88, 2000));

		// allmatch, nomatch, anymatch
		Predicate<? super Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
		Predicate<? super Course> reviewScoreGreaterThan90 = course -> course.getReviewScore() > 90;
		Predicate<? super Course> reviewScorelessThan90 = course -> course.getReviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95));

		System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan90));

		System.out.println(courses.stream().anyMatch(reviewScorelessThan90));

		Comparator<Course> comparingByNoOfStudentsIncresing = Comparator.comparing(Course::getNoOfStudents);

		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();

		System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncresing).collect(Collectors.toList()));

		// output
		/*
		 * [Course: Microservices:Microservices:96:1800, Course:
		 * Spring:Framework:98:2000, Course: AWS:Cloud:92:2000, Course:
		 * Docker:Cloud:93:2000, Course: Kubernates:Cloud:88:2000, Course:
		 * API:Microservices:97:2200, Course: Spring Boot:Framework:95:2500, Course:
		 * Azure:Cloud:90:21000, Course: FullStack:FullStack:91:22000]
		 */
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

		/*
		 * [Course: FullStack:FullStack:91:22000, Course: Azure:Cloud:90:21000, Course:
		 * Spring Boot:Framework:95:2500, Course: API:Microservices:97:2200, Course:
		 * Spring:Framework:98:2000, Course: AWS:Cloud:92:2000, Course:
		 * Docker:Cloud:93:2000, Course: Kubernates:Cloud:88:2000, Course:
		 * Microservices:Microservices:96:1800]
		 */

		// comparing no of students and reviews
		Comparator<Course> comparingNoOfStudentsAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore).reversed();

		// Or
//		Comparator<Course> comparingNoOfStudentsAndNoOfReviews
//			=Comparator.comparingInt(Course:: getNoOfStudents)
//				.thenComparingInt(Course::getReviewScore)
//				.reversed();

		System.out.println(courses.stream().sorted(comparingNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));

		System.out.println(
				courses.stream().sorted(comparingNoOfStudentsAndNoOfReviews).limit(5).collect(Collectors.toList()));

		/*
		 * [Course: FullStack:FullStack:91:22000, Course: Azure:Cloud:90:21000, Course:
		 * Spring Boot:Framework:95:2500, Course: API:Microservices:97:2200, Course:
		 * Spring:Framework:98:2000]
		 * 
		 */
		
		//skip first five elements
		System.out.println(
				courses.stream().sorted(comparingNoOfStudentsAndNoOfReviews).skip(5).collect(Collectors.toList()));
		/*
		 * [Course: Docker:Cloud:93:2000, Course: AWS:Cloud:92:2000, Course:
		 * Kubernates:Cloud:88:2000, Course: Microservices:Microservices:96:1800]
		 */
		
		//skip first three elements and limit to 5 elements
		System.out.println(
				courses.stream().sorted(comparingNoOfStudentsAndNoOfReviews).skip(3).limit(5).collect(Collectors.toList()));
		
		System.out.println("courses--->"+courses);
		System.out.println(
				courses.stream()
					.takeWhile(c-> c.getReviewScore()>95)
					.collect(Collectors.toList())	
				);
		
		System.out.println(
				courses.stream()
					.dropWhile(c-> c.getReviewScore()>95)
					.collect(Collectors.toList())	
				);
		
		System.out.println(
				courses.stream()
				.max(comparingNoOfStudentsAndNoOfReviews)
				);
//		Optional[Course: Microservices:Microservices:96:1800]
		
		System.out.println(
				courses.stream()
				.min(comparingNoOfStudentsAndNoOfReviews)
				);
//		Optional[Course: FullStack:FullStack:91:22000]
		
		Predicate<? super Course> reviewScorelessThan10 = course -> course.getReviewScore() < 10;
		System.out.println(
				courses.stream()
				.filter(reviewScorelessThan10)
				.min(comparingNoOfStudentsAndNoOfReviews)
				.orElse(new Course("Kubernates", "Cloud", 90, 20100))
				);
//		Optional.empty
//		Course: Kubernates:Cloud:90:20100
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan90).findFirst()
				);//Optional[Course: Spring:Framework:98:2000]
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan90).findAny()
				);//Optional[Course: Spring:Framework:98:2000]
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan90)
				.mapToInt(Course::getNoOfStudents)
				.sum()
				);//34500
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan90)
				.mapToInt(Course::getNoOfStudents)
				.average()
				);//OptionalDouble[4928.571428571428]
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan90)
				.mapToInt(Course::getNoOfStudents)
				.count()
				);//7
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan90)
				.mapToInt(Course::getNoOfStudents)
				.max()
				);//OptionalInt[22000]
		
		System.out.println(
		courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory)));
		
		/*
		 * {Cloud=[Course: AWS:Cloud:92:2000, Course: Azure:Cloud:90:21000, Course:
		 * Docker:Cloud:93:2000, Course: Kubernates:Cloud:88:2000], FullStack=[Course:
		 * FullStack:FullStack:91:22000], Microservices=[Course:
		 * API:Microservices:97:2200, Course: Microservices:Microservices:96:1800],
		 * Framework=[Course: Spring:Framework:98:2000, Course: Spring
		 * Boot:Framework:95:2500]}
		 */
		
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
//		{Cloud=4, FullStack=1, Microservices=2, Framework=2}
				
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory,
							Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		/*
		 * {Cloud=Optional[Course: Docker:Cloud:93:2000], FullStack=Optional[Course:
		 * FullStack:FullStack:91:22000], Microservices=Optional[Course:
		 * API:Microservices:97:2200], Framework=Optional[Course:
		 * Spring:Framework:98:2000]}
		 */
		System.out.println(
				courses.stream()
					.collect(Collectors.groupingBy(Course::getCategory,
							Collectors.mapping(Course::getName, Collectors.toList()))));
		
		/*
		 * {Cloud=[AWS, Azure, Docker, Kubernates], FullStack=[FullStack],
		 * Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
		 */
		
	}
}
