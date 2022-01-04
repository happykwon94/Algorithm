package com.ssafy.swea.d3;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6485 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++){
			
			sb.append("#").append(t);
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int P = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < P; i++) {
				int bus = Integer.parseInt(br.readLine());
				int busStop = 0;
				for(int n = 0; n < N; n++) {
					if(map[n][0] <= bus && map[n][1] >= bus) {
						busStop++;
					}
				}
				sb.append(" ").append(busStop);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
