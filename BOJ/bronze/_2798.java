package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 {
	
	static int[] numbers, input;
	static int ans, N, M, gap;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		numbers = new int[3];
		gap = 300000;
		ans = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0);
		
		System.out.println(ans);
	}

	private static void combination(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += numbers[i];
			}
			
			if(sum > M)
				return;
			
			if(gap > M - sum) {
				ans = sum;
				gap = M - sum;
			}
			
			return ;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);
		}
		
	}
}
