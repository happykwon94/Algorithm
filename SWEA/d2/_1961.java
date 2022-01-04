package com.ssafy.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1961 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] org = new int[N][N];
			String[] str = new String[N];
			
			for(int n = 0; n < N; n++) {
				str[n] = "";
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					org[n][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int n = 0; n < 3; n++) {
				org = rotate(org);
				print(org, str);
			}
			
			
			System.out.println("#" + t);
			for(int n = 0; n < N; n++) {
				System.out.println(str[n]);
			}
			
		}
	}
	
	private static int[][] rotate(int[][] org){
		int size = org.length;
		int[][] copy = new int[size][size];
		
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				copy[c][size - r - 1] = org[r][c];
			}
		}
		org = copy;
		return org;
	}
	
	private static void print(int[][] arr, String[] str) {
		int len = arr.length;
		for(int r = 0; r < len; r++) {
			for(int c = 0; c < len; c++) {
				str[r] += arr[r][c];
			}
			str[r] += " ";
		}
	}
}
