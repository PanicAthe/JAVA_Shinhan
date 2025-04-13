package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "stdId")
@ToString
@AllArgsConstructor
public class StudentDTO {

	private final String stdId;
	private final String name;
	private String major;
	private int grade;

}
