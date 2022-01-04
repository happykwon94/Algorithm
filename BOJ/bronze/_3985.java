package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3985 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] bread = new int[L+1];
		
		int max = 0;
		int ans1 = 0;
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			for(int i = P; i <= K; i++) {
				if(bread[i] != 0)
					continue;
				
				bread[i] = n;
			}
			
			if(max < K-P) {
				max = K-P;
				ans1 = n; 
			}
		}
		
		System.out.println(ans1);
		
		max = 0;
		int ans2 = 0;
		for(int n = 1; n < N+1; n++) {
			for(int b = 1; b < L+1; b++) {
				if(bread[b] == n) {
					int idx = b;
					int sum = 0;
					while(bread[idx++] == n) {
						if(idx >= L + 1) {
							break;
						}
						sum++;
					}
					if(max < sum) {
						max = sum;
						ans2 = n;
					}
					break;
				}
			}
		}
		
		System.out.println(ans2);
		
	}
}
