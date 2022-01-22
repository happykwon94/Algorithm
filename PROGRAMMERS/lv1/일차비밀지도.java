package com.ssafy.pro.lv1;

import java.util.Arrays;

// 22.01.23 Programmers 2018 KAKAO BLIND RECRUITMENT

public class 일차비밀지도 {
	 public static String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        StringBuilder sb = null;
	        
	        for(int i = 0; i < n; i++){
	            sb = new StringBuilder();
	            
	            int target = arr1[i] | arr2[i];
	            
	            while(target > 1){
	                if(target%2 == 1)
	                    sb.append("#");
	                else
	                    sb.append(" ");
	                
	                target /= 2;
	            }
	            
	            if(target%2 == 1)
	                sb.append("#");
	            else
	                sb.append(" ");
	            
	            while(sb.length() < n){
	                sb.append(" ");
	            }
	            
	            answer[i] = sb.reverse().toString();
	        }
	        
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		 int n = 5;
		 int[] arr1 = {9, 20, 28, 18, 11};
		 int[] arr2 = {30, 1, 21, 17, 28};
		 
		 System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}
}
