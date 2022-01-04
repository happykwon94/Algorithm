package com.ssafy.boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/** 
 * 	최소한의 동작으로 이동 => BFS
 * 	원숭이가 뛴 좌표 정보를 구할 때 x, y 좌표, k횟수, 이동횟수를 체크
 * 	도착지까지 다 막혀있어도 말이라면 뛰어서 들어갈 수 있으므로 방문 체크를 따로 진행해주어야 한다.
 * 	[참조] https://heedipro.tistory.com/259
 * */
public class _1600 {
	// 말처럼 뛰는 횟수, 넓이, 높이
	static int K, W, H;
	
	static class Point{
		int x, y, k, cnt;
		
		// x좌표, y좌표, 말처럼 이동한 횟수, 전체 이동횟수
		public Point(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
		
	}
	
	static int[] dr = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};
	
	static int[][] map;
	
	// K를 쓰면서 왔는지 아닌지 판별할 배열
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		// K는 0일수도 있으므로 K가 1일때 1, 0을 구분해주기 위함
		visited = new boolean[H][W][K+1];
		
		for(int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}
				
		BFS();
		
	}
	
	private static void BFS() {
		// 좌표 정보 관리할 큐
		Queue<Point> q = new LinkedList<>();
		
		// x, y좌표, K 아직 안씀, cnt 아직 안움직임
		q.offer(new Point(0, 0, 0, 0));
		
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point pos = q.poll();
			
			// 꺼낸 좌표가 중간에 반복을 벗어나는 경우
			// 꺼낸 Point의 x, y의 좌표가 목표 지점에 도착해있다면 더 이상 반복을 진행할 필요가 없다.
			if(pos.x == H-1 && pos.y == W-1) {
				System.out.println(pos.cnt);
				return ;
			}
			
			for(int d = 0; d < (pos.k < K ? 12 : 4); d++) {
				
				int nr = pos.x + dr[d];
				int nc = pos.y + dc[d];
				
				// 사방 탐색을 한 것이라면 원숭이처럼 움직인 것, 말처럼 무빙 친거면 말처럼 움직인 것이므로 pos.k+1
				int nk = (d < 4 ? pos.k : pos.k + 1);
				
				int nCnt = pos.cnt + 1;
				
				// 방문했는지, 장애물인지, 범위 밖인지 유효한 위치 여부 판별
				if(nr < 0 || nr >= H || nc < 0|| nc >= W || map[nr][nc] == 1)
					continue;
				
				// 이동 지점 확인
				if(visited[nr][nc][nk])
					continue;
				
				visited[nr][nc][nk] = true;
				q.offer(new Point(nr, nc, nk, nCnt));
			}
		}
		// 반복문으로 map을 다 돌았는데 목표지점까지 도달하지 못했다. or 도달할 수 없었다.
		System.out.println(-1);
		return;
	}
}
