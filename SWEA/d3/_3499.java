package com.ssafy.swea.d3;

// 21.08.06 그냥 짝수, 홀수 나눠서 집어넣는 게 속도는 빠른데 메모리 낭비는 큼

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _3499 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" "); 
			
			
			sb.append("#").append(t).append(" ");
				
			for(int i = 0; i < N/2; i++) {
				sb.append(str[i]+" ");
				sb.append(str[N/2+i + N%2]+" ");
			}
			
			if(N%2 == 1) {
				sb.append(str[N/2]+" ");
			}
			
			sb.setLength(sb.length()-1);
			sb.append("\n");		
		}
		
		System.out.println(sb);
		br.close();
	}
}
