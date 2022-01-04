package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _7236 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			
			char[][] map = new char[N][];
			
			for(int n = 0; n < N; n++) {
				map[n] = br.readLine().replaceAll(" ", "").toCharArray();
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] == 'W') {
						int depth = 0;
						
						for(int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;
							
							if(map[nr][nc] == 'W')
								depth++;
						}
						
						if(depth == 0)
							depth = 1;
						
						max = Math.max(max, depth);
					}
				}
			}
			
			
			System.out.println("#" + t + " " + max);
		}
	}
}
