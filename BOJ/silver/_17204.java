package com.ssafy.boj.silver;

// 21.11.04

import java.util.Scanner;

public class _17204 {
	
	static int N, K, player[], answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		player = new int[N];
		visited = new boolean[N];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			player[i] = scan.nextInt();
		}
		
		solve(0, 0);
		
		if(answer == Integer.MAX_VALUE)
			answer = -1;
		
		System.out.println(answer);
		
		scan.close();

	}

	private static void solve(int start, int cnt) {
		if(player[start] == K) {
			answer = Math.min(answer, cnt+1);
			return;
		}
		
		if(visited[start])
			return;
		
		visited[start] = true;
		solve(player[start], cnt+1);
	}
}
