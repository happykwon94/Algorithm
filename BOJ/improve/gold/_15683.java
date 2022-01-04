package com.ssafy.boj.improve.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class _15683 {
	static int N, M, K, ans = Integer.MAX_VALUE;
	
	// dir : 카메라 별로 가지고 있는 초기 상태, 카메라의 타입과 초기 상태 인덱스를 맞췄음
	static int[][] map, dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
	
	// cctv 종류에 따라서 돌릴 수 있는 방향의 갯수
	static int[] dCnt = {0, 4, 2, 4, 4, 1};
	
	// 하, 우, 상, 좌 -> +1 할 때마다 회전을 시킨 것 같은 효과
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	
	static ArrayList<CCTV> cctvList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		solve(0, map);
		System.out.println(ans);
	}
	
	// idx 현재 보려고 하는 CCTV의 순서, 초기 map을 보다가 사각지대가 최소값이 되지 않는다면 다시 원래의 맵으로 돌아가야한다.
	static void solve(int idx, int[][]map) {
		// CCTV의 감시 영역을 다 세팅했다면
		if (idx == cctvList.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) 
						cnt++;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		CCTV cctv = cctvList.get(idx); // 리스트에서 지켜볼 CCTV 뽑기
		for (int d = 0; d < dCnt[cctv.d]; d++) {  // CCTV 회전 방향, 타입에 해당하는 회전 횟수만큼 돌릴거야, 회전 횟수에 대한 처리
			int[][] copyMap = mapCopy(map);	// 현재 작업을 처리한 맵, 이 맵 상태에서 다음 CCTV를 꺼내 작업해야함
			
			// CCTV의 종류에 따른 감시하는 모든 방향에 대해 체크한다
			for (int i = 0; i < dir[cctv.d].length; i++) {	// 타입에 따라 처리할 수 있는 방향이 (좌,우), (좌, 상, 우) 등 다양하므로 그 부분에 대한 처리
				int cctvDir = (dir[cctv.d][i] + d ) % 4;
				int r = cctv.r;
				int c = cctv.c;
				while (true) {
					r += dr[cctvDir];
					c += dc[cctvDir];
					
					if (r < 0 || r >= N || c < 0 || c >= M) break;  // 범위를 벗어나면
					if (copyMap[r][c] == 6) break;  // 해당 위치가 벽이라면
					copyMap[r][c] = 9; // cctv가 감시중인 범위임을 표현
				}
			}
			solve(idx + 1, copyMap);
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static int[][] mapCopy(int[][] map) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	static class CCTV {
		int r, c, d;
		CCTV(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}