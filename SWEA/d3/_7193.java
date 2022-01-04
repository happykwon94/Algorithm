package com.ssafy.swea.d3;

// 21.09.16 나머지 연산의 분배법칙

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7193 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			String X = st.nextToken();
			
			int sum = 0;
			for(int i = 0; i < X.length(); i++) {
				sum += (X.charAt(i) - '0');
			}
			
			System.out.println("#" + t + " " + (sum % (N-1)));
		}
	}
}
