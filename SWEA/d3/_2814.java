package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _2814 {
	static class Edge{
		int v1;
		int v2;
		
		public Edge(int v1, int v2) {
			super();
			this.v1 = v1;
			this.v2 = v2;
		}
		
		
	}
	
	static int N, M;
	static int max;
	static Edge[] edge;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			edge = new Edge[2*M];
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				edge[m] = new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			}
			
			max = 0;
			
			for(int m = 0; m < M; m++) {				
				dfs(edge[m].v2);
			}
			
			System.out.println("#" + t + " "+ max);
		}
		
	}
	
	private static void dfs(int start) {
		
			
		
		for(int m = 0; m < M; m++) {
			if(edge[m].v1 == start) {
				dfs(edge[m].v2);
			} 
			
			if(edge[m].v2 == start) {
				dfs(edge[m].v1);
			}
		}
		
		
	}
}
