package com.ssafy.swea.d3;

// 21.08.04 input 위치 잘못 잡아서 오래 걸림 주의할 것

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _2805 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int yield = 0;
			int N = Integer.parseInt(br.readLine());
			
			char[][] farm = new char[N][];
			
			for(int i = 0; i < N; i++) {
				farm[i] = br.readLine().toCharArray();
			}
			
			int middle = N/2;
			
			// 위의 세모
			for(int r = 0; r < middle; r++) {
				for(int c = middle - r; c <= middle + r; c++) {
					yield += farm[r][c] - '0';
				}
			}
			
			// 중앙
			for(int c = 0; c < N; c++) {
				yield += farm[middle][c] - '0';
			}
			
			// 아래 역삼각
			for(int r = middle+1; r < N; r++) {
				for(int c = r - middle;  c < N - r + middle; c++) {
					yield += farm[r][c] - '0';
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(yield).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
