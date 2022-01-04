package com.ssafy.swea.d4;

// 21.08.10 조건이 이상한 문제다. 리프노드가 아닌데 숫자가 연산자 자리에 오면 거르면 된다.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _1233 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int result = 1;
			
			int N = Integer.parseInt(br.readLine());
			String[] str;
			for(int n = 1; n <= N; n++) {
				str = br.readLine().split(" ");
				if("+-*/".indexOf(str[1]) == -1 && str.length > 2) {
					result = 0;
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
}
