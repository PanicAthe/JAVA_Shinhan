package com.shinhan.day12;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShinhanStudent implements Comparable<ShinhanStudent>{
	String name;
	int score;
	String gender;
	@Override
	public int compareTo(ShinhanStudent o) {
		return this.score - o.score;
	}
}
