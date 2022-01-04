package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3289 {
	
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append("#").append(t).append(" ");
			
			make();
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				if(num == 1) {
					if(find(a) != find(b))
						sb.append(0);
					else
						sb.append(1);
				} else {
					union(a, b);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	private static void make() {
	
		parents = new int[N+1];

		for(int n = 1; n <= N; n++) {
			parents[n] = n;
		}
	}
	
	private static int find(int n) {
		if(parents[n] == n)
			return n;
		return parents[n] = find(parents[n]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB)
			return false;
		
		parents[rootB] = rootA;
		return true;
	}
}
