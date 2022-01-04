package com.ssafy.swea.competency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5656 {
	
	static int N, W, H, map[][], org[][];
	static int[] dPoint;
	static int blocks, dBlocks;
	
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
			
			org = new int[H][W];
			dPoint = new int[N];
			blocks = dBlocks = 0;
			
			for(int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0; w < W; w++) {
					org[h][w] = Integer.parseInt(st.nextToken());
					
					if(org[h][w] != 0)
						blocks++;
				}
			}
			
			selectDropPoint(0, 0);
			
			System.out.println("#" + t + " ");
		}

		selectDropPoint(0, 0);
	}
	
	private static void selectDropPoint(int cnt, int start) {
		if(cnt == N) {
			mapCopy();
			return;
		}
		
		for(int i = start; i < W; i++) {
			dPoint[cnt] = i;
			selectDropPoint(cnt+1, i);
		}
	}
	
	private static void drop() {
		for(int i = 0; i < N; i++) {
			bomb(dPoint[i]);
		}
	}

	private static void bomb(int w) {
		for(int p = 0; p < H; p++) {
			if(map[p][w] != 0) {
				
				for(int d = 0; d < 4; d++) {
					int range = map[p][w];
					int nr = p + dr[d];
					int nc = w + dc[d];
					
					while(nr >= 0 && nr < H && nc >= 0 && nc < W) {
						
					}
				}
				
				break;
			}
		}
	}

	private static void mapCopy() {
		map = new int[H][W];
		
		for(int h = 0; h < H; h++) {
			map[h] = Arrays.copyOf(org[h], W);
		}
	}
}
