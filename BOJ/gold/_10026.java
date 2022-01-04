package com.ssafy.boj.gold;

// 21.08.26

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _10026 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] normal = new char[N][N];
		char[][] color = new char[N][N];
		
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int m = 0; m < N; m++) {
				char ch = str.charAt(m);
				
				if(ch == 'G') {
					color[n][m] = 'R';
				} else {
					color[n][m] = ch;
				}
				
				normal[n][m] = ch;
			}
		}
		
		System.out.println(solve(normal) + " " + solve(color));
		
				
	}
	
	private static int solve(char[][] arr) {
		visited = new boolean[N][N];

		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					answer++;
					dfs(i, j, arr);
				}
			}
		}
		return answer;
	}
	
	private static void dfs(int r, int c, char[][] arr) {
		visited[r][c] = true;
		char current = arr[r][c];
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
				continue;
			
			char next = arr[nr][nc];
			
			if(current == next) {
				dfs(nr, nc, arr);
			}
			
		}
		
	}
}
