package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7465 {
	
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			make(N);
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			System.out.println("#" + t + " " + group());
		}
		
	}

	private static void make(int N) {
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x)
			return x;
		
		return parents[x] = find(parents[x]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB)
			return false;

		parents[rootB] = rootA;
		return true;
	}
	
	// 방문한 지점 갯수 == 무리의 수
	private static int group() {
		boolean[] visited = new boolean[parents.length];
		int answer = 0;
		for(int i = 1; i < parents.length; i++) {
			int current = find(i);
			if(!visited[current]) {
				answer++;
				visited[current] = true;
			}
		}
		return answer;
	}
}
