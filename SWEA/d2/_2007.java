package com.ssafy.swea.d2;

// 21.08.04

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2007 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String str = br.readLine();
			int result = 0;
			for(int i = 1; i < str.length(); i++) {
				String s1 = str.substring(0, i);
				String s2 = str.substring(i, i+i);
				if(s1.equals(s2)) {
					result = s1.length();
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
