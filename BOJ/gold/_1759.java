package com.ssafy.boj.gold;

// 21.08.23

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {
	
	static int L, C;
	static char[] org;
	static char[] enc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		org = br.readLine().replaceAll(" ", "").toCharArray();
		enc = new char[L];
		
		Arrays.sort(org);
		
		combination(0, 0);
		
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == L) {
			int consonantsCnt = 0, vowelsCnt = 0;
			
			for(int l = 0; l < L; l++) {
				if("aeiou".indexOf(enc[l]) == -1) {
					consonantsCnt++;
				} else {
					vowelsCnt++;
				}
			}
			
			if(consonantsCnt >= 2 && vowelsCnt >= 1) {
				System.out.println(String.valueOf(enc));
			}
			
			return;
		}
		
		for(int i = start; i < C; i++) {
			enc[cnt] = org[i];
			combination(cnt+1, i+1);
		}
		
	}
}
