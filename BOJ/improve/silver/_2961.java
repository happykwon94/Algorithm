package com.ssafy.boj.improve.silver;

// 21.08.12 부분집합 문제를 비트 마스킹을 사용해서 해결

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2961 {
	
	static int N;
	static boolean[] isSelected;
	static int[] tart;
	static int[] bitterness;
	
	static int MIN;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 재료 갯수
		N = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[N];
		tart = new int[N];
		bitterness = new int[N];
		
		MIN = Integer.MAX_VALUE;
		
		// 맛 저장
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			tart[n] = Integer.parseInt(st.nextToken());
			bitterness[n] = Integer.parseInt(st.nextToken());
		}
		
		subSet();
		
		System.out.println(MIN);
		
		br.close();
	}
	
	private static void subSet() {
		
		// 아무것도 안고르는 경우는 없음
		for(int i = 1; i < Math.pow(2, N); i++) {
			int min = 0;
			int taste1 = 1;
			int taste2 = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					taste1 *= tart[j];
					taste2 += bitterness[j];
				}
			}
			
			min = Math.abs(taste1 - taste2);
			
			MIN = MIN < min ? MIN : min;
		}
	}
}
