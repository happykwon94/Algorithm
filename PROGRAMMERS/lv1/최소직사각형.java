package com.ssafy.pro.lv1;

// 22.01.22 Programmers 위클리 챌린지

import java.util.*;

public class 최소직사각형 {
	   public static int solution(int[][] sizes) {
		   	// 두 변 중 작은 변이 가로, 큰 변이 세로로 고정시키고 그 중 최대 값을 찾아서 구함
	        int answer = 0;
	        int len = sizes.length;
	        
	        int[] width = new int[len];
	        int[] height = new int[len];

	        for(int i = 0; i < len; i++){
	            if(sizes[i][0] < sizes[i][1]){
	                width[i] = sizes[i][0];
	                height[i] = sizes[i][1];
	            } else {
	                width[i] = sizes[i][1];
	                height[i] = sizes[i][0];
	            }
	        }
	        
	        Arrays.sort(width);
	        Arrays.sort(height);
	        
	        answer = width[len-1] * height[len-1];
	        
	        return answer;
	    }
	   
	   public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes));
	}
}
