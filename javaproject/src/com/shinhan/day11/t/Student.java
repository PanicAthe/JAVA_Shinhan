package com.shinhan.day11.t;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student implements Comparable<Student>{

	String stdId;
	String name;
	String major;
	int score;
	
	@Override
	public int compareTo(Student obj) {
		int comp1 = obj.score - score;
		if(comp1 == 0) {
			int comp2 =  major.compareTo(obj.major); 
			if(comp2 == 0 ) return obj.stdId.compareTo(stdId);
			return comp2;
		}
		return comp1;
	}
}

/*
학생이 5명있다.
조회하면 점수순으로 desc
같은점수이면 전공 asc
전공같으면 학번 desc
--------------------------나(this)먼저 작성하고 들어온data(매개변수)작성하면 ASC
--------------------------반대는 DESC
*/




