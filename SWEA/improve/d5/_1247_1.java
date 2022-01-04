/**
 * 집의 각 거리를 메모리에 저장하고 재사용
 */
package com.ssafy.swea.improve.d5;

import java.util.Scanner;

public class _1247_1 {

	static int[][] data, D;
	static boolean[] v;
	static int[] sel;
	static int N, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();

			// 선택되어지는 인덱스가 1부터 시작해야 한다.(0번째를 회사 사용하므로)
			v = new boolean[N + 1];
			sel = new int[N];
			
			// 회사와 집을 추가해서 처리 : N + 2가 됨
			data = new int[N + 2][2];
			
			// 회사
			data[0][0] = sc.nextInt();
			data[0][1] = sc.nextInt();
			
			// 집
			data[N + 1][0] = sc.nextInt();
			data[N + 1][1] = sc.nextInt();

			// 
			for (int i = 1; i <= N; i++) {
				data[i][0] = sc.nextInt();
				data[i][1] = sc.nextInt();
			}

			D = new int[N + 2][N + 2];	
			for (int i = 0; i < N + 1; i++)
				for (int j = i + 1; j < N + 2; j++)
					D[i][j] = D[j][i] = distance(data[i][0], data[i][1], data[j][0], data[j][1]);

			ans = Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}

	static int distance(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}

	static void dfs(int cnt) {
		
		if (cnt == N) {
			// 회사부터 선택한 경로, 집까지의 최소값
			int sum = D[0][sel[0]];
			for (int i = 0; i < N - 1; i++) {
				sum += D[sel[i]][sel[i + 1]];
			}
			sum += D[sel[N - 1]][N + 1];
			ans = Math.min(ans, sum);
			return;
		}

		// 위치를 1부터 시작하게 한다.(0번째는 회사이므로..)
		for (int i = 1; i <= N; i++) {
			if (v[i]) continue;
			
			v[i] = true;
			sel[cnt] = i;
			dfs(cnt + 1);
			v[i] = false;
		}
	}
}