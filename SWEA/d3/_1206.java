package com.ssafy.swea.d3;

// 21.08.10 알고리즘 스터디

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1206 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] buildings = new int[N];
			int building = 0;
			for(int n = 0; n < N; n++) {
				buildings[n] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2; i < N-2; i++) {
				int pivot = Math.max(Math.max(buildings[i-2], buildings[i-1])
						, Math.max(buildings[i+1], buildings[i+2]));
				
				if(buildings[i] > pivot)
					building += buildings[i] - pivot;
			}
			
			System.out.println("#"+t+" "+building);
		}
		
		br.close();
	}
}
