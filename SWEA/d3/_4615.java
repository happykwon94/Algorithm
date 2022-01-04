package com.ssafy.swea.d3;

// 21.09.16 예외처리 부족

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4615 {

	static int N, M;
	
	static int[][] map;
	
	static int[] dr = {1, -1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			map = new int[N][N];
			
			map[N/2-1][N/2] = 1;
			map[N/2][N/2-1] = 1;
			map[N/2][N/2] = 2;
			map[N/2-1][N/2-1] = 2;
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				
				int r = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				int stone = Integer.parseInt(st.nextToken());
				int target = (stone == 1 ? 2 : 1);
				
				map[r][c] = stone;
				
				play(r, c, stone, target);
			}
			
			int blackStone = 0;
			int whiteStone = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1)
						blackStone++;
					else if(map[i][j] == 2)
						whiteStone++;
				}
			}
			
			System.out.println("#" + t + " " + blackStone + " " + whiteStone);
		}
	}
	
	private static void play(int r, int c, int stone, int target) {
		for(int d = 0; d < 8; d++) {
			// 먹을 가능성이 있는 돌
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0)
				continue;
			
			if(map[nr][nc] == target) {
				// 가능성이 있는 돌이 상대편으로 바뀌려면 그 방향 끝에 상대편 돌이 있으면 됨
				boolean flag = false;
				while(map[nr][nc] != stone) {
					nr += dr[d];
					nc += dc[d];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0) {
						break;
					}
					
					// 상대편 돌이 나온 경우
					if(map[nr][nc] == stone) {
						flag = true;
						break;
					}
				}
				
				if(flag) {
					nr = r + dr[d];
					nc = c + dc[d];
					while(map[nr][nc] != stone) {
						map[nr][nc] = stone;
						nr += dr[d];
						nc += dc[d];
					}
				}
			}
		}
	}
}
