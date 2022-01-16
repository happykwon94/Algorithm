package com.ssafy.pro.lv1;

// 22.01.16 Programmers 찾아라 프로그래밍 마에스터

import java.util.*;

public class 폰켓몬 {
    
    public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,4};
		System.out.println(solution(nums));
	}
    
    public static int solution(int[] nums) {
          int N = nums.length;
          int R = N/2;
          List<Integer> numbers = new ArrayList<>();
          
          for(int i = 0; i < N; i++) {
          	if(numbers.contains(nums[i]))
          		continue;
          	
          	numbers.add(nums[i]);
          }
          
          if(numbers.size() > R){
              return R;
          }
          
          return numbers.size();
      }
}
