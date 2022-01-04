package com.ssafy.swea.d1;

// 21.07.20

import java.util.Scanner;

public class _1936 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		
		if(A == 1) {
			if(B == 2) {
				System.out.println('B');
			}
			if(B == 3) {
				System.out.println('A');			
			}		
		}
		
		if(A == 2) {
			if(B == 1) {
				System.out.println('A');
			}
			if(B == 3) {
				System.out.println('B');				
			}				
		}
		
		if(A == 3) {
			if(B == 1) {
				System.out.println('B');			
			}
			if(B == 2) {
				System.out.println('A');
			}				
		}
		
		scan.close();
	}
}
