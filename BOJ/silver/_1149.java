package com.ssafy.boj.silver;

// 21.09.14

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			
			rgb[n][0] = Integer.parseInt(st.nextToken());
			rgb[n][1] = Integer.parseInt(st.nextToken());
			rgb[n][2] = Integer.parseInt(st.nextToken());
		}
		
		
		// i번째 집에서 RGB를 사용하면 i-1번째 집들은 중복된 RGB를 선택할 수 없음
		for(int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
		}
			
		int min = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
		
		System.out.println(min);
		
	}
}
