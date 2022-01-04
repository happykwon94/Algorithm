package com.ssafy.swea.d3;

//21.08.29

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _4047 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			
			boolean[][] cards = new boolean[4][14];
			
			String str = br.readLine();
			int len = str.length()/3;
			
			boolean flag = false;

			outer: for(int i = 0; i < len; i++) {
				char type = str.charAt(i*3);
				int val = Integer.parseInt(str.substring(i*3+1, i*3+3));
				
				switch(type) {
				case 'S':
					if(!cards[0][val]) {
						cards[0][val] = true;
					} else {
						flag = true;
						break outer;
					}
					
					break;
				case 'D':
					if(!cards[1][val]) {
						cards[1][val] = true;
					} else {
						flag = true;
						break outer;
					}
					break;
				case 'H':
					if(!cards[2][val]) {
						cards[2][val] = true;
					} else {
						flag = true;
						break outer;
					}
					break;
				case 'C':
					if(!cards[3][val]) {
						cards[3][val] = true;
					} else {
						flag = true;
						break outer;
					}
					break;
				}
				
			}
			
			if(!flag) {
				System.out.print("#" + t);
				for(int i = 0; i < 4; i++) {
					int num = 13;
					for(int j = 1; j < 14; j++) {
						if(cards[i][j])
							num--;
					}
					System.out.print(" " + num);
				}
				System.out.println();
			} else {
				System.out.println("#" + t + " ERROR");
			}
			
		}
		
	}
}
