package com.ssafy.swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1247 {
	
	static class Vertex {
		int x;
		int y;
		int abs;
		
		Vertex(int x, int y, int abs){
			this.x = x;
			this.y = y;
			this.abs = abs;
		}

		@Override
		public String toString() {
			return "Vertex [x=" + x + ", y=" + y + ", abs=" + abs + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			
			
		}
		
	}
}
