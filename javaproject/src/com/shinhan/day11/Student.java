package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Student implements Comparable<Student> {
	String stdId;
	String name;
	String major;
	int score;

	@Override
	public int compareTo(Student o) {
		// 점수 내림차순
		if (this.score != o.score) {
			return o.score - this.score; // 점수 높은 게 먼저 오도록
		}

		// 점수가 같으면 전공 오름차순
		int majorCompare = this.major.compareTo(o.major);
		if (majorCompare != 0) {
			return majorCompare;
		}

		// 전공도 같으면 학번 내림차순
		return o.stdId.compareTo(this.stdId);
	}

}
