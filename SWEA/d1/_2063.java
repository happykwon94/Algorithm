package com.ssafy.swea.d1;

// 21.07.19

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _2063 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numsCount = (Integer.parseInt(scan.nextLine()));
		int[] numsArr = new int[numsCount];
		
		String[] nums = scan.nextLine().split(" ");
		
		for(int i = 0; i < numsCount; i++) {
			numsArr[i] = Integer.parseInt(nums[i]);
		}
		
		Arrays.sort(numsArr);
		
		System.out.println(numsArr[numsCount/2]);

		scan.close();
		numsArr = null;
		nums = null;
	}
}
