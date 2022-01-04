package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int answer = 0;
		
			char[] result = br.readLine().toCharArray();
			
			int current = 0;
			for(int num = 0; num < result.length; num++) {
				if(result[num] == 'X') {
					current = 0;
				} else {
					current++;
					answer += current;
				}
			}
			
			System.out.println(answer);
		}
		
	}
}
