package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _1215 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/_1215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine());
			
			char[][] map = new char[8][];
			char[][] rotateMap = new char[8][8];
			int result = 0;
			
			for(int i = 0; i < 8; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int n = 0; n < 8; n++) {
				for(int m = 0; m < 8; m++) {
					rotateMap[n][8-m-1] = map[m][n];
				}
			}
			
			
			// 가로
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8-len+1; j++) {
					StringBuilder sb = new StringBuilder();
					sb.append(map[i], j, len);
					String str1 = sb.toString();
					String str2 = sb.reverse().toString();
					
					if(str1.equals(str2)) {
						result++;
					}
				}
			}
			
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8-len+1; j++) {
					StringBuilder sb = new StringBuilder();
					sb.append(rotateMap[i], j, len);
					String str1 = sb.toString();
					String str2 = sb.reverse().toString();
					
					if(str1.equals(str2)) {
						result++;
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}
}
