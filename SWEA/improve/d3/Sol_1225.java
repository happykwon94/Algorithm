package com.ssafy.swea.improve.d3;

// 21.08.05 배열로 푸는게 오히려 더 빠를 것 같다, 문제를 이상하게 이해해서 시간이 더 오래 걸렸다.

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_1225 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = null;
		int[] numbers = new int[8];
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int t = 1; t <= 10; t++) {
			br.readLine();	// 테스트 케이스 번호 사용안함
			tokens = br.readLine().split(" ");
			
			int min = Integer.MAX_VALUE;
			
			// 사이클 당 같은 수가 감소함
			for(int i = 0; i < 8; i++) {
				numbers[i] = Integer.parseInt(tokens[i]);
				min = Math.min(min, numbers[i]);
			}
			
			// 공통으로 차감할 수 있는 최대 숫자 구하기
			int v = min / 15 * 15;
			
			// v == min이 같은 경우, -15한다
			if(v != 0 && v == min) {
				v -= 15;
			}
			
//			System.out.println(v);
			queue.clear();
			for(int i = 0; i < 8; i++) {
				queue.offer(numbers[i] - v);
			}
			
			
			int minus = 1, tmp = 0;
			while(true) {
				// 조건 맞춰서 후려친거라 싸이클 1번 안에 끝남
				tmp = queue.poll() - minus;
				if(tmp <= 0) {
					queue.offer(0);
					break;
				}
				queue.offer(tmp);
				
				minus = minus % 5 + 1;
				
			}
			
			System.out.println("#" + t + " ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}
}
