package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1226 {
	
	static int answer;
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0 ,0, -1, 1};
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			int t = Integer.parseInt(br.readLine());
			
			visited = new boolean[16][16];
			map = new int[16][16];
			answer = 0;
			Pos start = null;
			
			for(int n = 0; n < 16; n++) {
				char[] temp = br.readLine().toCharArray();
				for(int m = 0; m < 16; m++) {
					map[n][m] = temp[m] - '0';
					if(map[n][m] == 2) {
						start = new Pos(n, m);
					}
				}
			}
			
			dfs(start);
			
			System.out.println("#" + t + " " + answer);
		}
		
	}

	private static void dfs(Pos start) {
		if(map[start.r][start.c] == 3) {
			answer = 1;
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = start.r + dr[d];
			int nc = start.c + dc[d];
			
			if(nr < 1 || nr >= 15 || nc < 1 || nc >= 15)
				continue;
			
			if(map[nr][nc] == 1)
				continue;
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(new Pos(nr, nc));
				visited[nr][nc] = false;
			}
		}
		
	}
}
