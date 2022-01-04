package com.ssafy.boj.silver;

// 21.08.12 부분집합을 사용하여 맛을 고르는 모든 경우를 탐색하는 문제

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
		
		subSet(0);
		
		System.out.println(MIN);
		
		br.close();
	}
	
	private static void subSet(int cnt) {
		if(cnt == N) {
			int min = 0;
			int taste1 = 1;
			int taste2 = 0;
			for(int n = 0; n < N; n++) {
				if(isSelected[n]) {
					taste1 *= tart[n];
					taste2 += bitterness[n];
				}
			}
			
			min = Math.abs(taste1 - taste2);
			
			if(taste1 != 1 && taste2 != 0) {
				MIN = MIN < min ? MIN : min;
			}
			
			return;
		}
		
		// 재료를 선택한 경우
		isSelected[cnt] = true;
		subSet(cnt+1);
		
		// 재료를 선택하지 않은 경우
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
}
