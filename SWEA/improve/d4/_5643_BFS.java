package com.ssafy.swea.improve.d4;

// 21.09.30

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5643_BFS {
	
	static int N, M, adj[][];
	
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
				adj[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				// 관계 작성
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(gtbfs(i) + ltbfs(i) == N-1) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

	
	/**
	 * 	자신보다 큰 관계를 탐색할 bfs
	 * 	start : 전체 학생별로 실행해야함
	 *  */
	private static int gtbfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 행 단위 인접 행렬 확인
			// 연결된 대상 상대로 탐색
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adj[current][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;	// 자신보다 큰 경우
				}
			}
		}
		return cnt;
		
	}
	
	private static int ltbfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			// 행 단위 인접 행렬 확인
			// 연결된 대상 상대로 탐색
			for(int i = 1; i <= N; i++) {
				if(!visited[i] && adj[i][current] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;	// 자신보다 큰 경우
				}
			}
		}
		return cnt;
		
	}
}
