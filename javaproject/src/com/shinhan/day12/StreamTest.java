package com.shinhan.day12;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) throws URISyntaxException, IOException {
		f12();
	}

	private static void f12() {
		int[] arr = { 100, 20, 30, 40, 50 };
		Arrays.stream(arr).forEach(score->System.out.println(score));
		boolean result = Arrays.stream(arr).allMatch(score->score>=20);
	}

	private static void f11() {
		ShinhanStudent[] arr = { new ShinhanStudent("A", 100, null), new ShinhanStudent("B", 0, null), new ShinhanStudent("C", 70, null),
				new ShinhanStudent("A", 90, null), new ShinhanStudent("E", 40, null) };

		List<ShinhanStudent> data = Arrays.asList(arr);
		data.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(st -> System.out.println(st));
	}

	private static void f10() {
		// ✅ 리스트 안에 문자열 형태의 숫자 집합이 들어 있음
		// 각 문자열은 쉼표로 구분된 숫자들
		List<String> alist = Arrays.asList("10,20,30", "40,50");

		alist.stream()
				// ✅ flatMapToInt: 각 문자열 요소를 IntStream으로 변환 → 하나의 IntStream으로 평탄화
				.flatMapToInt(s ->
				// s는 예: "10,20,30"
				Arrays.stream(s.split(",")) // "10,20,30" → ["10", "20", "30"] (String[])
						.mapToInt(Integer::parseInt) // 문자열 배열 → 정수 스트림
				// "10" → 10, "20" → 20, ...
				)

				// ✅ 최종 처리: 각 숫자를 출력
				.forEach(System.out::println);
		// method reference 사용 (a -> System.out.println(a) 와 동일)
	}

	private static void f9() {
		List<String> alist = new ArrayList<>();
		alist.add("This is java");
		alist.add("I am the best developer");

		// flatMap을 통해 문장 → 단어로 평탄화
		alist.stream().flatMap(st -> Arrays.stream(st.split(" "))) // 단어 단위 스트림
				.forEach(word -> {
					System.out.println("📌 단어: " + word);
				});
	}

	private static void f8() {
		int[] arr = { 1, 2, 3, 4, 5 };
		Arrays.stream(arr)
				// .boxed()
				// .asDoubleStream()
				.forEach(i -> System.out.println(i));
	}

	private static void f7() {
		ShinhanStudent[] arr = { new ShinhanStudent("A", 100, null), new ShinhanStudent("B", 0, null), new ShinhanStudent("C", 70, null),
				new ShinhanStudent("D", 90, null), new ShinhanStudent("E", 40, null) };

		List<ShinhanStudent> data = Arrays.asList(arr);
		data.stream().mapToInt(st -> st.getScore()).filter(score -> score > 70).forEach(st -> {
			System.out.println(st);
		});

	}

	private static void f6() {
		// 중복된 데이터 리스트
		List<String> alist = List.of("2월", "화", "2월", "2화", "2수", "목", "금");
		alist.stream().distinct().filter(s -> s.startsWith("2")).forEach(s -> {
			System.out.println(s);
		});
	}

	private static void f5() throws URISyntaxException, IOException {
		Class cls = StreamTest.class;
		Path path = Paths.get(cls.getResource("data.txt").toURI());
		Stream<String> st = Files.lines(path);
		st.forEach(s -> {
			System.out.println(s);
		});
	}

	static int sum = 0;

	private static void f4() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			sum += i;
			System.out.println(i);
		});
		System.out.println("합계 " + sum);
	}

	private static void f3() {
		// ✅ 학생 객체 배열 생성
		ShinhanStudent[] arr = { new ShinhanStudent("A", 100, null), new ShinhanStudent("B", 0, null), new ShinhanStudent("C", 70, null),
				new ShinhanStudent("D", 90, null), new ShinhanStudent("E", 40, null) };

		// ✅ 배열을 리스트로 변환 (stream 사용을 위해)
		List<ShinhanStudent> data = Arrays.asList(arr);

		// ✅ 스트림으로 점수만 추출
		// 1. ShinhanStudent → int 로 변환 (mapToInt 사용)
		// 2. IntStream → 숫자 전용 스트림 (성능, 기능 ↑)
		IntStream scores = data.stream().mapToInt(student -> student.getScore());

		// ✅ 평균 계산
		// average()는 OptionalDouble 반환 → 값이 없을 수도 있기 때문
		double avg = scores.average().orElse(0.0); // orElse: 값이 없으면 0.0 반환

		System.out.println("📊 학생 점수 평균: " + avg);
	}

	private static void f2() {
		// ✅ 고정된 리스트 (불변 리스트)
		List<String> alist = List.of("월", "화", "수", "목", "금");

		// ✅ 1. 일반 스트림 (순차 처리)
		// → 한 개의 스레드(main thread)가 순서대로 처리
		System.out.println("✅ 일반 스트림 실행:");
		alist.stream().forEach(s -> System.out.println(Thread.currentThread().getName() + " : " + s + "요일"));

		System.out.println("-------------------------------");

		// ✅ 2. 병렬 스트림 (parallelStream)
		// → 내부적으로 여러 스레드가 데이터를 나눠 병렬 처리
		// → 순서는 보장되지 않음
		System.out.println("✅ 병렬 스트림 실행:");
		alist.parallelStream().forEach(s -> System.out.println(Thread.currentThread().getName() + " : " + s + "요일"));

		// 참고:
		// - 순서가 중요하다면 forEachOrdered() 사용
		// - 병렬 스트림은 CPU 코어 수가 많은 경우 성능 향상이 있지만,
		// 작은 작업이나 순서가 중요한 경우에는 일반 스트림이 더 적합할 수 있음
	}

	private static void f1() {
		// ✅ 배열 선언
		int[] arr = { 10, 20, 33 };

		// ✅ 스트림 생성 (배열을 기반으로 IntStream 생성)
		// Arrays.stream(arr)는 IntStream을 반환
		// IntStream은 기본형 int를 위한 스트림 (성능 ↑)

		// ✅ 내부 반복자 (forEach) 사용
		// - forEach: 스트림의 각 요소에 대해 동작을 수행 (람다식으로 동작 정의)
		// - forEach vs forEachOrdered:
		// → forEach는 순서 보장 X (병렬 스트림에서)
		// → forEachOrdered는 순서 보장 O

		// 아래는 람다식으로 각 요소를 출력
		Arrays.stream(arr).forEachOrdered(i -> System.out.println("값: " + i));

		// ✅ IntConsumer 활용 예 (람다식이 내부적으로 이 인터페이스 구현)
		IntConsumer consumer = i -> System.out.println("소비된 값: " + i);
		Arrays.stream(arr).forEach(consumer); // 위 람다식과 동일한 의미
	}
}
