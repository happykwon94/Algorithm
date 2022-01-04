package com.ssafy.swea.d3;

// 21.08.24

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int[] posP = position(p);
			int[] posQ = position(q);

			System.out.println("#" + t + " " + value(posP[0]+posQ[0], posP[1]+posQ[1]));
		}
	}
	
	private static int[] position(int val) {
		int num = 1;
		for(int start = 1; ; start++) {
			for(int y = start, x = 1; y >= 1; y--, x++) {
				if(num == val)
					return new int[] {x, y};
				num++;
			}
		}
	}
	
	private static int value(int X, int Y) {
		int ans = 0;
		
		for(int x = 1; x <= X; x++) {
			ans += x;
		}
		
		for(int y = 1; y < Y; y++) {
			ans += X++;
		}
		
		return ans;
	}
	
}
