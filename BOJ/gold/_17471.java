package com.ssafy.boj.gold;


/** 
 * 	부분집합 + 완전탐색(유효한지 판단)
 * 
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17471 {
	
	private static int N, answer, max, popul[], adjList[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		popul = new int[N];
		adjList = new int[N][];
		max = 0;
		answer = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < N; n++) {
			popul[n] = Integer.parseInt(st.nextToken());
			max += popul[n];
		}
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			if(t == 0)
				continue;
			
			adjList[n] = new int[t];
			for(int m = 0; m < t; m++) {
				adjList[n][m] = Integer.parseInt(st.nextToken())-1;
			}
		}
				
		subSet(0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
		
		System.out.println(answer);
		
	}

	private static void subSet(int cnt, int sum, List<Integer> arr1, List<Integer> arr2) {
		if(cnt == N){
			if(arr1.size() == 0 || arr2.size() == 0) {
				return;
			}
			
			if(bfs(arr1, arr1.size()) && bfs(arr2, arr2.size())) {
				int A = count(arr1);
				int B = count(arr2);
				answer = Math.min(answer, Math.abs(A-B));
			}
			return;
		}
		
		arr1.add(cnt);
		if(arr2.contains(cnt))
			arr2.remove(Integer.valueOf(cnt));
		subSet(cnt+1, sum + popul[cnt], arr1, arr2);
		
		if(arr1.contains(cnt))
			arr1.remove(Integer.valueOf(cnt));
		arr2.add(cnt);
		subSet(cnt+1, sum, arr1, arr2);
	}

	private static int count(List<Integer> arr1) {
		int sum = 0;
		for(int i : arr1) {
			sum += popul[i];
		}
		return sum;
	}

	private static boolean bfs(List<Integer> list, int size) {
		
		if(size == 0)
			return false;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(list.get(0));
		visited[list.get(0)] = true;
		size--;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int c = 0; c < adjList[current].length; c++) {
				if(!visited[adjList[current][c]] && list.contains(adjList[current][c])) {
					visited[adjList[current][c]] = true;
					size--;
					queue.offer(adjList[current][c]);
				}
			}
		}
		
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
}
