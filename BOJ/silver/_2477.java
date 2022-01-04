package com.ssafy.boj.silver;

// 21.08.29 회전 순서에 유의

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		int[] len = new int[6];
		int max = 0;
		int idx = 0;
		
		
		
		for(int i = 0 ; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			len[i] = length;
		}
		
		for(int i = 0 ; i < 6; i++) {
			int temp = len[i] * len[(i+1)%6];
			if(max < temp) {
				max = temp;
				idx = i;
			}
		}
		
		int area = len[(idx+3)%6] * len[(idx+4)%6];
		
		System.out.println((max-area)*K);
	}
}
