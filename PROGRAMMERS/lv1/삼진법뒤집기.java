package com.ssafy.pro.lv1;

// 22.01.20 Programmers 월간 코드 챌린지 시즌1

public class 삼진법뒤집기 {
    public static int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n / 3 >= 1 ){
            sb.append(n % 3);
            n /= 3;
        }
        
        sb.append(n);
        
        for(int i = 0; i < sb.length(); i++){
            int num = sb.charAt(i) - '0';
            answer += num * (int)Math.pow(3, sb.length()-1-i);
        }
                
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 125;
		System.out.println(solution(n));
	}
}
