package com.ssafy.swea.d3;

// 21.08.29 어느 위치에 설치할지를 정하는게 핵심

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7964 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int answer = 0;

			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int[] cities = new int[N+2];
			cities[0] = cities[N+1] = 1;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i < N+1; i++) {
				cities[i] = Integer.parseInt(st.nextToken());
			}
			
			int area = 0;
			for(int i = 0; i < N+2; i++) {
				if(cities[i] == 1) {
					area = D-1;
				} else {
					if(area == 0) {
						area = D-1;
						answer++;
						cities[i] = 1;
					}
					else {
						area--;
					}
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
