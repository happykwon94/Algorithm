package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 {
	
	static int MAX;
	static String org;
	static int swapCnt;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			org = st.nextToken();
			swapCnt = Integer.parseInt(st.nextToken());
			
			MAX = Integer.parseInt(org);
			
			combination(0, 0);
			
			System.out.println("#" + t + " " + MAX);
		}
	}
	
	private static void combination(int start, int cnt) {
		if(cnt == swapCnt) {
			int max = Integer.valueOf(org);
			MAX = Math.max(MAX, max);
			return;
		}
		
		for(int i = start; i < org.length(); i++) {
			for(int j = i+1; j < org.length(); j++) {
				if(org.charAt(i) <= org.charAt(j)) {
					swap(i, j);
					combination(i, cnt+1);
					swap(j, i);
				}
			}
			
		}
		
	}
	
	private static void swap(int src, int dst) {
		char[] ch = org.toCharArray();
		char temp = ch[src];
		ch[src] = ch[dst];
		ch[dst] = temp;
		org = String.valueOf(ch);
	}
}
