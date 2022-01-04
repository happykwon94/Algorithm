package com.ssafy.boj.bronze;

// 21.08.29 한 변을 고정시켜 놓고 다른 변을 구한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _8320 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int h = 1; h <= N; h++) {
			for(int w = h; h*w <= N; w++) {
				cnt++;
			}
		}
	
		System.out.println(cnt);
	}
}
