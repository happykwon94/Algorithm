package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2851 {
	
	static int[] input;
	static boolean[] selected;
	static int ans, gap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ans = 0;
		gap = Integer.MAX_VALUE;
		input = new int[10];
		selected = new boolean[10];
		
		for(int i = 0; i < 10; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		subSet(0);
		
		System.out.println(ans);
	}
	
	private static void subSet(int cnt) {
		if(cnt == 10) {
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				if(!selected[i]) {
					break;
				}
				
				sum += input[i];
			}
			
			if(gap > Math.abs(100-sum)) {
				ans = sum;
				gap = Math.abs(100-sum);
			} else if(gap == Math.abs(100-sum)) {
				ans = Math.max(ans, sum);
			}
			
			return;
		}
		
		selected[cnt] = true;
		subSet(cnt+1);
		
		selected[cnt] = false;
		subSet(cnt+1);
	}
}
