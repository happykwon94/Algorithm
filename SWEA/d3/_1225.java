package com.ssafy.swea.d3;

// 21.08.05 배열로 푸는게 오히려 더 빠를 것 같다, 문제를 이상하게 이해해서 시간이 더 오래 걸렸다.

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1225 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input/_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		String str = br.readLine();
		
		while(str != null) {
			int t = Integer.parseInt(str);
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 초기 세팅
			while(st.hasMoreTokens()) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int key = 1;
			int target = -1;
			
			while(true) {
				if(key > 5)
					key %= 5;
				
				target = queue.poll();
				
				target -= key++;
				
				if(target <= 0) {
					queue.offer(0);
					break;
				}
				
				queue.offer(target);
			}
			
			sb.append("#").append(t).append(" ");
			
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
		
			sb.append("\n");
			str = br.readLine();
		}
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
}
