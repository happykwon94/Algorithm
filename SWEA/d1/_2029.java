package com.ssafy.swea.d1;

// 21.07.20

import java.util.Scanner;

public class _2029 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int t = 1;
		
		while(T-- > 0) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			System.out.println("#"+ t++ + " " + x/y + " " + x%y);
		}
		
		scan.close();
	}
}
