package com.ssafy.swea.d3;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _7272 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		int[] gg = {1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		
		for(int t = 1; t <= T; t++) {
			boolean answer = true;
			
			String[] str = br.readLine().split(" ");
			
			if(str[0].length() == str[1].length()) {
				int len = str[0].length();
				for(int idx = 0; idx < len; idx++) {
					if(gg[str[0].charAt(idx)-65] != gg[str[1].charAt(idx)-65]) {
						answer = false;
						break;
					}
				}				
			} else {
				answer = false;
			}
					
			if(answer) {
				System.out.println("#" + t + " " + "SAME");
			} else {
				System.out.println("#" + t + " " + "DIFF");
			}
		}
	}
}
