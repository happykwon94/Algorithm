package com.ssafy.swea.d3;

// 21.08.29 종료 조건! 알파벳이 모두 사용되었을 때 i로 출력하려하면 출력이 안되므로 answer로 하나씩 세야한다.
// i로 출력하려면 알파벳이 모두 사용가능할 때에 대한 처리가 필요하다.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _7087 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++){
			int N = Integer.parseInt(br.readLine());
			boolean[] alpha = new boolean[26];
			int answer = 0;
			
			for(int n = 0; n < N; n++) {
				alpha[br.readLine().charAt(0) - 65] = true;
			}
			
			for(int i = 0; i < 26; i++) {
				if(!alpha[i]) {
					break;
				}
				
				answer++;
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
