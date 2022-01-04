package com.ssafy.swea.d4;

// 21.09.29

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8458 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] distance = new int[N];
			int sum = 0;
			int cnt = 0;
			int max = -1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				distance[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(max, distance[i]);
				
				if(distance[i] % 2 != distance[0] % 2) {
					cnt = -1;
				}
			}
			
			if(cnt != -1) {
				while(sum < max || (max - sum) % 2 != 0) {				
					sum += ++cnt;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
