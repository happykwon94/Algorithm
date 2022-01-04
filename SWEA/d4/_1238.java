package com.ssafy.swea.d4;

// 21.08.24 BFS / 참고 : https://hyewon-study-log.tistory.com/89

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1238 {
	
	static int cnt;
	static int MAX;
	static LinkedList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			list = new LinkedList[101];
			MAX = 0;
			cnt = 0;
			
			st = new StringTokenizer(br.readLine(), " ");

			for(int n = 0; n < N/2; n++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
			
				if(list[from] == null) {
					list[from] = new LinkedList<>();
					list[from].add(to);
				} else {
					if(list[from].contains(to))
						continue;
					list[from].add(to);
				}
			}
			
			bfs(start);
			
			System.out.println("#" + t + " " + MAX);
		}
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		int[] depth = new int[101];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int temp = 0; list[current] != null && temp < list[current].size(); temp++) {
				if(!visited[list[current].get(temp)]) {
					queue.offer(list[current].get(temp));
					depth[list[current].get(temp)] = depth[current] + 1;
					visited[list[current].get(temp)] = true;
				}
			}
		}
		
		cnt = depth[0];
		for(int i = 0; i < 101; i++) {
			if(depth[i] > cnt) {
				cnt = depth[i];
				MAX = i;
			} else if(depth[i] == cnt) {
				MAX = Math.max(MAX, i);
			}
		}
	}
}
