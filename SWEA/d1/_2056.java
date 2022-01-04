package com.ssafy.swea.d1;

// 21.07.19

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2056 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int count = 1;
		
		while(T-- > 0) {
			String date = br.readLine();
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6, 8));
			
			
			if(dateVerify(month, day)) {
				sb.append("#").append(count++ +" ").append(date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6, 8) + "\n");
			} else {				
				sb.append("#").append(count++ +" ").append(-1 + "\n");
			}
			
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
	
	public static boolean dateVerify(int month, int day) {
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			if(day > 0 && day < 32)
				return true;
			return false;
		case 2:
			if(day > 0 && day < 29)
				return true;
			return false;
		case 4: case 6: case 9: case 11:
			if(day > 0 && day < 31)
				return true;
			return false;		
		default : 
			return false;
		}
	}
}
