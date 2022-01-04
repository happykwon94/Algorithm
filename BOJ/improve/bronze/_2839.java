package com.ssafy.boj.improve.bronze;

// 21.08.18 재귀적 방식

import java.util.Scanner;

public class _2839 {
	
	static int ans = -1, goal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		goal = sc.nextInt();
		
		if(goal == 4 || goal == 7) {
			System.out.println(ans);
			return ;
		}
		
		solve(0, 0); // 무게, 횟수
		
		sc.close();
	}
	
	private static void solve(int weight, int cnt) {
		// 초과해버리면 다시 되돌아감
		if(weight > goal) {
			return;
		}
		
		if(weight == goal) {
			System.out.println(cnt);
			System.exit(0);
		}
		
		solve(weight+5, cnt+1);
		
		// 5키로 넣다가 범위가 벗어나면 돌아가서 3키로로 시도
		solve(weight+3, cnt+1);
	}
}
