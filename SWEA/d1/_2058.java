package com.ssafy.swea.d1;

// 21.07.19

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2058 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int sum = 0;
		
		for(int i = 0; i < N.length(); i++) {
			sum += Character.getNumericValue(N.charAt(i));
		}
		
		System.out.println(sum);
		
		br.close();
		N = null;
	}
}
