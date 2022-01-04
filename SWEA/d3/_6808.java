package com.ssafy.swea.d3;

// 21.08.12 순열을 활용해서 인영이가 낼 수 있는 모든 순서를 탐색하는 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6808 {
	
	static int[] GYU;
	static int[] IN;
	static int[] possibleIN;
	static boolean[] isChecked;
	static int WIN;
	static int LOSE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		GYU = new int[9];
		IN = new int[9];
		possibleIN = new int[9];
		isChecked = new boolean[9];
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			boolean[] verify = new boolean[18];
			
			// 규영이 수
			for(int i = 0; i < 9; i++) {
				GYU[i] = Integer.parseInt(st.nextToken());
				verify[GYU[i]-1] = true;
			}

			// 인영이가 고를 수 있는 수
			for(int i = 0, idxI = 0; i < 18; i++ ) {
				if(!verify[i]) {
					possibleIN[idxI++] = i+1;
				}
			}
			
			WIN = 0;
			LOSE = 0;
			
			permutation(0);
			
			System.out.println("#" + t + " " + WIN + " " + LOSE);
			
		}
		br.close();
	}
	
	private static void permutation(int cnt) {
		if(cnt == 9) {
			battle();
			return ;
		}
		
		for(int i = 0; i < 9; i++) {
			if(isChecked[i])
				continue;
			
			IN[cnt] = possibleIN[i];
			isChecked[i] = true;
			
			permutation(cnt+1);
			isChecked[i] = false;
		}
	}
	
	private static void battle() {
		int gyu = 0;
		int in = 0;
		
		for(int round = 0; round < 9; round++) {
			if(GYU[round] > IN[round])
				gyu += GYU[round] + IN[round];
			
			if(GYU[round] < IN[round])
				in += GYU[round] + IN[round];
		}
		
		if(gyu > in) {
			WIN++;
		}
		
		if(gyu < in) {
			LOSE++;
		}
	}
}
