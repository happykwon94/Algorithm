package com.ssafy.swea.d3;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _5356 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			char[][] words = new char[5][];
			
			int max = 0;
			for(int i = 0; i < 5; i++) {
				words[i] = br.readLine().toCharArray();
				max = Math.max(max, words[i].length);
			}
			
			for(int c = 0; c < max; c++) {
				for(int r = 0; r < 5; r++) {
					if(words[r].length <= c) {
						continue;
					}
					sb.append(words[r][c]);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
