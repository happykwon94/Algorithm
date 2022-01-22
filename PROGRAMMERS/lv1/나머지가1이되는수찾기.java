package com.ssafy.pro.lv1;

// 22.01.22 Programmers 월간 코드 챌린지 시즌3

public class 나머지가1이되는수찾기 {
    public static int solution(int n) {        
        for(int i = 2; i < n; i++){
            if(n%i == 1){
                return i;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}
}
