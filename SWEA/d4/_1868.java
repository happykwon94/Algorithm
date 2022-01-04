package com.ssafy.swea.d4;

// 21.10.12 BFS
/** 
 * 	주변에 지뢰가 없는 지점을 눌렀을 때에만 주변이 열린다는 것을 활용
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1868 {
	
	static int N, ANSWER;
	static char[][] map;
	static int[][] adjMine;
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			ANSWER = 0;
			adjMine = new int[N][N];
			
			for(int n = 0; n < N; n++) {
				char[] temp = br.readLine().toCharArray();
				for(int m = 0; m < N; m++) {
					map[n][m] = temp[m];
				}
			}
			
			// 주변의 지뢰 매설 정보를 adjMine 배열에 표기
			countAdjMine();
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < N; m++) {
					// 주변으로 확장할 수 있는 경우
					if(adjMine[n][m] == 0 && map[n][m] != '*') {
						bfs(n, m);
						ANSWER++;
					}
				}
			}
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < N; m++) {
					// 주변으로 확장이 불가능한 점들 => 개별로 클릭해야함
					if(adjMine[n][m] > 0 && map[n][m] != '*') {
						ANSWER++;
					}
				}
			}
			
			System.out.println("#" + t + " " + ANSWER);
		}
	}

	private static void countAdjMine() {
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				if(map[n][m] != '.')
					continue;
				
				int cnt = 0;
				for(int d = 0; d < 8; d++) {
					int nr = n + dr[d];
					int nc = m + dc[d];
					
					// 범위 벗어나는 곳
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != '*')
						continue;
					
					cnt++;
				}
				adjMine[n][m] = cnt;
			}
		}
	}

	private static void bfs(int n, int m) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {n , m});
		adjMine[n][m] = -1;
				
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int d = 0; d < 8; d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
				
				// 범위 벗어나는 곳
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || adjMine[nr][nc] == -1 || map[nr][nc] == '*')
					continue;
				
				// 인접한 점으로 확장할 수 있는 경우
				if(adjMine[nr][nc] == 0)
					queue.offer(new int[] {nr, nc});
				
				// 오픈된 지점으로 인해 추가로 오픈된 지점 표기
				adjMine[nr][nc] = -1;
			}
			
		}
		
	}
}
