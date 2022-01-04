package com.ssafy.boj.improve.silver;
import java.util.Scanner;

public class _16926 {
	static int R, C;
	static int[][] map;
	static int rotateCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		rotateCnt = sc.nextInt();
		for (int r = 0; r < R; r++) {			 
			for (int c = 0; c < C; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		for (int cnt = 1; cnt <= rotateCnt; cnt++) {
			rotateMap();
		}
		printMap();
		
		sc.close();
	}
	
	// 우,하, 좌, 상 => 시계 방향으로 돌리면서 값을 이전값을 넣어줌
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static void rotateMap() {
		// 배열을 안쪽으로 몇번 회전해야 하는지 : 행과 열중에 짧은쪽의 값을 2로 나눈 것만큼 회전
		// 안쪽 사각형도 한 바퀴씩 이동
		// 가장 작은 사각형의 시작 좌표는 
		for (int cnt = 0, loopCnt = Math.min(R, C) / 2; cnt < loopCnt; cnt++) {
			// 최초값이 없어지므로 임시로 값을 저장한다.
			int temp = map[cnt][cnt];
			int x = cnt;
			int y = cnt;
			// 한바퀴 이동
			for (int i = 0; i < 4; i++) {
				while (true) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < cnt || nx >= R - cnt || ny < cnt || ny >= C - cnt) break;
					
					map[x][y] = map[nx][ny];
					
					x = nx;
					y = ny;
				}
			}
			// 마지막 위치의 값을 처리한다.
			map[cnt + 1][cnt] = temp;
		}
	}
	static void printMap() {
		for (int r = 0; r < R; r++) {			 
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c] + " "); 
			}
			System.out.println();
		}
	}
}
