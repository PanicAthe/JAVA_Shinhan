package com.shinhan.day12;

public class ButtonExample {

	public static void main(String[] args) {
		Button btn = new Button();

		// ✅ 익명 클래스 방식
		btn.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("버튼 클릭됨 (익명 클래스)");
			}
		});
		btn.click();

		// ✅ 람다식 방식 (ClickListener가 함수형 인터페이스이므로 가능)
		btn.setClickListener(() -> {
			System.out.println("버튼 클릭됨 (람다)");
		});
		btn.click();

	}

	public void work(Button.ClickListener lis) {
		Button b = new Button();
		b.setClickListener(lis);
		b.click();
	}
}
