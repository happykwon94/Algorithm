package com.ssafy.pro.lv1;

// 22.01.20 Programmers 월간 코드 챌린지 시즌2

public class 약수의개수와덧셈 {
	   public static int solution(int left, int right) {
	        int answer = 0;
	        
	        for(int i = left; i <= right; i++){
	            int cnt = 1;    // 자기 자신 포함
	            
	            for(int j = 1; j <= i/2; j++){
	                if(i % j == 0)
	                    cnt++;
	            }
	                        
	            if(cnt % 2 == 0)
	                answer += i;
	            else
	                answer -= i;
	        }
	        
	        return answer;
	    }
	   
	   public static void main(String[] args) {
		int left = 13;
		int right = 17;
		System.out.println(solution(left, right));
	}
}
