package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[42];
		
		for(int i = 0; i < 10; i++) {
			int target = Integer.parseInt(br.readLine());
			
			arr[target%42] = true;
		}
		
		int ans = 0;
		for(int i = 0; i < 42; i++) {
			if(arr[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
