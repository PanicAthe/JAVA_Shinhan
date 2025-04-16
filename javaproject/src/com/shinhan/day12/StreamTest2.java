package com.shinhan.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		f3();
	}

	private static void f3() {
		Random random = new Random();
		List<Integer> scores = new ArrayList<>();
		for(int i=0; i<100000000;i++) {
			scores.add(random.nextInt(101));
		}
		Stream<Integer> stream = scores.stream();
		long start = System.nanoTime();
		double avg = stream.mapToInt(i->i.intValue()).average().getAsDouble();
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("평균: "+avg+" 일반스트림으로 처리하는데 걸리는 시간: "+time);
		
	}

	private static void f2() {
		List<ShinhanStudent> arr = List.of(new ShinhanStudent("A", 100, "남"), new ShinhanStudent("B", 0, "여"),
				new ShinhanStudent("C", 70, "남"), new ShinhanStudent("A", 90, "여"), new ShinhanStudent("E", 40, "여"));

		Map<String, List<ShinhanStudent>> group = arr.stream().collect(Collectors.groupingBy(st -> st.getGender()));
		for (String key : group.keySet()) {
			System.out.println(key + "-->" + group.get(key));
		}

		Map<String, Double> group2 = arr.stream()
			    .collect(Collectors.groupingBy(
			        ShinhanStudent::getGender,                     // 그룹 기준 (성별)
			        Collectors.averagingDouble(ShinhanStudent::getScore)  // 그룹 안에서 평균 계산
			    ));

	}

	private static void f1() {
		List<Integer> list = new ArrayList();

		OptionalDouble op = list.stream().mapToInt(Integer::intValue).average();
		if (op.isPresent()) {
			System.out.println("방법1_평균: " + op.getAsDouble());
		} else {
			System.out.println("방법2_평균: 0.0");
		}

		double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println("방법2_평균: " + avg);
		list.stream().mapToInt(Integer::intValue).average().ifPresent(a -> System.out.println("방법3_평균: " + a));

	}

}
