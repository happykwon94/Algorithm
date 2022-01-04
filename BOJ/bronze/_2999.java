package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2999 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int N = str.length();
		int R = 0, C = 0;
		
		for(int i = 1; i < N; i++) {
			if(N%i == 0 && i <= N/i) {
				R = i;
				C = N/R;
			}
		}
		
		if(R == 0 && C == 0) {
			R = C = 1;
		}
		
		char[][] org = new char[R][C];
		
		int index = 0;
		for(int c = 0; c < C; c++) {
			for(int r = 0; r < R; r++) {
				org[r][c] = str.charAt(index++);
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sb.append(org[r][c]);
			}
		}
		
		System.out.println(sb);
	}
}
