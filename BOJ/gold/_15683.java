package com.ssafy.boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15683 {
	
	static int N, M;
	static char[][] org;
	static char[][] room;
	static int target;
	static int answer;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static List<CCTV> list;
	
	static class CCTV{
		int r, c;
		int type;
		int[][] state;
		
		public CCTV(int r, int c, int type, int[][] state) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
			this.state = state;
		}

		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", type=" + type + ", state=" + state + "]";
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		org = new char[N][M];
		room = new char[N][M];
		list = new ArrayList<>();
		target = 0;
		answer = Integer.MAX_VALUE;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m < M; m++) {
				org[n][m] = st.nextToken().charAt(0);
				
				if(org[n][m] == '0') {
					target++;
					continue;
				}
				
				if(org[n][m] != '6') {
					list.add(new CCTV(n, m, org[n][m] - '0', possiblePos(org[n][m] - '0')));
				}
			}
		}
		
		dfs(0, target);
		
		System.out.println(answer);
		
	}
	
	private static void dfs(int cnt, int target) {
		if(cnt == list.size()) {
			answer = Math.min(answer, target);
			return;
		}
		
		// 리스트 순회
		for(int i = cnt; i < list.size(); i++) {
			
			copyRoom();
			
			// 리스트의 씨씨티비 하나에 접근
			CCTV cctv = list.get(i);
			for(int r = 0; r < cctv.state.length; r++) {
				for(int in = 0; in < cctv.state[r].length; in++) {
					dfs(cnt+1, target - watch(cctv.r, cctv.c, cctv.state[r][in]));
				}
			}
			
		}
		
	}
	
	private static int watch(int r, int c, int dir) {
		
		int remove = 0;
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] == '6') {
				break;
			}
			
			room[nr][nc] = '#';
			remove++;
		}
		
		return remove;
	}
	
	private static int[][] possiblePos(int type){
		if(type == 1) {
			return new int[][]{{0}, {1}, {2}, {3}};
		}
		if(type == 2) {
			return new int[][]{{0, 1}, {2, 3}};
		}
		if(type == 3) {
			return new int[][]{{0, 3}, {1, 3}, {1, 2}, {0, 2}};
		}
		if(type == 4) {
			return new int[][]{{2, 3, 0}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}};
		}
		if(type == 5) {
			return new int[][]{{0, 1, 2, 3}};
		}
		
		return null;
	}
	
	private static void copyRoom() {
		for(int n = 0; n < N; n++) {
			System.arraycopy(org[n], 0, room[n], 0, M);
		}
	}
}
