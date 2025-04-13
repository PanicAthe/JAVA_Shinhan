package com.shinhan.day09;

class NotExistIDException extends Exception {
	public NotExistIDException() {
		super("존재하지 않는 아이디입니다.");
	}

	public NotExistIDException(String message) {
		super(message);
	}
}

class WrongPasswordException extends Exception {
	public WrongPasswordException() {
		super("틀린 비밀번호 입니다.");
	}

	public WrongPasswordException(String message) {
		super(message);
	}
}

public class LoginExample {
	public static void main(String[] args) {

		try {
			//login("white", "12345");
			login("blue", "54321");
		} catch (NotExistIDException|WrongPasswordException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}finally {
			System.out.println("끝");
		}
	}

	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
		// id가 blue가 아니라면 NotExistIDException을 발생시킴
		if (!id.equals("blue")) {
			throw new NotExistIDException();

		}
		// password가 12345가 아니라면 WrongPasswordException을 발생시킴
		if (!password.equals("12345")) {
			throw new WrongPasswordException();
		}
	}
}
