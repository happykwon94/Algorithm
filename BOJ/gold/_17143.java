package com.ssafy.boj.gold;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17143 {
	
	static class Shark{
		int r, c, s, d, z;

		// (r, c) : 좌표
		// s : 속력
		// d : 이동 방향
		// z : 크기
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Shark other = (Shark) obj;
			if (this.c != other.c)
				return false;
			if (this.r != other.r)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
	
	static int R, C, M, score;
	static Shark map[][], sharks[];

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sharks = new Shark[M];
		map = new Shark[R][C];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());	// 속력
			int d = Integer.parseInt(st.nextToken()) - 1;	// 이동방향
			int z = Integer.parseInt(st.nextToken());	// 크기
			
			map[r][c] = new Shark(r, c, s, d, z);
			sharks[m] = new Shark(r, c, s, d, z);
		}
		
		
		score = 0;
		// 가장 오른쪽에 도착할 때까지 이동
		for(int t = 0; t < C; t++) {
			search(t);	// t번째 열에 대해서 상어 찾아서 제거
			positionSet(); // 상어가 이동할 위치 계산
			move();	// 상어 이동
		}
				
		System.out.println(score);
	}

	private static void search(int c) {
		for(int r = 0; r < R; r++) {
			if(map[r][c] != null) {
				score += map[r][c].z;
				remove(map[r][c]);
				map[r][c] = null;
				return;
			}
		}
	}
	
	private static void remove(Shark s) {
		for(int i = 0; i < sharks.length; i++) {
			if(s.equals(sharks[i])) {
				sharks[i] = null;
				return;
			}
		}
	}

	private static void positionSet() {
		for(int m = 0; m < sharks.length; m++) {
			if(sharks[m] != null) {
				// 기존 위치에서 제거
				map[sharks[m].r][sharks[m].c] = null;
				
				for(int s = 0; s < sharks[m].s; s++) {
					int nr = sharks[m].r + dr[sharks[m].d];
					int nc = sharks[m].c + dc[sharks[m].d];
					
					if(nr < 0) {
						nr = 1;
						sharks[m].d = 1;
					}else if(nr >= R) {
						nr = R - 2;
						sharks[m].d = 0;
					} else if(nc < 0) {
						nc = 1;
						sharks[m].d = 2;
					} else if(nc >= C){
						nc = C - 2;
						sharks[m].d = 3; 
					}
					
					// 새로운 정보 입력
					sharks[m].r = nr;
					sharks[m].c = nc;
				}
			}
		}
	}
	
	private static void move() {
		
		map = new Shark[R][C];
		
		for(int m = 0; m < M; m++) {
			if(sharks[m] != null) {
				int r = sharks[m].r;
				int c = sharks[m].c;
				
				// 그 자리에 상어가 없었다면
				if(map[r][c] == null) {
					map[r][c] = sharks[m];
					continue;
				}
			
				// 그 자리에 존재하던 상어가 더 크다.
				if(map[r][c].z > sharks[m].z) {
					remove(sharks[m]);
				} else { // 새로온 상어가 더 크다.
					remove(map[r][c]);	// 있던 상어 제거
					map[r][c] = sharks[m];
				}
			}
		}
	}
}
