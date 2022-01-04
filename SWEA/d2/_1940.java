package com.ssafy.swea.d2;

// 21.08.24 테스트 케이스 입력 잘 볼 것

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int v = 0;
			int distance = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
			
				int command = Integer.parseInt(st.nextToken());
				
				if(command == 0) {
					distance += v;
					continue;
				}
				
				int val = Integer.parseInt(st.nextToken());

				if(command == 1) {
					v += val;
				} else {
					v -= val;
					if(v < 0) {
						v = 0;
					}
				}
				
				distance += v;
			}
			
			System.out.println("#" + t + " " + distance);
		}
		
	}
}
