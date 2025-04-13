package com.shinhan.day09;

public class StudentDAO {

	StudentDTO[] arr = new StudentDTO[5];

	{
		arr[0] = new StudentDTO("12345", "강아지", "식품영양과", 5);
		arr[1] = new StudentDTO("12346", "고양이", "해양생물과", 1);
		arr[2] = new StudentDTO("12347", "햄스터");
		arr[3] = new StudentDTO("12348", "친칠라");
		arr[4] = new StudentDTO("12349", "원숭이");
	}

	public StudentDTO[] selectAll() {
		return arr;
	}

	public StudentDTO selectById(String stdId) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getStdId().equals(stdId)) {
				return arr[i];
			}
		}
		return null;

	}
}
