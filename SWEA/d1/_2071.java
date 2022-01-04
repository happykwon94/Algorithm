package com.ssafy.swea.d1;

//21.07.19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2071 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int count = 0;
		
		
		while(count++ < T) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			double avg;
			
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			avg = sum/10.0;
			
			
			sb.append("#").append(count+" ").append(Math.round(avg)+"\n");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
		
	}	
	
	
}
