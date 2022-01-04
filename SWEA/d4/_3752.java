package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _3752 {
	
	private static int N, scores[];
	private static Set<Integer> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			scores = new int[N];
			set = new HashSet<>();
			
			for(int n = 0; n < N; n++) {
				scores[n] = Integer.parseInt(st.nextToken());
			}
			
			subset(0, 0);
			
			System.out.println("#" + t + " " + set.size());
		}
	}

	private static void subset(int cnt, int sum) {
		if(cnt == N) {
			set.add(sum);
			return ;
		}
		
		subset(cnt+1, sum + scores[cnt]);
		subset(cnt+1, sum);
		
	}
}
