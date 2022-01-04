package com.ssafy.boj.gold;

// 21.08.11 배열을 static 변수로 선언했으면 한 번 동작했을 때 변한 상태이므로 원본을 따로 가지고 있어야 한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17406 {
	
	static int min;
	
	static String[] selected;
	static boolean[] isChecked;
	static String[] input;

	static int N;
	static int M;
	static int R;
	static int[][] arr;
	static int[][] org;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
	
		org = new int[N][M];
		selected = new String[R];
		input = new String[R];
		isChecked = new boolean[R];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m < M; m++) {
				org[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < R; r++) {
			input[r] = br.readLine();
		}
		
		min = Integer.MAX_VALUE;
		
		permutation(0);
		
		System.out.println(min);
		
		br.close();
	}
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			
			arrayCopy();
			
			for(int i = 0; i < R; i++) {
				String[] str = selected[i].split(" ");
				int r = Integer.parseInt(str[0]);
				int c = Integer.parseInt(str[1]);
				int s = Integer.parseInt(str[2]);
				rotate(r, c, s);
			}
			
			minVal();
			
			return ;
		}
		
		for(int i = 0; i < R; i++) {
			if(isChecked[i]) {
				continue;
			}
			
			selected[cnt] = input[i];
			isChecked[i] = true;
			
			permutation(cnt + 1);
			
			isChecked[i] = false;
		}
	}

	private static void rotate(int r, int c, int s) {
		
		for (int cnt = 0; cnt < s; cnt++) {
			
			int limitX = r - s - 1 + cnt;
			int limitY = c - s - 1 + cnt;
			int x = limitX;
			int y = limitY;
			int temp = arr[x][y];
			for (int i = 0; i < 4; i++) {
				while (true) {
					int nx = x + dr[i];
					int ny = y + dc[i];
					if (nx < limitX || nx >= r + s - cnt || ny < limitY || ny >= c + s  - cnt) break;
					
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}
			}
			// 마지막 위치의 값을 처리한다.
			arr[x][y+1] = temp;
		}
	}
	
	private static void minVal() {
		for(int n = 0; n < N; n++) {
			int sum = 0;
			for(int m = 0; m < M; m++) {
				sum += arr[n][m];
			}
			min = min < sum ? min : sum;
		}
	}
	
	private static void arrayCopy() {
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			arr[i] = Arrays.copyOf(org[i], M);
		}
	}
}
