package com.ssafy.boj.silver;

// 21.09.24	BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576 {
	
	static class Pos{
		int x, y;
		int day;

		public Pos(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int N, M, box[][];
	static int result;
	static int[] dn = {-1, 1, 0, 0};
	static int[] dm = {0, 0, -1, 1};
	static Queue<Pos> q;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		q = new LinkedList<Pos>();;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken());
				
				if(box[n][m] == 1) {
					q.offer(new Pos(n, m, 0));
				}
			}
		}
		
		result = 0;
		
		BFS();
		
		if(possible())
			System.out.println(result);
		else
			System.out.println(-1);
	}

	private static boolean possible() {
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(box[n][m] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static void BFS() {
		
		while(!q.isEmpty()) {
			Pos current = q.poll();
			
			if(current.day != result) {
				result++;
			}
			
			for(int d = 0; d < 4; d++) {
				int nn = current.x + dn[d];
				int nm = current.y + dm[d];
				
				if(nn < 0 || nn >= N || nm < 0 || nm >= M || box[nn][nm] == -1)
					continue;
				
				if(box[nn][nm] == 0) {
					q.offer(new Pos(nn, nm, current.day+1));
					box[nn][nm] = 1;
				}
			}
			
		}
		
	}
}
