package com.ssafy.swea.improve.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5643_DFS {
	
	static int N, M, adj[][];
	static int gtCnt, ltCnt;
	static int Cnt, rAdj[][];	// gt, lt 나누지말고 dfs로 한번에 처리하는 경우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());	// 학생 수(정점)
			M = Integer.parseInt(br.readLine());	// 관계(간선)
			adj = new int[N+1][N+1];
			rAdj = new int[N+1][N+1];
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				rAdj[to][from] = adj[from][to] = 1;
				// 관계 작성
				
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				gtCnt = ltCnt = 0;
				
				gtdfs(i, new boolean[N+1]);
				ltdfs(i, new boolean[N+1]);
				
				if(gtCnt + ltCnt == N-1) {
					ans++;
				}
			}
			
			// lt, gt 안나눌 때
			int answer = 0;
			for(int i = 1; i <= N; i++) {
				Cnt = 0;
				dfs(i, adj, new boolean[N+1]);
				dfs(i, rAdj, new boolean[N+1]);
				
				if(Cnt == N-1) {
					answer++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

	
	/**
	 * 	자신보다 큰 관계를 탐색할 bfs
	 * 	start : 전체 학생별로 실행해야함
	 *  */
	private static void gtdfs(int current, boolean[] visited) {
		visited[current] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adj[current][i] == 1) {
				++gtCnt;	// 자기보다 큰 놈 카운팅
				gtdfs(i, visited);
			}
		}
	}

	private static void ltdfs(int current, boolean[] visited) {
		visited[current] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adj[i][current] == 1) {
				++ltCnt;	// 자기보다 큰 놈 카운팅
				ltdfs(i, visited);
			}
		}
	}
	
	private static void dfs(int current, int[][] adjMatrix, boolean[] visited) {
		visited[current] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adjMatrix[i][current] == 1) {
				++Cnt;	// 자기보다 큰 놈 카운팅
				dfs(i, adjMatrix, visited);
			}
		}
	}	
}
