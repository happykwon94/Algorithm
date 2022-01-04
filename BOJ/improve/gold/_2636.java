package com.ssafy.boj.improve.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {
	public static int N, M, cheeseCnt, cnt, time;
	public static int[][] cheese;
	public static boolean[][] v;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		/* 
			13 12
			0 0 0 0 0 0 0 0 0 0 0 0
			0 0 0 0 0 0 0 0 0 0 0 0
			0 0 0 0 0 0 0 1 1 0 0 0
			0 1 1 1 0 0 0 1 1 0 0 0
			0 1 1 1 1 1 1 0 0 0 0 0
			0 1 1 1 1 1 0 1 1 0 0 0
			0 1 1 1 1 0 0 1 1 0 0 0
			0 0 1 1 0 0 0 1 1 0 0 0
			0 0 1 1 1 1 1 1 1 0 0 0
			0 0 1 1 1 1 1 1 1 0 0 0
			0 0 1 1 1 1 1 1 1 0 0 0
			0 0 1 1 1 1 1 1 1 0 0 0
			0 0 0 0 0 0 0 0 0 0 0 0
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheese = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				cheese[n][m] = Integer.parseInt(st.nextToken());
				if(cheese[n][m] == 1)
					cheeseCnt++;	// BFS를 멈추기 위한 치즈의 갯수
			}
		}
		
		// 마지막으로 다 녹기 전 마지막 치즈 갯수
		int last = 0;
		
		// 몇 시간 걸렸는지 확인
		int time = 0;
		
		// BFS로 0인 부분을 처리하고 맞닿아 있는 1에 대한 처리하면서 치즈의 갯수를 줄인다.
		while(cheeseCnt != 0) {	// 다녹을 때까지 반복
			last = cheeseCnt; // 작업 전 치즈의 갯수
			time++;
			changeAir();
		}
		System.out.println(time);
		System.out.println(last);
	}
	
	/** 
	 * cheese 맵을 탐색하면서 치즈인 부분을 공기로 처리하면서 BFS 탐색을 수행한다.
	 */
	private static void changeAir() {
		// 방문 체크하는 배열
		boolean[][] visited = new boolean[N][M];
		
		// 좌표에 대한 정보를 담을 큐
		Queue<int[]> q = new LinkedList<>();
		
		// BFS할 초기 좌표
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		// 큐가 비어있을 때까지 동작
		while(!q.isEmpty()) {
			// 좌표를 꺼내 방문
			int[] data = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = data[0] + dr[d];
				int nc = data[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}
				
				// 방문하지 않은 좌표의 경우
				if(!visited[nr][nc]) {
					
					// 해당 좌표에 대한 방문 처리
					visited[nr][nc] = true;

					// 범위 내의 공기인 지점
					if(cheese[nr][nc] == 0) {
						// 치즈를 찾으러 큐에 다시 입력
						q.offer(new int[] {nr, nc});
						continue;
					} else {
						// 범위 내의 방문하지 않은 치즈인 지점
						cheese[nr][nc] = 0;
						cheeseCnt--;
					}
				}
			}
		}
	}
}
