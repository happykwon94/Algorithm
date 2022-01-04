package com.ssafy.swea.d3;

// 21.09.07	더럽다...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1240 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		String[] org = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			StringBuilder result = new StringBuilder();
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				if(str.contains("1")) {
					for(int j = M-1; j >= 0; j--) {
						// 시작점
						if(str.charAt(j) == '1') {
							for(int k = j; k >= 8; k -= 7) {
								String target = str.substring(k-6, k+1);
								for(int m = 0; m < 10; m++) {
									if(org[m].equals(target)) {
										result.append(m);
										break;
									}
								}
							}
							break;
						}
					}
					
					while(i++ <= N-2) {
						br.readLine();
					}
				}
			
			}
			
			int answer = 0;
			int posAns = 0;
			for(int i = 7; i >= 0; i--) {
				int x = result.charAt(i)-48;
				if(i%2 == 1) {
					answer += x*3;
				} else {
					answer += x;
				}
				posAns += x;
			}
			
			System.out.println("#" + t + " " + (answer%10 == 0? posAns : 0));
		}
	}
}
