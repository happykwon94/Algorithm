package com.ssafy.boj.improve.gold;

import java.util.*;

public class _17471 {
	static int N; // 구역의 갯수
	static int[] peopleCnt; // 인구수(구역별)
	static int[][] adj; // 구역별 인접구역
	static boolean[] sel; // 2개의 선거구로 나누기

	public static void main(String[] args) {
		Scanner sc = new Scanner(
				"6\n" + 
				"5 2 3 4 1 2\n" + 
				"2 2 4\n" + 
				"4 1 3 6 5\n" + 
				"2 4 2\n" + 
				"2 1 3\n" + 
				"1 2\n" + 
				"1 2");
		N = sc.nextInt();
		peopleCnt = new int[N + 1];
		sel = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			peopleCnt[i] = sc.nextInt();
		}
		adj = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int dest = sc.nextInt();
				adj[i][dest] = 1;
			}
		}
		sc.close();

		powetSet(1);
		System.out.println(ans == 987654321 ? -1 : ans);
	}

	static int ans = 987654321;

	// 부분 집합
	static void powetSet(int idx) {
		if (idx == N + 1) {
			System.out.println("sel -> " + Arrays.toString(sel));
			if (check()) {
				int sumA = 0;
				int sumB = 0;
				for (int i = 1; i <= N; i++) {
					if (sel[i]) sumA += peopleCnt[i];
					else        sumB += peopleCnt[i];
				}
				ans = Math.min(ans, Math.abs(sumA - sumB));
			}
			return;
		}
		sel[idx] = true;
		powetSet(idx + 1);
		sel[idx] = false;
		powetSet(idx + 1);
	}

	// 선택된 선거구의 구분된 구역들이 서로 인접한 영역인지 체크
	static boolean check() {
		int areaA = 0;
		int areaB = 0;
		for (int i = N; i >= 1; i--) {
			if (sel[i]) areaA = i;
			else        areaB = i;
		}
		if (areaA == 0 || areaB == 0) return false;

		boolean[] visited = new boolean[N + 1];
		setVisit(areaA, visited, true); // a지역 체크
		setVisit(areaB, visited, false); // b지역 체크
		System.out.println("visited -> " + Arrays.toString(visited));
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static void setVisit(int area, boolean[] visited, boolean areaType) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(area);
		visited[area] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (sel[i] == areaType && adj[node][i] != 0 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}