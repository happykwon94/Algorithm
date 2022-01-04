package com.ssafy.boj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _8911 {
	
	// 북, 동, 남, 서
	// 0, 1, 2, 3
	static int[] moveCnt;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			moveCnt = new int[4];
			char[] move = br.readLine().toCharArray();
			int d = 0;
			answer = 0;
			
			for(int i = 0; i < move.length; i++) {
				switch(move[i]) {
				case 'F':
					moveCnt[d]++;
					break;
				case 'B':
					moveCnt[(d+2)%4]++;
					break;
				case 'L':
					d = (4 + d - 1)%4;
					break;
				case 'R':
					d = (d+1)%4;
					break;
				}
			}
			
			solve();
			
			System.out.println(answer);
		}
		
	}

	private static void solve() {
		answer = Math.max(moveCnt[0], moveCnt[2])*Math.max(moveCnt[1], moveCnt[3]);
	}
	
}
