package com.ssafy.pro.lv1;

// 22.01.21 Programmers 연습문제

public class 이천십육년 {
    public static String solution(int a, int b) {
        String answer = "";
        
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;
        
        for(int i = 1; i < a; i++){
            day += month[i];
        }
        
        day += b;
                
        answer = days[day%7]; 
        
        return answer;
    }
    
    public static void main(String[] args) {
		int a = 5;
		int b = 24;
		
		System.out.println(solution(a, b));
	}
}
