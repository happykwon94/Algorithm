package com.ssafy.swea.improve.d5;

import java.util.Scanner;

// 단순하게 순열로 만들 수 있는 경로를 다 만들고 길이를 재는 방식

public class _1247 {

	static int homeX, homeY, comX, comY;
	static int[][] customers;
	static boolean[] v;
	static int[] sel;
	static int N, ans, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			v = new boolean[N];
			sel = new int[N];

			comX = sc.nextInt();
			comY = sc.nextInt();

			homeX = sc.nextInt();
			homeY = sc.nextInt();

			customers = new int[N][2];

			for (int i = 0; i < N; i++) {
				customers[i][0] = sc.nextInt();
				customers[i][1] = sc.nextInt();
			}

			min = Integer.MAX_VALUE;

			dfs(0);

			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}

	static int distance(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}
	
	// 순열로 만들 수 있는 모든 경로를 구해서 최단 경로 탐색...
	static void dfs(int cnt) {
		if (cnt == N) {
			int sum = 0;
			sum += distance(customers[sel[0]][0], customers[sel[0]][1], comX, comY);
			for (int i = 0; i < N - 1; i++) {
				sum += distance(customers[sel[i]][0], customers[sel[i]][1], customers[sel[i + 1]][0],
						customers[sel[i + 1]][1]);
			}
			sum += distance(customers[sel[N - 1]][0], customers[sel[N - 1]][1], homeX, homeY);
			
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			
			v[i] = true;
			sel[cnt] = i;
			dfs(cnt + 1);
			v[i] = false;
		}
	}
}