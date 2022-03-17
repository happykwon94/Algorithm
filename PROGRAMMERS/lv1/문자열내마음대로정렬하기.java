package com.ssafy.pro.lv1;

import java.util.*;

// 22.03.05 Programmers 연습문제

public class 문자열내마음대로정렬하기 {
    public static String[] solution(String[] strings, int n){

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) != o2.charAt(n))
                    return o1.charAt(n) - o2.charAt(n);

                return o1.compareTo(o2);
            }
        });

        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(Arrays.toString(solution(strings, n)));
    }

}
