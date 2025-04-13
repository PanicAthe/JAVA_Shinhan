package com.shinhan.day09.homework;

import java.util.Scanner;

public class LAB4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("암호화할 문자열: ");
        String s = sc.nextLine();

        System.out.print("암호화된 문자열: ");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) <= 'z' && s.charAt(i)>='a'){
                int temp = s.charAt(i) + 3;
                if(temp > 122) temp -= 26;
                System.out.print((char)temp);
            }else{
                System.out.print(s.charAt(i));
            }
        }

    }
}
