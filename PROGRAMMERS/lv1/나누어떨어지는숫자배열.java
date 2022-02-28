package com.ssafy.pro.lv1;

import java.util.*;

// 22.03.01 Programmers 나누어 떨어지는 숫자 배열

public class 나누어떨어지는숫자배열 {
	public static int[] solution(int[] arr, int divisor) {

        Arrays.sort(arr);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%divisor == 0)
                list.add(arr[i]);
        }
        
        if(list.size() == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        
        int cnt = 0;
        for(int val : list){
            answer[cnt++] = val;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		
		System.out.println(Arrays.toString(solution(arr, divisor)));
	}
}
