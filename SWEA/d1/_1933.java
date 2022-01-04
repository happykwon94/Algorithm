package com.ssafy.swea.d1;

// 21.07.20

import java.util.Scanner;

public class _1933 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		for(int i = N; i > 0; i--) {
			if(N%i == 0) {
				System.out.print(N/i + " ");
			}
		}
		
		scan.close();
	}
}
