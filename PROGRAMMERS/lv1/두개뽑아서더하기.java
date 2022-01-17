package com.ssafy.pro.lv1;

// 22.01.17 Programmers 월간 코드 챌린지 시즌1

import java.util.*;

public class 두개뽑아서더하기 {
	
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        int len = numbers.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                int sum = numbers[i] + numbers[j];
                if(!list.contains(sum))
                    list.add(sum);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;    
    }
    
    public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		
		System.out.println(Arrays.toString(solution(numbers)));
	}
}
