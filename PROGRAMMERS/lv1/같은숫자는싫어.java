package com.ssafy.pro.lv1;

import java.util.*;

// 22.02.26 Programmers 연습문제

public class 같은숫자는싫어 {
    public static int[] solution(int []arr) {
        Stack<Integer> answer = new Stack<>();
        answer.add(arr[0]);
        
        for(int i = 0; i < arr.length; i++){
            if(answer.peek() != arr[i])
                answer.add(arr[i]);
        }
        
        int[] list = new int[answer.size()];
        
        for(int i = list.length-1; i >= 0; i--) {
        	list[i] = answer.pop();
        }
        
        return list;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		System.out.println(Arrays.toString(solution(arr)));
	}
}
