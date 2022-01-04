package com.ssafy.swea.d4;

// 21.08.03	출력이랑 입력 항상 확인하기

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _1210 {
	static int size = 100;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
				
		for(int t = 1; t <= 10; t++) {
			String count = br.readLine();
			int posC = size-1;
			
			char[][] map = new char[size][];
			
			for(int i = 0; i < size; i++) {
				map[i] = br.readLine().replaceAll(" ", "").toCharArray();
			}
			
			// 골인 지점 찾기
			for(int c = 0; c < size; c++) {
				if(map[size-1][c] == '2') {
					posC = c;
					break;
				}
			}
			
			for(int r = size-1; r >= 0; r--) {
				int left = posC-1;
				int right = posC+1;
				
				if(verify(left) && verify(right) && map[r][left] != '1' && map[r][right] != '1')
					continue;
				
				// 좌측이동
				if(verify(left) && map[r][left] == '1') {
					while(posC > -1 && map[r][posC] != '0') {
						posC--;
					}
					posC++;
					
				} else if(verify(right) && map[r][right] == '1') {
					// 우측 이동
					while(posC < size && map[r][posC] != '0') {
						posC++;
					}
					posC--;
				}

			}
			
			sb.append("#").append(count).append(" ").append(posC).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
		
	}
	
	private static boolean verify(int pos) {
		if(pos > -1 && pos < size) {
			return true;
		} else {
			return false;
		}
	}
}
