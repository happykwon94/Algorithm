package com.ssafy.boj.improve.silver;
import java.util.Scanner;

public class _1074 {
	static int ans;
	public static void solve(int n, int r, int c) {
		if (n == 2) { // 2x2일 경우
			if 		(r % n == 0 && c % n == 1) ans += 1;	// 2사분면
			else if (r % n == 1 && c % n == 0) ans += 2;	// 3사분면	
			else if (r % n == 1 && c % n == 1) ans += 3;	// 4사분면
			return;
		} 
		// 2 * 2 보다 클경우.. 재귀 호출..
		int newSize = n / 2;
		int loc;
		// 한면의 크기
		if 		(r % n <  newSize && c % n <  newSize) loc = 0;	// 1사분면
		else if (r % n <  newSize && c % n >= newSize) loc = 1;	// 2사분면
		else if (r % n >= newSize && c % n <  newSize) loc = 2;	// 3사분면
		else 	loc = 3;	// 4사분면
		
		long cnt = newSize * newSize;
		ans += loc * cnt;
		
		solve(newSize, r, c);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// N, r, c
		solve((int) Math.pow(2, sc.nextInt()), sc.nextInt(), sc.nextInt());
		System.out.println(ans);
	}
}