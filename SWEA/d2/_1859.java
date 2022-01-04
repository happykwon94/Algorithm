package com.ssafy.swea.d2;

// 21.08.24 완탐인데 핵심은 뒤에서부터 뒤져나가는 것

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1859 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1859.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int[] price = new int[N];
			
			for(int p = 0; p < N; p++) {
				int val = Integer.parseInt(st.nextToken());
				
				price[p] = val;
			}
			
			int max = price[N-1];
			long income = 0l;
			
			for(int p = N-1; p >= 0; p--) {
				if(price[p] < max) {
					income += (max-price[p]);
				} else {
					max = price[p];
				}
			}
			
			System.out.println("#" + t + " " + income);
		}
	
	}
}
