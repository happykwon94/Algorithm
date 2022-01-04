package com.ssafy.swea.improve.d3;

// indexOf 활용하면 문자열 인덱스 찾을 때 편하게 활용 가능

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_1873 {
	
	static char[][] map;
	static int posH = -1;
	static int posW = -1;
	
	static int[] dh = {-1, 1, 0, 0};
	static int[] dw = {0, 0, -1, 1};
	static char[] dir = {'^', 'v', '<', '>'};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			// 맵 구성
			st = new StringTokenizer(br.readLine(), " ");
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			map = new char[H][];
			
			for(int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
			}
			
			// 전차의 현재 위치 찾기
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
//					// dir이 -1이 아니라면 탱크의 위치
//					int dir = "<>^v".indexOf(map[h][w]);
//					if(dir != -1){
//						posH = h;
//						posW = w;
//					}
					
					if(map[h][w] == '<' || map[h][w] ==  '>' || map[h][w] == 'v' || map[h][w] == '^') {
						posH = h;
						posW = w;
						break;
					}
				}				
			}
			
			// 커맨드 입력 횟수
			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			
			// 커맨드 수행
			for(int i = 0; i < N; i++) {
				char c = command.charAt(i);
				switch(c) {
				case 'U':
					if(verifyMap(H, W, posH-1, posW)) {
						move(dh[0], dw[0], '^');
					}
					map[posH][posW] = '^';
					break;
				case 'D':
					if(verifyMap(H, W, posH+1, posW)) {
						move(dh[1], dw[1], 'v');
					}
					map[posH][posW] = 'v';
					break;
				case 'L':
					if(verifyMap(H, W, posH, posW-1)) {
						move(dh[2], dw[2], '<');
					}		
					map[posH][posW] = '<';
					break;
				case 'R':
					if(verifyMap(H, W, posH, posW+1)) {
						move(dh[3], dw[3], '>');
					}					
					map[posH][posW] = '>';

					break;
				case 'S':
					int shootPosH = posH;
					int shootPosW = posW;
					
					// 현재 전차가 어느 방향을 바라보고 있는지에 따른 동작
					for(int d = 0; d < 4; d++) {
						if(map[posH][posW] == dir[d]) {
							while(verifyMap(H, W, shootPosH+dh[d], shootPosW+dw[d])) {
								shootPosH += dh[d];
								shootPosW += dw[d];
								if(map[shootPosH][shootPosW] == '*') {
									map[shootPosH][shootPosW] = '.';
									break;
								} else if(map[shootPosH][shootPosW] == '#') {
									break;
								}
							}
						}
					}
					break;
				}
			}
			
			sb.append("#").append(t).append(" ");
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		
		// 마무리 처리
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
	
	private static boolean verifyMap(int H, int W, int posH, int posW) {
		if(posH < 0 || posH >= H || posW < 0 || posW >= W)
			return false;
		else
			return true;
		
	}
	
	private static void move(int dh, int dw, char move) {
		if(map[posH + dh][posW + dw] == '.') {
			map[posH+dh][posW+dw] = move;
			map[posH][posW] = '.';
			posH += dh;
			posW += dw;
		} else {
			map[posH][posW] = move;
		}
	}
}
