package com.ssafy.swea.d2;

// 21.07.20 count변수로 3, 6, 9인 경우 '-'를 붙이는 과정을 수행함. 단, count가 1인 경우는 '-'를 한번만 출력하고 넘어감

import java.util.Scanner;

public class _1926 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = scan.nextInt();
		
		for(int i = 1; i <= N; i++) {
			
			String str = String.valueOf(i);
			
			int count = 0;
			
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					count++;
				}
			}
			
			if(count == 0) {
				sb.append(i).append(" ");
			} else if(count == 1) {
				sb.append("- ");
			} else {
				while(count-- > 0) {
					sb.append("-");					
				}
				sb.append(" ");
			}
		}
		System.out.println(sb);
		
		scan.close();
		sb = null;
	}
}
