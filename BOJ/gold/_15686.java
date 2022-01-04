package com.ssafy.boj.gold;

// 21.08.13 정보 입력은 더럽지만 실행 시간은 짧음

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15686 {
	
	static int N;
	static int M;
	static int MIN;
	static int chicken;
	static int home;
	static Position[] selected;
	static Position[] chickens;
	static Position[] homes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] cities = new int[N][N];
		
		chicken = 0;
		home = 0;
		MIN = Integer.MAX_VALUE;
		
		int pos = 0;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				pos = Integer.parseInt(st.nextToken());
				if(pos == 1)
					home++;
				
				if(pos == 2)
					chicken++;
				
				cities[r][c] = pos;
			}
		}
		
		selected = new Position[M];
		
		chickens = new Position[chicken];
		homes = new Position[home];
		int chicCnt = 0;
		int homeCnt = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(cities[r][c] == 1) {
					homes[homeCnt++] = new Position(r, c);
				}
				
				if(cities[r][c] == 2) {
					chickens[chicCnt++] = new Position(r, c);					
				}
			}
		}
		
		// 정보 파악 끝
		combination(0, 0);
		
		System.out.println(MIN);
		
	}
	
	private static void combination(int cnt, int start) {
		// 살아남은 치킨집 선택
		if(cnt == M) {
			// dis : 전체 치킨거리 / cd : 그 집에서의 최소 치킨거리
			int dis = 0;
			for(int h = 0; h < home; h++) {
				int cd = Integer.MAX_VALUE;
				for(int c = 0; c < M; c++) {
					cd = Math.min(cd, Math.abs(selected[c].x - homes[h].x)
							+ Math.abs(selected[c].y - homes[h].y));
				}
				dis += cd;
			}
			
			MIN = Math.min(MIN, dis);
			
			return ;
		}
		
		for(int i = start; i < chicken; i++) {
			selected[cnt] = chickens[i];
			combination(cnt+1, i+1);
		}
	}
}

class Position{
	int x;
	int y;
	
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}

}
