package com.ssafy.swea.d1;

// 21.07.20

import java.util.Scanner;

public class _2019 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int val = 1;
		
		for(int i = 0; i < n+1; i++) {
			System.out.print(val+" ");
			val *= 2;
		}
		
		scan.close();
	}
}
