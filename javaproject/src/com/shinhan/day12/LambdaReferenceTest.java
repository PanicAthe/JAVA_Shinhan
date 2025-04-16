package com.shinhan.day12;

@FunctionalInterface
interface Calculable {
    double calc(double x, double y);
}

class Person {
    double action(Calculable calculable) {
        double result = calculable.calc(10, 4);
        System.out.println("계산 결과: " + result);
        return result;
    }
}

class Computer {
    static double staticMethod(double x, double y) {
        return x + y;
    }

    double instanceMethod(double x, double y) {
        return x * y;
    }
}

// 생성자 참조를 위한 클래스
class Message {
    String content;

    public Message(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println("📨 메시지: " + content);
    }
}

@FunctionalInterface
interface MessageFactory {
    Message create(String content);
}

public class LambdaReferenceTest {

    public static void main(String[] args) {
        methodReferenceTest();
        constructorReferenceTest();
    }

    private static void methodReferenceTest() {
        Person p = new Person();

        // 정적 메서드 참조
        p.action(Computer::staticMethod); // 10 + 4

        // 인스턴스 메서드 참조
        Computer c = new Computer();
        p.action(c::instanceMethod);      // 10 * 4
    }

    private static void constructorReferenceTest() {
        // 생성자 참조: 클래스명::new
        MessageFactory factory = Message::new;
        Message msg = factory.create("람다로 생성한 메시지입니다!");
        msg.print(); // 📨 메시지: 람다로 생성한 메시지입니다!
    }
}

