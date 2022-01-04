package com.ssafy.swea.d4;

// 21.08.06

// 아이디어 적으로 배열에 인접한 방의 수를 넣고 이어지는 인덱스를 세어서 연결된 방의 수를 셀 수 있다.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _1861 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int N;
	static int MAX;
	static int SUM;
	static int pos;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			// 맵 구성
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			pos = N*N;
			MAX = 1;

			// 탐색
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					SUM = 1;
					search(i, j);
					if(MAX < SUM) {
						MAX = SUM;
						pos = map[i][j];
					}
					
					if(SUM != 1 && MAX == SUM) {
						pos = pos < map[i][j] ? pos : map[i][j];
					}
				}
			}
			
			System.out.println("#" + t + " "+ pos+ " " + MAX);
		}
	}
	
	private static void search(int startR, int startC) {
		
		// 범위를 벗어나면 종료;
		if(!verify(startR, startC)) {
			return ;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int nr = startR + dr[i];
			int nc = startC + dc[i];
			
			if(verify(nr, nc) && map[startR][startC] + 1 == map[nr][nc]) {
				SUM++;
				search(nr, nc);
			}
		}		
		return ;
	}
	
	private static boolean verify(int nr, int nc) {
		if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
			return false;
		} else {
			return true;
		}
	}
}
