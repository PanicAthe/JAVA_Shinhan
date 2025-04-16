package com.shinhan.day12;

public class Button {

    // ✅ 1. 내부 인터페이스: 클릭 이벤트 리스너
	@FunctionalInterface
    public static interface ClickListener {
        public abstract void onClick();
    }

    // ✅ 2. 필드: 클릭 리스너를 담을 변수
    private ClickListener clickListener;

    // ✅ 3. 리스너를 등록하는 메서드
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // ✅ 4. 버튼 클릭 시 호출되는 메서드
    public void click() {
        if (clickListener != null) {
            clickListener.onClick();
        }
    }
}
