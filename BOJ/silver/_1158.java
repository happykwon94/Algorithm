package com.ssafy.boj.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1158 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
				
		sb.append("<");
		while(queue.size() != 1) {
			
			for(int i = 0; i < K-1; i++) {
				queue.offer(queue.poll());
			}
			
			sb.append(queue.poll()+", ");
		}
		
		sb.append(queue.poll() + ">");
		
		System.out.println(sb);
		
		scan.close();
	}
}
