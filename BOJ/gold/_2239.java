package com.ssafy.boj.gold;

//21.10.05 https://st-lab.tistory.com/119

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2239 {
	
	private static int[][] sudoku;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sudoku = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < 9; j++) {
				sudoku[i][j] = input[j] - '0';
			}
		}
		
		solve(0, 0);
		
		System.out.println();
	}
	
	private static void solve(int r, int c) {
		
		if(r == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);;
		}
		
		if(c == 9) {	// 행을 다 채웠으면 이동
			solve(r+1, 0);
			return;
		}
		
		if(sudoku[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(isPossible(r, c, i)) {
					sudoku[r][c] = i;
					solve(r, c+1);	// 행 우선 탐색
				}
			}
			
			sudoku[r][c] = 0;
			return;
		}
		solve(r, c+1);
		
	}
	
	private static boolean isPossible(int r, int c, int val) {
		// 가로 검사
		for(int col = 0; col < 9; col++) {
			if(val == sudoku[r][col])
				return false;
		}
		
		for(int row = 0; row < 9; row++) {
			if(val == sudoku[row][c])
				return false;
		}
		
		int rStart = (r/3)*3;
		int cStart = (c/3)*3;
		
		for(int row = rStart; row < rStart+3; row++) {
			for(int col = cStart; col < cStart+3; col++) {
				if(val == sudoku[row][col])
					return false;
			}
		}
		
		return true;
	}
	
}
