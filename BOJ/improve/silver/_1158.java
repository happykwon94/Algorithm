package com.ssafy.boj.improve.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] data = br.readLine().split(" ");
		
		int N = Integer.parseInt(data[0]);
		int K = Integer.parseInt(data[1]) - 1;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int idx = 0;
		
		sb.append("<");
		while(list.size() > 1) {
			idx = (idx + K) % list.size();
			sb.append(list.remove(idx) + ", ");	// 규칙에 따라서 idx로 접근해 list를 줄여가면서 접근
		}
		
		sb.append(list.remove(0) + ">");
		
		System.out.println(sb);
		
		br.close();
	}
}
