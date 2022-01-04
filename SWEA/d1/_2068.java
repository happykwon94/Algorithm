package com.ssafy.swea.d1;

//21.07.19

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2068 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		int count = 0;
		
		while(count++ < T) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int maximum = Integer.parseInt(st.nextToken());
			
			while(st.hasMoreTokens()) {
				int val = Integer.parseInt(st.nextToken());
				maximum = (val > maximum) ? val : maximum;
				
			}
			
			sb.append("#"+count).append(" "+maximum+"\n");
		}
		
		System.out.println(sb);
		
		sb = null;
		br.close();
	}
}
