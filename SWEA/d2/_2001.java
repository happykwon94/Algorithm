package com.ssafy.swea.d2;

// 21.08.04

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2001 {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input/_2001.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] fly = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			for(int r = 0; r <= N-M; r++) {
				for(int c = 0; c <= N-M; c++) {
					int sum = killFly(fly, r, c, M);
					max = sum > max ? sum : max;
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
	
	private static int killFly(int[][] fly, int r, int c, int M) {
		int result = 0;
		for(int dr = 0; dr < M; dr++) {
			for(int dc = 0; dc < M; dc++) {
				result += fly[r + dr][c + dc];
			}
		}
		return result;
	}
}
