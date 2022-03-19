package com.ssafy.pro.lv1;

// 22.03.19 Programmers 연습문제

public class 문자열다루기기본 {
	 public static boolean solution(String s) {        
        
        if(s.length() != 4 && s.length() != 6)
            return false;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < 48 || s.charAt(i) > 57)
                return false;
        }
        
        return true;
    }
	 
	 public static void main(String[] args) {
		
		 String s = "a234";
		 System.out.println(solution(s));
	}
}
