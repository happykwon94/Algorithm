package com.ssafy.boj.bronze;

// 21.08.29 생각을 단순하게

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10163 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int x = x1; x < x1+x2; x++) {
				for(int y = y1; y < y1+y2; y++) {
					map[x][y] = n;
				}
			}
		}
		
		for(int n = 1; n <= N; n++) {
			int cnt = 0;
			for(int x = 0; x < 1001; x++) {
				for(int y = 0; y < 1001; y++) {
					if(map[x][y] == n)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
