package com.ssafy.swea.d4;

// 21.08.20	

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1223 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/_1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			System.out.println("#" + t + " " + calPostFix(makePostFix(str, len), len));
		}
		
		br.close();
	}
	
	private static String makePostFix(String str, int len) {
		StringBuilder postFix = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for(int i = 0; i < len; i++) {
			
			char c = str.charAt(i);
			
			if(c == '*') {
				while(!stack.isEmpty() && stack.peek() == '*') {
					postFix.append(stack.pop());
				}
				stack.add(c);
				
			} else if(c == '+') {
				while(!stack.isEmpty()) {
					postFix.append(stack.pop());
				}
				stack.add(c);
			} else {
				postFix.append(c);
			}
		}
		
		while(!stack.isEmpty()) {
			postFix.append(stack.pop());
		}
		
		return postFix.toString();
	}
	
	private static int calPostFix(String str, int len) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < len; i++) {
			
			char c = str.charAt(i);
			
			if(c == '*') {
				int op1 = stack.pop();
				int op2 = stack.pop();

				stack.add(op2 * op1);

			} else if(c == '+') {
				int op1 = stack.pop();
				int op2 = stack.pop();
				
				stack.add(op2 + op1);
				
			} else {
				stack.add(c-'0');
			}
		}
		
		return stack.pop();
	}
}
