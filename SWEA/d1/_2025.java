package com.ssafy.swea.d1;

import java.util.Scanner;

public class _2025 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		
		System.out.println(sum);
		
		scan.close();
	}
}
