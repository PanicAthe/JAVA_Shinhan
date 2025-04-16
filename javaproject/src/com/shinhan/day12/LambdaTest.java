package com.shinhan.day12;

@FunctionalInterface
interface MyInterface1 {
    int add(int a, int b);
}

@FunctionalInterface
interface MyInterface {
    void work();
}

class MyImpl implements MyInterface {
    @Override
    public void work() {
        System.out.println("일반 클래스에서 work() 실행");
    }
}

public class LambdaTest{
    public static void main(String[] args) {
        f1();  // 함수형 인터페이스 구현 방식
        f2();  // 람다식 실습
    }

    private static void f1() {
        // 1. 일반 클래스 구현
        MyInterface a = new MyImpl();

        // 2. 익명 클래스 구현
        MyInterface a2 = new MyInterface() {
            @Override
            public void work() {
                System.out.println("익명 클래스에서 work() 실행");
            }
        };

        // 3. 람다식 구현
        MyInterface a3 = () -> System.out.println("람다식으로 구현된 work()");

        test(a);
        test(a2);
        test(a3);
    }

    private static void f2() {
        // 한 줄 표현
        MyInterface1 a = (x, y) -> x + y;

        // 여러 줄 표현
        MyInterface1 a2 = (x, y) -> {
            System.out.println("람다 내부 로직 실행");
            return x + y;
        };

        System.out.println("a.add(3, 5) = " + a.add(3, 5));
        System.out.println("a2.add(10, 20) = " + a2.add(10, 20));
    }

    private static void test(MyInterface aa) {
        aa.work();
    }
}
