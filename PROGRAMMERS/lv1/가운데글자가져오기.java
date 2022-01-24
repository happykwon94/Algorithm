package com.ssafy.pro.lv1;

// 22.01.24 Programmers 가운데 글자 가져오기

public class 가운데글자가져오기 {
    public static String solution(String s) {
        int len = s.length();
        if(len%2 == 0)
            return s.substring(len/2-1, len/2+1);
        else
            return s.substring(len/2,len/2+1);
    }
    
    public static void main(String[] args) {
		String s = "abcde";
		System.out.println(solution(s));
	}
}
