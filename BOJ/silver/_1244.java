package com.ssafy.boj.silver;

// BOJ 21.08.02

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 	y값의 변화에 따라 진행 방향이 바뀜, ㄱㄴ형태로 움직이고 형태가 바뀔 때마다 이동의 증감이 바뀐다.
 * 	이를 기본 규칙으로 진행하면 사방탐색 방식 외에 다른 방식으로 구현 가능
 * */

public class _1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int students = Integer.parseInt(br.readLine());
		
		while(students-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int gender = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			
			change(arr, gender, switchNum);
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
			
			// 20개마다 줄바꿈
			if(i != 0 && ((i+1)%20 == 0))
				sb.append("\n");
		}
		
		// 마지막 여백 제거
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	}
	
	// 성별에 맞는 동작
	public static void change(int[] arr, int gender, int switchNum) {
		if(gender == 1) {
			// switchNum의 배수에 스위치 동작
			// for(int i = switchNum; i < arr.length; i += switchNum)
			for(int i = 0; i < arr.length; i++) {
				if((i+1) % switchNum == 0) {
					arr[i] = swap(arr[i]);
				}
			}
			
		} else {
			int left = switchNum - 2;
			int right = switchNum;
			// 좌, 우가 다르기 전까지 스위치 동작
			while((left >= 0 && right < arr.length) && (arr[left] == arr[right])) {
				arr[left] = swap(arr[left]);
				arr[right] = swap(arr[right]);
				left--;
				right++;
			}
			
			// switchNum에 해당하는 자리 스위치 동작
			arr[switchNum-1] = swap(arr[switchNum-1]);
		}
	}
	
	public static int swap(int num) {
		if(num == 1) {
			return 0;
		} else {
			return 1;
		}
	}
	
}
