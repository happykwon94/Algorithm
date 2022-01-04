package com.ssafy.swea.d3;

// 21.08.03

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1208 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		for(int i = 1; i <= 10; i++) {
			int dumpCnt = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] boxes = new int[100];
			
			for(int j = 0; j < 100; j++) {
				boxes[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(boxes);
			while(dumpCnt-- > 0) {
				if(boxes[99] - boxes[0] < 2)
					break;
				if(--boxes[99] - ++boxes[0] < 2)
					break;
				Arrays.sort(boxes);
			}
			
									
			sb.append("#").append(i).append(" ").append(boxes[99] - boxes[0]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
		st = null;
	}

}
