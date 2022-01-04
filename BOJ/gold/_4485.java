package com.ssafy.boj.gold;

// 21.09.29 BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4485 {
	
	static int N, map[][], currentMap[][];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		int num = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0)
				return ;
			
			map = new int[N][N];
			currentMap = new int[N][N];
			
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
					currentMap[n][m] = Integer.MAX_VALUE;
				}
			}
			
			System.out.println("Problem " + num++ + ": " + bfs());
			
		}
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{0, 0});
		currentMap[0][0] = map[0][0];
				
		while(!q.isEmpty()) {
			int[] current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				
				if(currentMap[nr][nc] > map[nr][nc] + currentMap[current[0]][current[1]]) {
					currentMap[nr][nc] = map[nr][nc] + currentMap[current[0]][current[1]];
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
		return currentMap[N-1][N-1];
	}
}