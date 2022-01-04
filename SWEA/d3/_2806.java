package com.ssafy.swea.d3;

// 21.08.19 백트래킹

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2806 {
	
	
	static int N;
	static int result;
	static int[] col;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			result = 0;
			
			col = new int[N+1];
			
			setQueens(1);
		
			System.out.println("#" + t + " " + result);
		}
		
		br.close();
	}
	
	private static void setQueens(int row) {
		
		// 기저조건 마지막 행까지 놓고 다음 초과한 행 순서가 왔을 때 배치가 끝났다.
		if(row > N) {
			result++;
			return ;
		}	
		
		//	현재 퀸 1열부터 N열까지 놓은 위치 상태 기억하기
		//	놓았으면 다음 row에 퀸 놓으러 가기
		// 	row번째 행, i번째 열에 위치
		for(int i = 1; i <= N; i++) {
			col[row] = i;
			
			// 유망여부 체크 : 현재 퀸을 놓으려 할 때 이전까지의 위치가 유망한지 검증
			// 이전 과정이 유망하지 않았으면 지금 놓아도 의미가 없으므로 종료
			if(isAvailable(row)) {
				// 다음 행에 놓으라고 보냄
				setQueens(row+1);
			}
		}
	}
	
	// setQueens에서 row번째 퀸 놓기전 row-1번 째 퀸을 검사할 것
	private static boolean isAvailable(int row) { // 현재 검사할 퀸
		
		// 직전까지 놓여진 퀸들의 위치가 유망한지 검사
		// k : 이전 퀸
		for(int k = 1; k < row; k++) {
			// 현재 검사할 퀸과 이전의 값들이 유망한지 검사
			// 열이 겹친다 || 열의 차이와 행의 차이가 같다(대각선)
			if(col[row] == col[k] || Math.abs(col[row] - col[k]) == (row - k)) {
				return false;
			}
		}
		
		return true;
	}
	
}
