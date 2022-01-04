package com.ssafy.boj.silver;

// 21.12.15 슬라이드 윈도우 누적합 문제

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class _10025 {
	
	static int answer, N, K;
	static int[] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[1000001];
		
		answer = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			map[x] = g;
		}
		
		solve();
		
		System.out.println(answer);
		
	}

	private static void solve() {
		int sum = answer;
		int window = 2*K + 1;
		
		for(int i = 0; i <= 1000000; i++) {
			sum += map[i];
			if(i >= window)
				sum -= map[i - window];
			answer = Math.max(answer, sum);
		}
	}
}
