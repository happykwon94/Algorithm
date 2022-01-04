package com.ssafy.boj.improve.bronze;

// 21.08.18 수학적 규칙을 사용, 뭔가 규칙이 있을 것 같으면 그냥 무식하게 나열하는 것도 방법

import java.util.Scanner;

public class _2839_another_2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		
		if(M == 4 || M == 7) {
			System.out.println(-1);
			return;
		}
		
		int ans = M / 5;
		
		if(M % 5 == 1 || M % 5 == 3) {
			ans += 1;
		} else if(M % 5 == 2 || M % 5 == 4){
			ans += 2;
		}

		System.out.println(ans);
		
		sc.close();
	}

}
