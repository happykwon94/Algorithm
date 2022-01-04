package com.ssafy.boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194 {
	
	static class Pos{
		int x, y;
		int cnt, key;
		
		public Pos(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
		
	}
	
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<Pos> q;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new char[N][M];
		visited = new boolean[N][M][1 << 6];
		q = new LinkedList<Pos>();
		Pos start = null;
		
		for(int n = 0; n < N; n++) {
			String str = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
				
				if(map[n][m] == '0') {
					start = new Pos(n, m, 0, 0);
				}
			}
		}
		
		System.out.println(bfs(start));
	}

	private static int bfs(Pos start) {
		visited[start.x][start.y][start.key] = true; // 현재 상태의 방문 여부 처리

		while(!q.isEmpty()) {
			Pos current = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = current.x + dx[d];
				int ny = current.y + dy[d];
				int nk = current.key;
				
				if(nx < 0 || nx >= N || ny < 0 || ny > M || map[nx][ny] == '#')
					continue;
				
				// 탈출
				if(map[nx][ny] == 1) {
					return current.cnt + 1;
				}

				if(visited[nx][ny][nk])
					continue;
				
				// 문
				if("ABCDEF".contains(String.valueOf(map[nx][ny]))) {
					if((current.key & 1 << map[nx][ny] -'A') == 0){	// 비트 마스킹으로 키를 가지고 있는 경우 체크
					}
				}

				// 열쇠를 만났을 때
				if("abcdef".contains(String.valueOf(map[nx][ny]))) {
					nk = current.key | 1 << (map[nx][ny] -'a');
				}
				
				q.offer(new Pos(nx, ny, current.cnt + 1, nk));
				visited[nx][ny][nk] = true;
			}
		}
		
		return -1;
	}
}
