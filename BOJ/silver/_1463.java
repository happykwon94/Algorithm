package com.ssafy.boj.silver;

// 21.09.14 DP

import java.util.Scanner;

public class _1463 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] dp = new int[N+1];
		
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i % 3 == 0) {
				min = Math.min(min, dp[i/3] + 1);
			}
			
			if(i % 2 == 0) {
				min = Math.min(min, dp[i/2] + 1);
			}
			
			dp[i] = Math.min(dp[i-1] + 1, min);
		}
		System.out.println(dp[N]);
		
		scan.close();
	}
}
