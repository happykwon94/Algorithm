package com.ssafy.swea.d3;

// 21.09.16

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1213 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			
			String target = br.readLine();
			
			String str = br.readLine();
			
			String[] sub = str.split(target);
			
			if(str.endsWith(target)) {
				System.out.println("#" + t + " " + (sub.length));
				continue;
			}
			System.out.println("#" + t + " " + (sub.length-1));
		}
	
	}
}
