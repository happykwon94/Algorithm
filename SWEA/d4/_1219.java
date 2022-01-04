package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21.10.26 그냥 배열문제

public class _1219 {
	
	static int[] adjMatrixFirst, adjMatrixSecond;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String str = "";
		while((str = br.readLine()) != null) {
			
			st = new StringTokenizer(str);
			int t = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			adjMatrixFirst = new int[100];
			adjMatrixSecond = new int[100];
			visited = new boolean[100];
			result = 0;
			
			for(int n = 0; n < N; n++) {
				int src = Integer.parseInt(st.nextToken());
				int dst = Integer.parseInt(st.nextToken());
				
				if(adjMatrixFirst[src] == 0) {
					adjMatrixFirst[src] = dst;
				} else {
					adjMatrixSecond[src] = dst;
				}
			}
			
			find(0);
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void find(int src) {
		if(adjMatrixFirst[src] == 99 || adjMatrixSecond[src] == 99) {
			result = 1;
			return;
		}
		
		if(adjMatrixFirst[src] != 0 && !visited[src]) {
			visited[src] = true;
			find(adjMatrixFirst[src]);
			visited[src] = false;
		}
		
		if(adjMatrixSecond[src] != 0 && !visited[src]) {
			visited[src] = true;
			find(adjMatrixSecond[src]);
			visited[src] = false;
		}
		
	}
	
	
}
