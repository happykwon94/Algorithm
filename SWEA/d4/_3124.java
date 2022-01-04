package com.ssafy.swea.d4;

// 21.09.16

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3124 {
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			long weight = 0;
			for(Edge e : edgeList) {
				if(union(e.start, e.end)) {
					cnt++;
					weight += e.weight;
					
					if(cnt == V-1) {
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + weight);
			
		}
	}
	
	private static void make() {
		parents = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a])
			return a;
		
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) {
			return false;
		}
		
		parents[rootB] = rootA;			
		return true;
	}
	
}
