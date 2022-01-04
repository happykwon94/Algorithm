package com.ssafy.boj.bronze;

// 21.08.12

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3040 {
	
	static int[] arr;
	static int[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		selected = new int[7];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0);
		
		br.close();
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += selected[i];
			}
			
			// 조건을 만족하는 경우는 유일하므로 출력하고 강제 종료
			if(sum == 100) {
				for(int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
				}
				System.exit(0);
			}
			return ;
		}
		
		for(int i = start; i < 9; i++) {
			selected[cnt] = arr[i];
			combination(cnt+1, i+1);
		}
	}
}
