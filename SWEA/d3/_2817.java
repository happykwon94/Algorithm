package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2817 {
	
	static int N;
	static int K;
	static int result;
	
	static boolean[] isChecked;
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			isChecked = new boolean[N];
			selected = new int[N];
			result = 0;
			
			for(int i = 0; i < N; i++) {
				selected[i] = Integer.parseInt(st.nextToken());
			}
			
			subset(0);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			
			int sum = 0;
			
			for(int n = 0; n < N; n++) {
				if(isChecked[n]) {
					sum += selected[n];
				}
			}
			
			if(sum == K)
				result++;
			
			return;
		}
		
		isChecked[cnt] = true;
		subset(cnt + 1);
		
		isChecked[cnt] = false;
		subset(cnt+1);
	}
}
