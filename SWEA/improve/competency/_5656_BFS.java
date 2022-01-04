package com.ssafy.swea.improve.competency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5656_BFS {
	
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, W, H, min;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			for(int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0, map);
			
			System.out.println("#" + t + " " + min);
		}
	}

	// 중복 순열로 구슬을 던짐
	private static void go(int cnt, int[][] map) {
		
		if(cnt == N) {	// 구슬을 다 던짐
			// 남아있는 벽돌 수 카운트, 최소값 갱신
			int result = getRemain(map);	// 맵에 남아있는 벽돌 수
			min = Math.min(min, result);
			return;
		}
		
		int[][] newMap = new int[H][W];
		// 0열부터 마지막 열까지 시도
		for(int c = 0; c < W; c++) {
			// c열에 구슬이 던져졌을 때 위에서 처음 만나는 벽돌 찾기
			int r = 0;
			while(r < H && map[r][c] == 0) {
				r++;	// 마지막 행까지 진행
				
				// 구슬에 맞은 벽돌이  없음(해당 열이 모두 빈 칸)
				if(r == H) {
					go(cnt+1, map);	// 다음 구슬로 이동
				} else {	// 맞은 벽돌이 있는 경우
					// 이전 cnt로 map의 상태로 되돌려서 사용
					copy(map, newMap);
					
					// 맞은 벽돌 및 주변 벽돌 함께 제거 처리(연쇄적 처리)
					boom(newMap, r, c);
					
					// 제거된 벽돌을 내리기
					down(newMap);
					
					// 다음 구슬 던지기
					go(cnt+1, newMap);
				}
			}
		}
	}
	
	private static int getRemain(int[][] map) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void down(int[][] map) {
		for(int c = 0; c < W; c++) {
			int r = H-1;
			while(r > 0) {
				// 빈 칸있으면 끌어 내리기
				if(map[r][c] == 0) {
					int nr = r -1;
					while(nr > 0 && map[nr][c] == 0) {
						nr--;
					}
					map[r][c] = map[nr][c];
					map[nr][c] = 0;	// 내린 자리에 대한 처리
				}
				--r;	// 빈 칸 없으면 한 칸 위로
			}
		}
	}

/*
	// down의 다른 방법
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static void down2(int[][] map) {
		for(int c = 0; c < W; c++) {
			int r;
			for(r = H-1; r >= 0; --r) {
				if(map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;	// 벽돌이 있던 자리는 빈 칸으로
				}
			}	// 부서지지 않은 벽돌만 리스트에 담기
			
			// 리스트에 있는 벽돌 제일 아래 행부터 채우기 작업
			r = H;
			for(int b : list) {
				map[--r][c] = b;
			}
			list.clear();
		}
	}
*/
	private static void boom(int[][] map, int r, int c) {
		// BFS로 함께 부숴질 벽돌 처리
		Queue<Point> queue = new LinkedList<>();
		
		if(map[r][c] > 1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;	// 벽돌을 제거하고 빈 칸을 채우기
		
		Point p  = null;
		while(!queue.isEmpty()) {
			p = queue.poll();
			for(int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				
				// 현재 벽돌이 가지고 있는 폭발량만큼 반복
				for(int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					
					// 벽돌이 있는 상황
					if(nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if(map[nr][nc] > 1) {
							// 수치가 있으면 다음에 얘를 터쳐야하니까 큐에 삽입
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						// 수치가 없으면 그냥 부수기
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}
}
