package com.ssafy.pro.lv1;

// 22.03.04 Programmers 연습문제

public class 두정수사이의합 {
    public static long solution(int a, int b) {
        long answer = 0;

        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        } else if(a == b)
            return a;

        for(int i = a; i <= b; i++){
            answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        System.out.println(solution(a, b));
    }
}
