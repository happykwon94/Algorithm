package com.ssafy.boj.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17135 {
	
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] org;
	static int[] selected;
	static boolean[] die;
	static int MAX;
	static int MIN;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		org = new int[N][M];
		selected = new int[3];
		MAX = 0;
		
		// map 배열에 적들이 궁수로부터 얼마나 떨어져있는지 저장
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m < M; m++) {
				org[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(MAX);
		
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			// selected의 r의 좌표는 N(0부터 시작) =>  [r1, r2, r3]
			// 궁수의 배치가 끝남
			// 총 N턴 가능
			mapCopy();

			int max = 0;
			for(int n = 0; n < N; n++) {
				
				//궁수 사격
				die = new boolean[M];	// 턴당 죽인 적들 구할 배열
				for(int i = 0; i < 3; i++) {
					shoot(n, selected[i]);
				}
				
				max += count();
				
				// 한 턴 끝나고 적들 전진
				enemyMove();
			}
			
			MAX = Math.max(MAX, max);
			
			return ;
			
		}
		
		for(int i = start; i < M; i++) {
			selected[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	private static void shoot(int n, int pos) {
		// 포지션이 r인 궁사가 제거 할 수 있는 범위 거리 계산
		// 접근 가능한 범위 탐색하면서 최솟값 찾기
		int min = Integer.MAX_VALUE;
		for(int r = 0; r < D; r++) {
			for(int c = 0; c < M; c++){
				// 적이 없음			
				if(map[N - 1- r][c] == 0)
					continue;
				
				
				
				int dis = Math.abs(r+1) + Math.abs(pos-c);
				if(dis <= D)
					min = Math.min(min, dis);
			}
		}
		
		for(int r = 0; r < D; r++) {
			for(int c = 0; c < M; c++){
				// 적이 없음
				if(map[N - 1 - r][c] == 0)
					continue;
				
				int dis = Math.abs(r+1) + Math.abs(pos-c);

				if(dis == min) {
					if(!die[c]) {
						map[N - 1- r][c] = 0;
						die[c] = true;
					}
				}
			}
		}

	}
	
	private static void enemyMove() {
		for(int i = N-1; i >= 0; i--) {
			if(i == 0) {
				map[i] = new int[M];
				return ;
			}
			
			map[i] = map[i-1];
			
		}
	}
	
	private static void mapCopy() {
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(org[i], M);
		}
	}
	
	private static int count() {
		int sum = 0;
		for(int i = 0; i < M; i++) {
			if(die[i])
				sum++;
		}
		return sum;
	}
	
}
