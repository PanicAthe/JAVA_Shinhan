package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Board implements Comparable<Board>{
	private String subject;
	private String content;
	private String writer;
	
	@Override
	public int compareTo(Board obj) {
		
		int comp1 = writer.compareTo(obj.writer);	
		if(comp1 == 0) {
			return obj.subject.compareTo(subject);
		}
		
		return comp1;
	}

}
