package com.ssafy.swea.d1;

//21.07.19

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2070 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int count = 1;
		
		while(T-- > 0) {
			
			String[] testCase = br.readLine().split(" ");
			char op;
			
			op = (Integer.parseInt(testCase[0]) == Integer.parseInt(testCase[1])) ? '='  : (Integer.parseInt(testCase[0]) > Integer.parseInt(testCase[1])) ? '>'  : '<';
			
			
			sb.append("#").append(count++ + " " + op + "\n");
			
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
	
}
