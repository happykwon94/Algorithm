package com.ssafy.swea.competency;

// 21.09.30 인덱스... 구현...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4013 {

	static int score, gears[][], gearStart[], rotateCnt[];
	static int target, direction;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
	
		for(int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			
			gears = new int[4][8];
			gearStart = new int[4];
			score = 0;
			
			for(int g = 0; g < 4; g++) {
				st = new StringTokenizer(br.readLine());
				for(int h = 0; h < 8; h++) {
					gears[g][h] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				target = Integer.parseInt(st.nextToken())-1;
				direction = Integer.parseInt(st.nextToken());
				
				rotateCnt = new int[4];
				rotateCnt[target] = direction*(-1);

				rotateGears();
				rotate();
			}
			
			solve();
			
			System.out.println("#" + t + " " + score);
		}
	}
	
	
	private static void solve() {
		for(int i = 0; i < 4; i++) {
			score += (gears[i][gearStart[i]] << i);
		}
	}


	private static void rotate() {
		for(int r = 0; r < 4; r++) {
			gearStart[r] = (8 + gearStart[r] + rotateCnt[r])%8;
		}
	}


	// 직접적으로 회전시킬 배열 
	private static void rotateGears() {
		
		// 타겟 왼쪽
		for(int g = target; g > 0; g--) {
			if(gears[g][(8+gearStart[g]-2)%8] != gears[g-1][(gearStart[g-1]+2) % 8]) {
				rotateCnt[g-1] = rotateCnt[g]*(-1);
			}
		}
		
		
		// 타겟 오른쪽
		for(int g = target; g < 3; g++) {
			if(gears[g][(gearStart[g]+2)%8] != gears[g+1][(8+gearStart[g+1]-2) % 8]) {
				rotateCnt[g+1] = rotateCnt[g]*(-1);
			}
		}
	}

}
