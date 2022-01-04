package com.ssafy.swea.competency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4014 {
	
	static int N, X;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
		
			int[][] mapW = new int[N][N];
			int[][] mapH = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					mapH[j][i] = mapW[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			
			count = solve(mapW) + solve(mapH);
			
			System.out.println("#" + t + " " + count);
			
		}
		
	}

	private static int solve(int[][] map) {
		
		int cnt = 0;
		boolean[][] slope = new boolean[N][N];
		out:for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) {
				if(map[i][j+1] - map[i][j] == 0)
					continue;
				
				// 높이 차이가 2 이상나서 실패
				if(Math.abs(map[i][j+1] - map[i][j]) > 1)
					continue out;
				
				// 높이가 높아질 떄
				if(map[i][j+1] - map[i][j] > 0) {
					// 설치 불가
					if(j - X < 0)
						continue out;
					
					int height = map[i][j];
					// 설치가능
					for(int k = j; k > j-X; k--) {
						// 이미 설치됨
						if(slope[i][k])
							break;
						
						// 설치
						if(!slope[i][k] && map[i][k] == height) {
							slope[i][k] = true;
						}
						
						// 설치불가
						if(map[i][k] == height) {
							continue out;
						}
					}
				}
					
				// 높이가 낮아질때
				if(map[i][j+1] - map[i][j] < 0) {
					
				}
			}
			cnt++;
		}
		
		
		return cnt;
	}
}
