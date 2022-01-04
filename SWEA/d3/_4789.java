package com.ssafy.swea.d3;

//21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _4789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String str = br.readLine();
			int len = str.length();
			
			// 현재 기립박수 하는 사람
			int people = str.charAt(0) -'0';
			int hireNum = 0;
			int answer = 0;
			
			for(int i = 1; i < len; i++) {
				int target = str.charAt(i) - '0';
				
				if(target == 0)
					continue;
				
				if(i <= people) {
					people += target;
				} else {
					// 부족한만큼 고용해야함
					hireNum = i - people;
					people += (hireNum + target);
					answer += hireNum;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	
	}
}
