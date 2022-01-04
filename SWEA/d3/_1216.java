package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _1216 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/_1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			
			char[][] map = new char[100][];
			char[][] rotateMap = new char[100][100];
			int max = 0;
			
			for(int i = 0; i < 100; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int n = 0; n < 100; n++) {
				for(int m = 0; m < 100; m++) {
					rotateMap[n][m] = map[m][n];
				}
			}
			
			
			// 가로
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j > 0; j++) {
				}
			}
			

			System.out.println("#" + t + " " + max);
		}

	}
	
	private static boolean verify(int c) {
		return false;
	}
}
