package com.ssafy.swea.d4;

// 21.08.05 생각을 너무 이상하게 했다. 문제 그대로 받아들이고 풀 것

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1218 {
	static Stack<Character> input;
	
	public static void main(String[] args) throws Exception {		
		System.setIn(new FileInputStream("input/_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int result = -1;
			input = new Stack<>();
			
			for(int i = 0; i < N; i++) {
				
				char item = str.charAt(i);
				// 짝을 찾을 때까지 꺼냄
				switch(item) {
				case ')':
					matching('(');
					break;
				case '}':
					matching('{');
					break;
				case ']':
					matching('[');
					break;
				case '>':
					matching('<');
					break;
				default:
					input.push(item);
					break;
				}
			}
			
			if(input.isEmpty()) {
				result = 1;
			} else if(!input.isEmpty()) {
				result = 0;
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);

		br.close();
		sb = null;
	}
	
	private static void matching(char c) {
		
		if(!input.isEmpty() && input.peek() == c) {
			input.pop();
		}
		else {
			input.push(c);
		}
		
	}
}
