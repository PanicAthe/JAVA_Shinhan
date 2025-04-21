package com.shinhan.day13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Score 클래스는 직렬화를 지원하는 데이터 모델
 */
@Data
@Builder
@RequiredArgsConstructor // final 필드만 매개변수로 받는 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
class Score implements Serializable { // 객체 직렬화를 위해 Serializable 구현
	// 직렬화 대상 필드 (모두 인스턴스 변수)
	final String name;
	final int java;
	final int db;
	final int web;

	// static은 클래스 변수이므로 직렬화 대상이 아님 (기본적으로 직렬화 제외)
	static String major = "전공";

	// 일반 인스턴스 필드 → 직렬화 대상
	String gender;

	// transient 키워드는 해당 필드를 직렬화에서 제외
	// → 저장되지 않음, 읽어오면 null 또는 초기값
	transient String hobby;
}

/**
 * 객체 직렬화 예제
 */
public class Serialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		f2();
	}

	private static void f2() throws IOException, ClassNotFoundException {
		// 🔽 Score 객체들을 담은 리스트 생성
		List<Score> scoreList = new ArrayList<>();
		scoreList.add(Score.builder().name("홍길동").java(90).db(80).web(70).gender("남").hobby("독서").build());
		scoreList.add(Score.builder().name("김영희").java(85).db(90).web(75).gender("여").hobby("요리").build());
		scoreList.add(Score.builder().name("이철수").java(70).db(60).web(80).gender("남").hobby("축구").build());

		// 🔽 리스트를 파일에 저장 (직렬화)
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("scoreList.data"))) {
			oos.writeObject(scoreList); // List<Score> 객체 직렬화
		}

		// 🔽 저장된 리스트 복원 (역직렬화)
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("scoreList.data"))) {
			List<Score> readList = (List<Score>) ois.readObject(); // List<Score> 타입으로 캐스팅

			System.out.println("복원된 Score 리스트:");
			for (Score s : readList) {
				System.out.println(s); // toString() 출력, transient 필드는 null
			}
		}
	}

	private static void f1() throws IOException, ClassNotFoundException {
		// 🔽 객체를 파일에 저장하기 (직렬화)
		FileOutputStream fw = new FileOutputStream("score.data"); // 바이트 기반 파일 출력 스트림
		ObjectOutputStream oos = new ObjectOutputStream(fw); // 객체를 파일에 쓰기 위한 스트림

		// Score 객체 생성 (Builder 사용)
		Score score1 = Score.builder().name("강아지").java(100).db(20).web(80).gender("남자").hobby("운동") // transient 필드 →
																										// 저장 안 됨
				.build();

		oos.writeObject(score1); // 객체를 파일에 저장 (직렬화)
		oos.close(); // 리소스 해제
		fw.close();

		// 🔽 저장된 객체 파일에서 읽어오기 (역직렬화)
		FileInputStream fis = new FileInputStream("score.data"); // 바이트 기반 파일 입력 스트림
		ObjectInputStream ois = new ObjectInputStream(fis); // 객체를 파일에서 읽기 위한 스트림

		Score score2 = (Score) ois.readObject(); // 역직렬화 → 객체 복원
		System.out.println(score2.toString()); // toString 출력 (hobby는 null일 것)
		System.out.println(score2.hobby); // null
		ois.close(); // 리소스 해제
		fis.close();
	}
}
