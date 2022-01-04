package com.ssafy.boj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1074 {
	static int result;
	static int N;
	static int R;
	static int C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);
		
		divide(0, 0, size);
		
		System.out.println(result);
		
	}
	
	private static void divide(int r, int c, int size) {
		if(R == r && C == c ) {
			return;
		}
		
		int midR = size/2;
		int midC = size/2;
		
		if(midR >= r &&  midC >= c) {
			divide(0, 0, size/2);
		}
		else if(midR >= r &&  midC < c) {
			result += Math.pow(size/2, 2);
			divide(r, c+size/2, size/2);

		}
		else if(midR < r &&  midC >= c) {
			result += Math.pow(size/2, 2)*2;
			divide(r+size/2, c, size/2);
		}
		else {
			result += Math.pow(size/2, 2)*3;
			divide(r+size/2, c+size/2, size/2);
		}
		
		
	}
}
