package com.ssafy.boj.silver;

// 21.09.16 플루이드 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _9205 {
	
	// 좌표로 관리
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			// 편의점(N) + 집 + 목적지
			int[][] map = new int[N+2][N+2];
			List<Pos> list = new LinkedList<>();
			
			// 좌표 정보 저장
			for(int n = 0; n < N+2; n++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			
			// 좌표 정보를 바탕으로 인접 행렬 구성
			for(int i = 0; i < N+2; i++) {
				Pos p1 = list.get(i);
				for(int j = 0; j < N+2; j++) {
					if(i == j)
						continue;
					
					Pos p2 = list.get(j);
					
					int distance = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
					
					// 맥주 20병 * 50미터 = 1000미터
					if(distance <= 1000)
						map[i][j] = 1;
					else {
						map[i][j] = 99999;	// 연결되어있지 않음
					}
				}
			}
			
			for(int k = 0; k < N+2; k++) {
				for(int i = 0; i < N+2; i++) {
					if(i == k)
						continue;
					for(int j = 0; j < N+2; j++) {
						if(i == j || j == k)
							continue;
						// k 지점까지 고려하여 i부터 j까지 이동할 수 있는 최단 거리
						map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
					}
				}
			}
			
			// 집부터 목적지까지 도달할 수 있는지 판별
			System.out.println(map[0][N+1] == 99999 ? "sad" : "happy");
		}
	
	}
}
