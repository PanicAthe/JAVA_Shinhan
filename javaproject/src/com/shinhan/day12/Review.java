package com.shinhan.day12;

import java.util.*;

import lombok.Builder;
import lombok.Data;

public class Review {
    public static void main(String[] args) {

        // ✅ Collection 인터페이스 계열
        // List: 순서 O, 중복 허용
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new Vector<>(); // Vector는 Thread-safe

        // Set: 순서 X, 중복 허용 안 함
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>(); // TreeSet은 정렬됨 (Comparable 또는 Comparator 필요)

        // Map: key-value 쌍 구조 (key는 중복 불가)
        Map<String, Integer> map1 = new HashMap<>();     // 비동기, 빠름
        Map<String, Integer> map2 = new Hashtable<>();   // 동기, Thread-safe
        Map<String, Integer> map3 = new TreeMap<>();     // 정렬됨 (key 기준)

        // Stack & Queue
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        // ▶ Book 객체를 TreeSet에 저장 (정렬 기준: price 오름차순)
        Set<Book> bookSet = new TreeSet<>();
        bookSet.add(new Book("A", 100));
        bookSet.add(new Book("B", 120));
        bookSet.add(new Book("C", 90));

        System.out.println("📚 TreeSet<Book> (price 오름차순):");
        for (Book book : bookSet) {
            System.out.println(book);
        }

        // ▶ Book 객체를 TreeMap의 key로 사용
        Map<Book, Integer> bookMap = new TreeMap<>();
        bookMap.put(new Book("A", 100), 1);
        bookMap.put(new Book("B", 150), 3);
        bookMap.put(new Book("C", 110), 2);

        System.out.println("\n📚 TreeMap<Book, Integer> (key = Book, 정렬 기준: price):");
        for (Map.Entry<Book, Integer> entry : bookMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}

@Data // getter, setter, toString, equals, hashCode 자동 생성
@Builder
class Book implements Comparable<Book> {
    String title;
    int price;

    // 정렬 기준: 가격 오름차순
    @Override
    public int compareTo(Book o) {
        return this.price - o.price;
    }
}
