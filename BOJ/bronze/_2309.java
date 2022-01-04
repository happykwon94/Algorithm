package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309 {
	
	static int[] number, input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = new int[9];
		number = new int[7];
		
		for(int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += number[i];
			}
			
			if(sum == 100) {
				Arrays.sort(number);
				for(int i = 0; i < 7; i++) {
					System.out.println(number[i]);
				}				
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			number[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
}
