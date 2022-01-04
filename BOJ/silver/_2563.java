package com.ssafy.boj.silver;

// 21.08.10

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2563 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
				
		int[][] map = new int[100][100];
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int dx = 0; dx < 10; dx++) {
				for(int dy = 0; dy < 10; dy++) {
					if(map[x+dx][y+dy] == 0) {
						map[x+dx][y+dy] = 1;
						sum++;
					}
				}
			}
		}
		
		System.out.println(sum);
		br.close();
	}
}
