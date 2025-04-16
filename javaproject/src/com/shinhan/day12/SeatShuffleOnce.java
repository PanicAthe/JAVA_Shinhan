package com.shinhan.day12;

import java.util.*;

public class SeatShuffleOnce {
    static final int ROWS = 7; // 행 수 (줄 수)
    static final int COLS = 4; // 열 수 (한 줄당 인원 수)

    // 총 28명 학생 이름 배열
    static String[] names = {
        "김민수", "이서윤", "박지후", "최지우",
        "정하늘", "한예진", "장도윤", "윤지호",
        "서하준", "이재희", "최은진", "김세연",
        "오지안", "강하율", "신유나", "조민재",
        "이채원", "황윤서", "문지우", "송다온",
        "백승우", "구지민", "홍지아", "정서윤",
        "차은우", "표지훈", "전하린", "남도현"
    };

    public static void main(String[] args) {
        // 1. 기존 줄에서 함께 앉았던 사람 기록
        Map<String, Set<String>> previousRowPartners = new HashMap<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                String student = names[i * COLS + j]; // 현재 학생
                previousRowPartners.putIfAbsent(student, new HashSet<>());

                // 같은 줄에 있는 다른 학생들 추가 (같은 줄의 친구들)
                for (int k = 0; k < COLS; k++) {
                    if (k != j) {
                        previousRowPartners.get(student).add(names[i * COLS + k]);
                    }
                }
            }
        }

        // 2. 새롭게 셔플된 자리 생성
        List<String> shuffled = new ArrayList<>(Arrays.asList(names));
        List<List<String>> newSeating;

        do {
            // 리스트 무작위 섞기
            Collections.shuffle(shuffled);

            // 줄(row)로 나누기: 4명씩 잘라서 7줄 만들기
            newSeating = new ArrayList<>();
            for (int i = 0; i < ROWS; i++) {
                newSeating.add(new ArrayList<>(shuffled.subList(i * COLS, (i + 1) * COLS)));
            }

        } while (!isValidSeating(newSeating, previousRowPartners)); // 유효하지 않으면 다시 섞기

        // 3. 최종 자리 출력
        System.out.println("==== 새로운 자리 배정 ====");
        for (int i = 0; i < ROWS; i++) {
            System.out.printf("%d줄: %s%n", i + 1, String.join(", ", newSeating.get(i)));
        }
    }

    /**
     * 이번 셔플된 자리 배정이 유효한지 검사하는 함수
     * 조건: 이전 줄에서 같이 앉았던 두 사람이 또 같은 줄에 오면 안 됨
     */
    static boolean isValidSeating(List<List<String>> seating, Map<String, Set<String>> history) {
        for (List<String> row : seating) {
            for (int i = 0; i < row.size(); i++) {
                for (int j = i + 1; j < row.size(); j++) {
                    String a = row.get(i);
                    String b = row.get(j);
                    // a와 b가 이전에 같은 줄이었는지 확인
                    if (history.get(a).contains(b)) {
                        return false; // 유효하지 않음 (같은 줄 반복됨)
                    }
                }
            }
        }
        return true; // 모두 유효함
    }
}
