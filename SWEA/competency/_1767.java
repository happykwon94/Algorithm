package com.ssafy.swea.competency;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/** 
 * 	반드시 모든 코어를 연결시킬 필요는 없다.
 * 		- 선택하고 안하고 두 경우를 비교해서 더 나은 상태를 선택
 * 		- 선택 가능한 코어를 조합해서 전선놓는 작업을 해야함
 * 		- 선택한 코어를 가지고 사방 탐색을 통해
 * 
 * 	1. 가장자리는 연결되어있으므로 고려하지 않고 배제
 * 	2. 나머지 코어들에 대해서 선택과 비선택을 구분지어 사방탐색하며 전선을 처리함
 * 	3. 다른 방향으로 다시 진행할 시 원상태로 전선을 복구함
 * 	*. 이해가 잘 안간다면 -> 완전 탐색(조합, 부분집합), 구현 부분 다시 보기
 * */
public class _1767 {
	static int N, ANS, chipCnt, maxChip;
	static int[][] MEMORY, COPY;
	static List<Point> list;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0 , 0, -1, 1};
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/_1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			MEMORY = new int[N][N];
			list = new ArrayList<Point>();
			ANS = Integer.MAX_VALUE;
			chipCnt = 0;
			maxChip = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					
					MEMORY[i][j] = Integer.parseInt(st.nextToken());
					
					if(MEMORY[i][j] == 1 && (i-1 < 0 || i+1 == N || j-1 < 0 || j+1 == N)) {
						MEMORY[i][j] = 2;
						continue;
					}

					if(MEMORY[i][j] == 1) {
						list.add(new Point(i, j));
						chipCnt++;
					}
				}
			}
			
			combination(0, 0, 0);
			
			System.out.println("#" + t + " " + ANS);
		}
	}
	
	
	private static void combination(int cnt, int start, int wire) {
		
		if(start + chipCnt - cnt < maxChip) {
			return;
		}
		
		if(cnt == chipCnt) {
			if(maxChip < start) {
				maxChip = start;
				ANS = wire;
			} else if(maxChip == start) {
				ANS = Math.min(ANS, wire);
			}
			return;
		}
		
		Point pos = list.get(cnt);
		for(int d = 0; d < 4; d++) {
			if(connectPos(pos.x, pos.y, d)) {
				combination(cnt+1, start + 1, wire + setWire(pos.x, pos.y, d, 2));
				setWire(pos.x, pos.y, d, 0);
			}
		}
		combination(cnt+1, start, wire);
		
	}
	
	private static boolean connectPos(int x, int y, int d) {
		int nx = x;
		int ny = y;
		while(true) {
			nx += dx[d];
			ny += dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N)
				return true;
			if(MEMORY[nx][ny] >= 1)
				return false;
		}
	}
	
	private static int setWire(int x, int y, int d, int status) {
		int cnt = 0;
		int nx = x;
		int ny = y;
		while(true) {
			nx += dx[d];
			ny += dy[d];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N)
				return cnt;
			MEMORY[nx][ny] = status;
			cnt++;
		}
	}
	
}
