package com.ssafy.boj.silver;

// 21.08.18

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1992 {
	
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
	
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		divide(0, 0, N);
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
	
	private static void divide(int x, int y, int N) {
		// 원소 한개 씩 볼 때
		if(N == 1) {
			sb.append(map[x][y]);
			return ;
		}
		

		// 병합 가능
		if(compression(x, y, N)) {
			sb.append(map[x][y]);
			return ;
		} else {
			// 병합 불가능한 경우
			sb.append("(");
			divide(x, y, N/2);			// 왼쪽 상단
			divide(x, y+N/2, N/2);		// 우측 상단
			divide(x+N/2, y, N/2);		// 좌측 하단
			divide(x+N/2, y+N/2, N/2);	// 우측 하단
			sb.append(")");
		}
		
	}
	
	// 병합 가능 여부를 반환
	private static boolean compression(int x, int y, int N) {
		int val = map[x][y];
		// 시작점 x, y부터 N개까지 돌면서 확인
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(map[i][j] != val) {
					return false;
				}
			}
		}
		return true;
	}
}
