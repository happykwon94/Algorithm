package com.ssafy.swea.improve.d3;

// 21.08.03

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol_1208 {
	static int dumpCnt, min = 0, max = 99, boxes[] = new int[100];
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		for(int i = 1; i <= 10; i++) {
			dumpCnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] boxes = new int[100];
			
			for(int j = 0; j < 100; j++) {
				boxes[j] = Integer.parseInt(st.nextToken());
			}
							
			sb.append("#").append(i).append(" ").append(solve()).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
		st = null;
	}
	
	// Sort 횟수 줄이기
	private static int solve() {
		
		Arrays.sort(boxes);
		
		for(int i = 0; i < dumpCnt; i++) {
			int v = diff();
			
			// 이미 평탄화가 완료되어있는 경우, 차이가 1 or 0인 경우
			if(v < 2) {
				return v;
			}
			
			boxes[min]++;
			boxes[max]--;
			
			changeMin();
			changeMax();
		}
		
		return diff();
	}
	
	private static void changeMin() {
		if(boxes[min] <= boxes[min+1]) {
			min = 0;
		} else {
			min++;
		}
	}

	private static void changeMax() {
		if(boxes[max] >= boxes[max-1]) {
			max = 99;
		} else {
			max--;
		}
	}
	
	private static int diff() {
		return boxes[max] - boxes[min];
	}
}
