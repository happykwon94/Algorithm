package com.ssafy.swea.d3;

// 21.08.31

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1209 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			
			int[][] arr = new int[100][100];
			int max = 0;
			
			int dia1 = 0;
			int dia2 = 0;
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				int sum = 0;
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i == j) {
						dia1 += arr[i][j];
					} else if(i + j == 99 ){
						dia2 += arr[i][j];
 					}
					sum += arr[i][j];
				}
				max = Math.max(max, sum);
			}
			
			max = Math.max(max, Math.max(dia1, dia2));
			
			for(int c = 0; c < 100; c++) {
				int sum = 0;
				for(int r = 0; r < 100; r++) {
					sum += arr[r][c];
				}
				max = Math.max(max, sum);
			}
			
			System.out.println("#" + t + " " + max);
			
		}
	}
}
