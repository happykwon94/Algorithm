package com.ssafy.swea.d4;

// 21.08.29 BOJ 10799랑 같은 문제

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _5432 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int answer = 0;
			
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			char prev = ' ';
			
			for(int i = 0; i < str.length(); i++) {
				char target = str.charAt(i);
				
				if(target == '(') {
					prev = target;
					stack.push(target);
				} else {	// 닫는게 왔을 때
					if(prev == '(') {
						stack.pop();
						answer += stack.size();
					} else {
						stack.pop();
						answer += 1;
					}
					
					prev = ')';
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
