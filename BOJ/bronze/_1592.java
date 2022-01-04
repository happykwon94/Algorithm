package com.ssafy.boj.bronze;

// 21.08.29

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1592 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] count = new int[N];
		
		int answer = 0;
		int idx = 0;
		count[idx] = 1;
		
		while(true) {
			if(count[idx] == M)
				break;
			
			if(count[idx] % 2 == 0) {
				idx = (idx + L) % N;
			} else {
				idx = (N + (idx-L)) % N;
			}
			
			count[idx]++;
			answer++;
		}
		
		System.out.println(answer);
	}
}
