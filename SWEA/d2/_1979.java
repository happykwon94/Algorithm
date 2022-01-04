package com.ssafy.swea.d2;

// 21.08.28

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1979 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String str = "";
			
			for(int i = 0; i < K; i++) {
				str += "1";
			}
			
			char[][] map = new char[N][N];
			char[][] rmap = new char[N][N];
			
			for(int r = 0; r < N; r++) {
				String temp = br.readLine().replaceAll(" ", "");
				map[r] = temp.toCharArray();
				for(int c = 0; c < N; c++) {
					rmap[c][r] = map[r][c];
				}
			}
			
			int answer = 0;

			for(int r = 0; r < N; r++) {
				String[] mapArr = String.valueOf(map[r]).split("0");
				String[] rmapArr = String.valueOf(rmap[r]).split("0");
				
				for(int i = 0; i < mapArr.length; i++) {
					if(str.equals(mapArr[i])) {
						answer++;
					}
				}
				for(int i = 0; i < rmapArr.length; i++) {
					if(str.equals(rmapArr[i])) {
						answer++;
					}
				}
				
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
