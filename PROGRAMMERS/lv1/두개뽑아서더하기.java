package com.ssafy.pro.lv1;

// 22.01.17 Programmers 월간 코드 챌린지 시즌1

import java.util.*;

public class 두개뽑아서더하기 {
	
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		
		System.out.println(Arrays.toString(solution(numbers)));
	}
}
