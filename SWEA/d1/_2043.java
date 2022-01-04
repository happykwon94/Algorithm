package com.ssafy.swea.d1;

// 21.07.20

import java.util.Scanner;

public class _2043 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int P = scan.nextInt();
		int K = scan.nextInt();
		
		System.out.println(P - K + 1);
	
		scan.close();
	}
}
