package com.ssafy.boj.gold;

// 21.08.19

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1987 {
	
	static char[][] map;
	static boolean[] alpha;
	static int R, C;
	static int MAX;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		MAX = 0;
		map = new char[R][];
		alpha = new boolean[26];
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		
		dfs(0, 0);
		
		System.out.println(MAX);
		
	}
	
	private static void dfs(int r, int c) {

		alpha[map[r][c] - 'A'] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C || alpha[map[nr][nc]-'A'])
				continue;
			
			dfs(nr, nc);
			
		}
		
		calMax();
		alpha[map[r][c] - 'A'] = false;
		
	}
	
	private static void calMax() {
		int max = 0;
		for(int i = 0; i < 26; i++) {
			if(alpha[i]) {
				max++;
			}
		}
		
		MAX = Math.max(MAX, max);
	}
}
