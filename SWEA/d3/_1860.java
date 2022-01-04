package com.ssafy.swea.d3;

// 21.08.31

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1860 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String answer = "Possible";
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] person = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < N; n++) {
				person[n] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(person);
			
			int boong = 0;
			int sales = 0;
			for(int n = 0; n < N; n++) {
				boong = person[n]/M * K;
				boong -= sales;	// 이전에 팔린거 처리
				
				if(boong <= 0) { // 현재 재고
					answer = "Impossible";
					break;
				} else {
					sales++;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
