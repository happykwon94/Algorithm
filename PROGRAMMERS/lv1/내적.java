package com.ssafy.pro.lv1;

// 22.01.12 Programmers

public class 내적 {
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        int len = a.length;
        
        for(int i = 0; i < len; i++){
            answer += a[i]*b[i];
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		
		System.out.println(solution(a, b));
	}
}
