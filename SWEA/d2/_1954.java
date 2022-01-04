package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for(int t = 1; t <= T; t++) {
		
			int N = Integer.parseInt(br.readLine());
			int num = 0;
			
			int[][] snail = new int[N][N];
			int r = 0;
			int c = 0;
			int dir = 0;
			
			if(N == 1) {
				snail[0][0] = 1;
				sb.append("#").append(t).append("\n").append(1).append("\n");
				continue;
			}
			
			
			while(num++ < N*N) {
				
				snail[r][c] = num;	

				r += dr[dir%4];
				c += dc[dir%4];

				if(r < 0 || r >= N || c < 0 || c >= N) {
					r -= dr[dir%4];
					c -= dc[dir%4];
					dir++;
					r += dr[dir%4];
					c += dc[dir%4];
				}
				
				if(snail[r][c] != 0) {
					r -= dr[dir%4];
					c -= dc[dir%4];
					dir++;
					r += dr[dir%4];
					c += dc[dir%4];
				}

			}
			
			sb.append("#").append(t).append("\n");
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(snail[i][j]).append(" ");
				}
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
			
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	
	}
	
}
