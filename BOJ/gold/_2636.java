package com.ssafy.boj.gold;

// 21.09.15 https://maejing.tistory.com/entry/BOJ-2636-%EC%B9%98%EC%A6%88

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
					cheeseCnt++;
			}
		}
		
		while (cheeseCnt != 0) {
			time++;
			cnt = cheeseCnt;
			BFS();
		}
		System.out.println(time);
		System.out.println(cnt);
		
		
		
	}

	private static void BFS() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { 0, 0 });
		v = new boolean[N][M];
		v[0][0] = true;
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || v[nr][nc]) continue;
				if (cheese[nr][nc] == 1) {
					cheeseCnt--;
					cheese[nr][nc] = 0;
				} else if (cheese[nr][nc] == 0) {
					que.offer(new int[] { nr, nc });
				}
				v[nr][nc] = true;
			}
		}
	}
}
