package com.ssafy.swea.d3;

// 21.08.29 에라토스테네스의 체 사용, 미리 배수들을 다 구해놓는다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4698 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[1000001];
		
		makePrime(prime, 1000001);
		
		for(int t = 1; t <= T; t++) {
			int answer = 0;
			
			st = new StringTokenizer(br.readLine());
			
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int i = A; i <= B; i++) {
				if(!prime[i] && String.valueOf(i).contains(D)) {
					answer++;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
	}

	private static void makePrime(boolean[] prime, int len) {
		prime[1] = true;
		for(int i = 2; i < Math.sqrt(len); i++) {
			
			if(prime[i])
				continue;
			
			// 배수 체크
			for(int j = i*2; j < len; j += i) {
				prime[j] = true;
			}
		}
	}
}
