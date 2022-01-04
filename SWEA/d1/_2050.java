package com.ssafy.swea.d1;

// 21.07.19

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2050 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i) - 64).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
}
