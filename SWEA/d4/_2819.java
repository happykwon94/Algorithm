package com.ssafy.swea.d4;

// 21.10.05 DFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2819 {
	
	private static char[][] map;
	private static int[] dr = {0, 0, 1, -1};
	private static int[] dc = {1, -1, 0, 0};
	private static Set<String> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			map = new char[4][4];
			set = new HashSet<>();
			
			for(int i = 0; i < 4; i++) {
				map[i] = br.readLine().replaceAll(" ", "").toCharArray();
			}
			
			for(int r = 0; r < 4; r++) {
				for(int c = 0; c < 4; c++) {
					dfs(r, c, "");
				}
			}
			System.out.println("#" + t + " " + set.size());
		}
		
	}

	private static void dfs(int r, int c, String str) {
		if(str.length() == 7) {
			set.add(str);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4)
				continue;
			
			dfs(nr, nc, str + map[nr][nc]);
		}
	}
}
