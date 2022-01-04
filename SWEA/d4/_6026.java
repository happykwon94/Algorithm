package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6026 {
	
	static int[][] DP;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			long result = 0L;
			
			DP = new int[M+1][M+1];
			
			boolean flag = false;
			for(int m = M; m > 0; m--) {
				if(!flag) {
					result += comb(M, m) * Math.pow(m, N);					
					flag = true;
					continue;
				}
				
				result -= comb(M, m) * Math.pow(m, N);					
				flag = false;
			}
			
			System.out.println("#" + t + " " + (result%1000000007));
		}
	}
	
	private static int comb(int n, int r) {
		if(n == r || r == 0)
			return 1;
		if(DP[n][r] > 0)
			return DP[n][r];
	
		DP[n][r] = comb(n-1, r-1) + comb(n-1, r);
		return DP[n][r];
	}
}
