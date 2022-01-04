package com.ssafy.swea.improve.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5643_Memoization {
	
	static int N, M, adj[][];
	static int Cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());	// 학생 수(정점)
			M = Integer.parseInt(br.readLine());	// 관계(간선)
			adj = new int[N+1][N+1];
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
			}
			
			for(int i = 1; i <= N; i++) {
				adj[i][0] = -1; // 아직 탐색 안했음을 알리는 초기화
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				// 탐색 안되어있으면
				if(adj[i][0] != -1)
					dfs(i);
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	// 현재가 누군지만 필요
	private static void dfs(int current) {
		
		for(int i = 1; i <= N; i++) {
			if(adj[current][i] == 1) {	// 자신보다 큰 학생이면
				if(adj[i][0] == -1) {	// 아직 탐색 전
					dfs(i);	// 탐색하러 이동
				}
				
				// 자신보다 큰 학생을 탐색 완료한 상태(메모가 되어있으면 탐색 안하고 바로 내려옴)
				if(adj[i][0] > 0) {
					// i의 인접 행렬의 상태를 current에 반영하자
					// current보다 i가 크고 j가 i보다 크다.
					for(int j = 1; j <= N; j++) {
						if(adj[i][j] == 1) {
							adj[current][j] = 1;
						}
					}
				}
			}
		}
		
		int cnt = 0;
		for(int j = 1; j <= N; j++) {
			cnt += adj[current][j];
		}
		
		adj[current][0] = cnt;
	}	
}
