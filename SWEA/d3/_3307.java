package com.ssafy.swea.d3;

// 21.09.16

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3307 {

	static int[] arr;
	static int[] LIS;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			LIS = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			int size = 0;	// LIS에 채워지는 원소수
			for(int i = 0; i < N; i++) {
				// 존재하지 않는 값을 찾으므로 들어갈 위치를 구함
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
				LIS[temp] = arr[i];
				
				// 뒤에 붙는 경우
				if(temp == size) {
					size++;
				}
			}
			System.out.println("#" + t + " " + size);
		}
	}

}
