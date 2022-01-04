package com.ssafy.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9229 {
	
	static int N;
	static int M;
	static int MAX;
	static int[] arr;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			numbers = new int[2];
			MAX = -1;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
						
			combination(0, 0);
			
			System.out.println("#"+ t + " " + MAX);
		}
		
		br.close();
	}
	
	private static void combination(int start, int cnt) {
		if(cnt > 1) {
			int max = numbers[0] + numbers[1];
			
			if(max > M) {
				return ;				
			}
			else {
				MAX = MAX >= max ? MAX : max;				
				return ;
			}			
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = arr[i];
			combination(i+1, cnt+1);
		}
	}
	
}
