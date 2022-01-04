package com.ssafy.swea.d6;

// 21.09.16

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1263 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[][] network = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp == 0) {
						network[i][j] = 99999;
					} else {
						network[i][j] = temp;
					}
				}
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i == k)
						continue;
					for(int j = 0; j < N; j++) {
						if(i == j || j == k)
							continue;
						network[i][j] = Math.min(network[i][k] + network[k][j], network[i][j]);
					}
					System.out.println();
				}
				
			}
			
			int min = Integer.MAX_VALUE;
			for(int n = 0; n < N; n++) {
				int minimum = 0;
				for(int d = 0; d < N; d++) {
					if(network[n][d] != 99999)
						minimum += network[n][d];
				}
				min = Math.min(min, minimum);
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
}
