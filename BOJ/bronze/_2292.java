package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2292 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int start = 1;
		int add = 0;
		int val = start + 6*add;

		while(val < N) {
			add++;
			val += 6 * add;
		}
		
		System.out.println(add+1);
	}
}
