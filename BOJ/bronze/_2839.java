package com.ssafy.boj.bronze;

// 21.08.17

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2839 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		while(N > 2) {
			if(N % 5 == 0) {
				result += N/5;
				N %= 5;
				break;
			} else {
				N -= 3;
				result++;
			}
		}
		
		if(N != 0)
			System.out.println(-1);
		else {
			System.out.println(result);
		}
	
		br.close();
	}
}
