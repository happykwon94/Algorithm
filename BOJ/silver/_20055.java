package com.ssafy.boj.silver;

// 21.11.09 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20055 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		int len = 2*N;
		
		int[] belt = new int[len];
		
		boolean[] robots = new boolean[len];
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < len; n++) {
			belt[n] = Integer.parseInt(st.nextToken());
		}
		
		int on = 0;
		int off = N-1;

		while(K > 0) {
			// 앞자리에 로봇을 올림
			robots[on] = true;
			
			// 컨베이어 벨트 이동
			on--;
			off--;
			
			if(on < 0)
				on = len-1;
			if(off < 0)
				off = len-1;

			answer++;			
			
			// 컨베이어 벨트에 따라서 이동하는 처리
			
			
			// 로봇 이동 
			for(int n = off-1; n >= on; n--) {
				if(!robots[n])
					continue;
				
				if(n == off-1) {
					robots[n] = false;
					continue;
				}
				
				if(!robots[n+1] && belt[n+1] != 0) {
					robots[n] = false;
					robots[n+1] = true;
					belt[n+1]--;
					
					if(belt[n+1] == 0) {
						K--;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
