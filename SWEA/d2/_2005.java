package com.ssafy.swea.d2;

//21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2005 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			
			arr[0][0] = 1;
			
			for(int i = 1; i < N; i++){
				for(int j = 0; j < N; j++) {
					if(j-1 < 0) {
						arr[i][j] = 0 + arr[i-1][j];
						continue;
					}
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 0) {
						continue;
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	
	}
}
