package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1865 {
	
	static int N, company[][];
	static double answer;
	static boolean[] percent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			answer = 0.0;
			
			N = Integer.parseInt(br.readLine());
			company = new int[N][N];
			percent = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					company[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 1.0);
			
			System.out.printf("#" + t + " " + "%.6f", answer);
		}
	}

	private static void dfs(int emp, double per) {
		if(emp == N) {
			answer = Math.max(answer, per);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = emp; j < N; j++) {
				if(percent[j])
					continue;
				
				percent[j] = true;
				
				dfs(emp+1, per*(company[i][j]/100.0));
				percent[j] = false;
			}
		}
		
	}
}
