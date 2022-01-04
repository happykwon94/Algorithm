package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1984 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int[] arr = new int[10];
			int sum = 0;
			double avg;
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
						
			Arrays.sort(arr);
			
			sum -= (arr[0] + arr[9]);
			
			avg = sum/8.0;
			
			System.out.println("#" + t + " " + Math.round(avg));
			
		}
	}
}
