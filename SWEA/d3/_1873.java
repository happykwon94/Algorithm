package com.ssafy.swea.d3;

// 21.08.04 improve 폴더처럼 static 처리하는 게 더 깔끔하고 성능이 좋더라

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1873 {
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
			
			char[][] map = new char[H][];
			
			for(int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
			}
			
			// 전차 현재 포지션
			int posH = -1;
			int posW = -1;
			
			// 전차의 현재 위치 찾기
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
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
			for(int i = 0; i <N; i++) {
				char c = command.charAt(i);
				switch(c) {
				case 'U':
					if(verifyMap(H, W, posH-1, posW)) {
						if(map[posH-1][posW] == '.') {
							map[posH-1][posW] = '^';
							map[posH][posW] = '.';
							posH--;
						} else {
							map[posH][posW] = '^';
						}
						
					}
					map[posH][posW] = '^';
					break;
				case 'D':
					if(verifyMap(H, W, posH+1, posW)) {
						if(map[posH+1][posW] == '.') {
							map[posH+1][posW] = 'v';
							map[posH][posW] = '.';
							posH++;
						} else {
							map[posH][posW] = 'v';
						}
					}
					map[posH][posW] = 'v';
					break;
				case 'L':
					if(verifyMap(H, W, posH, posW-1)) {
						if(map[posH][posW-1] == '.') {
							map[posH][posW-1] = '<';
							map[posH][posW] = '.';
							posW--;
						} else {
							map[posH][posW] = '<';
						}
					}		
					map[posH][posW] = '<';
					break;
				case 'R':
					if(verifyMap(H, W, posH, posW+1)) {
						if(map[posH][posW+1] == '.') {
							map[posH][posW+1] = '>';
							map[posH][posW] = '.';
							posW++;
						} else {
							map[posH][posW] = '>';
						}
					}					
					map[posH][posW] = '>';

					break;
				case 'S':
					int shootPosH = posH;
					int shootPosW = posW;
					
					// 현재 전차가 바라보고 있는 방향 탐색
					if(map[posH][posW] == '<') {
						while(verifyMap(H, W, shootPosH, shootPosW-1)) {
							shootPosW--;
							if(map[shootPosH][shootPosW] == '*') {
								map[shootPosH][shootPosW] = '.';
								break;
							} else if(map[shootPosH][shootPosW] == '#') {
								break;
							}
						}
					}
					if(map[posH][posW] == '>') {
						while(verifyMap(H, W, shootPosH, shootPosW+1)) {
							shootPosW++;
							if(map[shootPosH][shootPosW] == '*') {
								map[shootPosH][shootPosW] = '.';
								break;
							} else if(map[shootPosH][shootPosW] == '#') {
								break;
							}
						}
					}
					if(map[posH][posW] == 'v') {
						while(verifyMap(H, W, shootPosH+1, shootPosW)) {
							shootPosH++;
							if(map[shootPosH][shootPosW] == '*') {
								map[shootPosH][shootPosW] = '.';
								break;
							} else if(map[shootPosH][shootPosW] == '#') {
								break;
							}
						}
					}
					if(map[posH][posW] == '^') {
						while(verifyMap(H, W, shootPosH-1, shootPosW)) {
							shootPosH--;
							if(map[shootPosH][shootPosW] == '*') {
								map[shootPosH][shootPosW] = '.';
								break;
							} else if(map[shootPosH][shootPosW] == '#') {
								break;
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
}
