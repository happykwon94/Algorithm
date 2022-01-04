package com.ssafy.boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17144 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int R, C, T, map[][], cleaner[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		cleaner = new int[2][];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					cleaner[r%2] = new int[]{r, c}; 
				}
			}
		}
		
		for(int t = 0; t < T; t++) {
			// 확산
			diffusion();
			
			// 청정
			clean();
		}
		
		System.out.println(result());
	}

	private static int result() {
		int sum = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == -1) 
					continue;
				
				sum += map[r][c];
			}
		}
		
		return sum;
	}

	private static void clean() {
		// 반시계
		int temp =  0, pos = 0;
		temp = map[0][0];
		while(pos < C-1) {
			map[0][pos] = map[0][pos+1];
			pos++;
		}
		
		// 오른쪽
		pos = 1;
		while(pos <= cleaner[0][0]) {
			map[pos-1][C-1] = map[pos][C-1];
			pos++;
		}
		
		// 밑
		pos = C-1;
		while(pos > 0) {
			if(map[cleaner[0][0]][pos-1] == -1) {
				pos--;
				continue;
			}
				
			map[cleaner[0][0]][pos] = map[cleaner[0][0]][pos-1];
			pos--;
		}
		
		pos = cleaner[0][0]-1;
		while(pos > 1) {
			map[pos][0] = map[pos-1][0];
			pos--;
		}
		
		map[1][0] = temp;
		
		// 시계
		// 왼쪽
		pos = cleaner[1][0];
		while(pos < R-1) {
			map[pos][0] = map[pos+1][0];
			pos++;
		}
		
		map[cleaner[1][0]][cleaner[1][1]] = 0;
		
		// 아래
		pos = 0;
		while(pos < C-1) {
			map[R-1][pos] = map[R-1][pos+1];
			pos++;
		}
		
		// 오른쪽
		pos = R-1;
		while(pos > cleaner[1][0]) {
			map[pos][C-1] = map[pos-1][C-1];
			pos--;
		}
		
		// 위
		pos = C-1;
		while(pos > 1) {
			map[cleaner[1][0]][pos] = map[cleaner[1][0]][pos-1];
			pos--;
		}
		
		map[cleaner[1][0]][1] = 0;
		map[cleaner[1][0]][0] = -1;
		
	}

	private static void diffusion() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				// 미세먼지 덩어리
				if(map[r][c] != 0 && map[r][c] != -1) {
					// 확산
					// 확산되는 양
					int A = map[r][c]/5;
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1)
							continue;
						
						map[nr][nc] += A;
						map[r][c] -= A;
					}
				}
			}
		}
	}
}
