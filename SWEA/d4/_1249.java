package com.ssafy.swea.d4;

// 21.09.30 BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1249 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, map[][], dp[][];
	
	static class Pos{
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			dp = new int[N][N];
			
			for(int n = 0; n < N; n++) {
				char[] arr = br.readLine().toCharArray();
				
				for(int m = 0; m < N; m++) {
					map[n][m] = arr[m] - '0';
					dp[n][m] = Integer.MAX_VALUE;
				}
			}
			
			bfs();
			
			System.out.println("#" + t + " " + dp[N-1][N-1]);
			
		}
	}

	private static void bfs() {		
		Queue<Pos> queue = new LinkedList<Pos>();
		dp[0][0] = 0;
		queue.offer(new Pos(0, 0));
		
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current.r + dr[d];
				int nc = current.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if(dp[nr][nc] > dp[current.r][current.c] + map[nr][nc]) {
					dp[nr][nc] = dp[current.r][current.c] + map[nr][nc];
					queue.offer(new Pos(nr, nc));
				}
				
			}
		}
		
	}
}
