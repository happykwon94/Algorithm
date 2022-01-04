package com.ssafy.swea.d1;

// 21.07.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2072 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		while(count++ < N) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int sum = 0;
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num % 2 == 1) {
					sum += num;
				}
				
			}
			
			sb.append("#").append(count).append(" "+sum).append("\n");
		}
		
		System.out.println(sb);
		
		sb = null;
		br.close();
	}
	
}
