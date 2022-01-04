package com.ssafy.boj.improve.bronze;

// 21.08.18 다이나믹 프로그래밍 방식

import java.util.Scanner;

public class _2839_another {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		int[] memo = new int[M+1]; // 원하는 값 바로 찾도록 +1 크게 배열 선언
		
		// 3의 배수 처리
		for(int i = 0; i < memo.length; i++) {
			if(i % 3 == 0) {
				memo[i] = i / 3;
			} else {
				memo[i] = 123456789;	// 비어있음을 의미할 큰 값
			}
		}
		
		// 5의 배수 처리
		for(int i = 5; i < memo.length; i++) {
			if(memo[i] > memo[i-5] + 1) {
				memo[i] = memo[i-5] + 1;	// 5칸 이전이면 거기서 5키로 1개 추가
			}
		}
				
		System.out.println(memo[M] == 123456789 ? -1 : memo[M]);
		
		sc.close();
	}

}
