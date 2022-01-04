package com.ssafy.swea.competency;

// 21.08.19 구현에 규칙을 찾는 과정이 필요할 듯, 시뮬레이션 돌리면서 체크할 규칙 찾기

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5644 {
	
	static int[][] map;
	static int M;
	static int A;
	
	static char[] user1;
	static char[] user2;
	
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	
	static BC[] BCs;

	static int MAX;
	
	static class BC implements Comparable<BC>{
		int r;
		int c;
		int C;
		int P;
		
		public BC(int r, int c, int c2, int p) {
			super();
			this.r = r;
			this.c = c;
			this.C = c2;
			this.P = p;
		}

		@Override
		public int compareTo(BC o) {
			return o.P - this.P;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {			
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			BCs = new BC[A];
			user1 = br.readLine().replaceAll(" ", "").toCharArray();
			user2 = br.readLine().replaceAll(" ", "").toCharArray();

			
			// 충전영역 저장, 0번째에 0의 값을 가지는 BC를 넣어놔야 이후에 같은 방식으로 동작이 가능하다.
			for(int bc = 0; bc < A; bc++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				BCs[bc] = new BC(r, c, C, P);
			}
			
			Arrays.sort(BCs);
			
			BC[] temp = new BC[A+1];
			System.arraycopy(BCs, 0, temp, 1, A);
			
			temp[0] = new BC(0, 0, 0, 0);
			
			BCs = temp;
			
			MAX = 0;
			
			// 시작 좌표
			int r1 = 0, c1 = 0;
			int r2 = 9, c2 = 9;
			
			charge(r1, c1, r2, c2);
			
			// 이동시작
			for(int m = 0; m < M; m++) {
				
				// 새로운 좌표
				r1 += dr[user1[m]-'0'];
				c1 += dc[user1[m]-'0'];
				r2 += dr[user2[m]-'0'];
				c2 += dc[user2[m]-'0'];
				
				charge(r1, c1, r2, c2);

			}
				
			System.out.println("#"+t+" "+ MAX);
		}
	}
	
	private static void charge(int r1, int c1, int r2, int c2) {
		int[] userA = new int[2];
		int[] userB = new int[2];
		int a = 0, b = 0;
		
		// 주어진 충전소를 거치지 않으면 0으로 초기화 된 상태 유지
		for(int bc = 1; bc <= A; bc++) {
			if(distance(r1, c1, BCs[bc].r, BCs[bc].c) <= BCs[bc].C) {
				if(a < 2) {
					userA[a++] = bc;
				}
			}
			
			if(distance(r2, c2, BCs[bc].r, BCs[bc].c) <= BCs[bc].C) {
				if(b < 2) {
					userB[b++] = bc;
				}
			}
		}
		
		
		if(userA[0] != userB[0]) {
			MAX += BCs[userA[0]].P + BCs[userB[0]].P;
		} else {
			MAX += BCs[userA[0]].P + Math.max(BCs[userA[1]].P, BCs[userB[1]].P);
		}
	}
	
	private static double distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
