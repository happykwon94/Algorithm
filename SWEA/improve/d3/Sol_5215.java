package com.ssafy.swea.improve.d3;

// 21.09.14 DP

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_5215 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][2];
			int[][] dp = new int[N+1][L+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 고려할 음식
			for(int n = 1; n <= N; n++) {
				// 제한된 칼로리
				for(int k = 1; k <= L; k++) {
					// 음식의 칼로리가 남은 섭취가능 칼로리보다 적다면 섭취 가능
					if(arr[n][1] <= k) {
						// 지금 음식을 먹지 않은 만족도와 음식을 먹어 칼로리를 소모한 만족도를 비교해서 더 만족도가 높은 값 추출
						dp[n][k] = Math.max(dp[n-1][k], arr[n][0] + dp[n-1][k - arr[n][1]]);
					} else {
						dp[n][k] = dp[n-1][k];
					}
				}
			}
			
			System.out.println("#" + t + " " + dp[N][L]);	
		}
        
        br.close();
	}
	
	
}
