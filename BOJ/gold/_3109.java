package com.ssafy.boj.gold;

// 21.08.19 지나온 자리에 대한 검사, 유효성 검증하는 시간이 오래 걸리기 때문에 최소화해야한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3109 {
	
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	static int R, C;
	static int MAX;
	static boolean endFlag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		MAX = 0;
		
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		// 시작점 설정
		for(int i = 0; i < R; i++) {			
			endFlag = false;
			setPipe(i, 0);
		}
		
		System.out.println(MAX);
	}
	
	private static void setPipe(int row, int col) {

		// 기저조건(도착)
		if(col == C-1) {
			endFlag = true;
			MAX++;
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			// 현재 위치 지나온 표시
			int nr = row + dr[d];
			int nc = col + 1;
			
			// 유효한 좌표
			if(!isAvailable(nr, nc)) {
				continue;
			}
			
			// 이전에 갔다가 실패했다면 다시 다른 파이프에서 이 지점에 도착하면 다시 실패 과정 겪음
			// 다른 지점에서 이 지점에 오면 실패하는 경로라는 것을 알리기위해 원 상태로 돌리지 않음
			map[nr][nc] = 'x';
			
			setPipe(nr, nc);
			
			if(endFlag)
				return;

		}
		return ;
	}

	private static boolean isAvailable(int r, int c) {
		// 범위를 벗어나거나 X로 막혀있으면
		if(r < 0 || r >= R || c < 0 || c >= C || map[r][c] == 'x') {
			return false;
		}
		
		return true;
	}
	
}
