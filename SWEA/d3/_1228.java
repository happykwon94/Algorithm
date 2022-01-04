package com.ssafy.swea.d3;

// 21.08.09 LinkedList 활용 문제, 다양한 메소드 활용, 매 동작이 끝난후 LinkedList 비우는 작업 신경쓸 것

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1228 {
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input/_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		LinkedList<Integer> enc = new LinkedList<>();
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			
			enc.clear();
			
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < N; i++) {
				enc.addLast(Integer.parseInt(st.nextToken()));
			}
			
			int command = Integer.parseInt(br.readLine());
			
			String[] commandArray = br.readLine().split("I ");
			
			for(int c = 1; c <= command; c++) {
				st = new StringTokenizer(commandArray[c], " ");
				
				int pos = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				
				if(pos > 10) {
					continue;
				}
				
				for(int n = 0; n < num; n++) {
					enc.add(pos++, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + t);
			for(int i = 0; i < 10; i++) {
				System.out.print(" " + enc.pollFirst());
			}
			System.out.println();
		}
		
		br.close();
		st = null;
	}
}
