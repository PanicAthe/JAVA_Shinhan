package com.shinhan.day09;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentService {

	StudentDAO dao;

	public StudentDTO[] findAll() {
		System.out.println("==모든 학생 조회==");
		return dao.selectAll();
	}

	public StudentDTO findById(String stdId) {
		System.out.println("==특정 학생 조회==");
		return dao.selectById(stdId);
	}

}
