package com.ssafy.swea.d3;

// 21.08.24 구현 문제

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1220 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int deadlock = 0;
			
			for(int c = 0; c < N; c++) {
				boolean current = false;	// true면 현재 1
				for(int r = 0; r < N; r++) {
					
					if(map[r][c] == 1) {	// 1 만남
						current = true;
						continue;	
					} else if(current && map[r][c] == 2) {	// 1을 만난 상태로 2 만남
						deadlock++;
						current = false;
					}
					
				}
			}
			
			System.out.println("#" + t + " " + deadlock);
		}
	}
}
