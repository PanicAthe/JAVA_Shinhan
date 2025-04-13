package com.shinhan.day09;

//mvc
//m : 모델, dto, dao, service
//v : view
//c : controller
public class StudentController {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO();
		StudentService service = new StudentService(dao);

		StudentDTO[] arr = service.findAll();
		StudentView.print(arr);
		
		StudentView.print(service.findById("12345"));
		
		StudentDTO a = new StudentDTO("12347", "햄스터");
		StudentDTO b = new StudentDTO("12347", "햄스터2");
		System.out.println(a.equals(b));


	}

}
