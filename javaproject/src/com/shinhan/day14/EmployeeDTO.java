package com.shinhan.day14;

//데이터를 transfer 할때 
public class EmployeeDTO {
	private int employee_id; // EMPLOYEE_ID
	private String first_name; // FIRST_NAME
	private String last_name; // LAST_NAME
	private String email; // EMAIL
	private String phone_number; // PHONE_NUMBER
	private java.sql.Date hire_date; // HIRE_DATE
	private String job_id; // JOB_ID
	private double salary; // SALARY
	private Double commission_pct; // COMMISSION_PCT (nullable)
	private Integer manager_id; // MANAGER_ID (nullable)
	private Integer department_id; // DEPARTMENT_ID (nullable)
}
