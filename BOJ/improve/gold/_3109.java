/*
 * 1. 파이프를 놓는 순서
 * 		-	첫파이프를 놓는 위치에 따라 두,세번째 파이프 위치가 영향을 받는다.
 * 		- 	가장 윗행 시작
 * 2. 수행 횟수
 * 		- 한행 첫열 시도 3^500 * 10000 (중간건물, 기존 파이프라인 시간 줄여주기는 한다)
 * 		- 가지치기
 * 		  : 파이프 놓기에 성공했다면 시작열(처음으로 계속 리턴), 단 성공한 방식이 최선이라고 판단이 되어야 한다.
 * 		  : 이전 파이프 놓기에 실패한 흔적 남겨둔다. 만약, 지우면 실패했던 자리에서 또 똑같이 진행해야 해서 문제 생김
 *    
 */
package com.ssafy.boj.improve.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3109 {

	static int R, C, ans = 0;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];

		for (int i = 0; i < R; ++i) {
			map[i] = in.readLine().toCharArray();
		}
		makePipe();
		System.out.println(ans);
	}

	private static void makePipe() {
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}
	
	// 위의 행부터 출발한다면 모든 동선을 위쪽으로 붙이는 위부터 보는 방식이 최선의 방식이 된다.
	static int[] dr = { -1, 0, 1 };

	private static boolean dfs(int r, int c) {
		if (c == C - 1) {	// 마지막 열에 왔다면 성공.. 
			ans++;
			// 성공했다면 현재 위의 행부터 탐색하여 끝까지 파이프를 놓은 최선의 경우이므로 밑을 행을 탐색할 필요가 없다.
			// 하나가 성공하면 같은 루트를 밟을 수 없다.
			return true;
		}
		int nr, nc = c + 1;  // 열은 바로 옆열로 이동하므로 기존 열 + 1
		for (int d = 0; d < 3; ++d) {
			nr = r + dr[d];
			// 열에 대한 체크는 불필요 ?? 기저 조건에서 체크함
			// 방문한 흔적이 있는 경우 안간다. - 파이프가 있거나 먼저 진행했던 위치에서 안되었다
			if (nr < 0 || nr >= R || visited[nr][nc] || map[nr][nc] == 'x')
				continue;

			visited[nr][nc] = true;
			if (dfs(nr, nc)) {
				// 전진했다면 다른 방향을 더 볼 필요가 없다. 성공했다면 그대로 경로 고정, 실패했다면 다시 가도 실패할 경로인 것
				return true;
			}
			
			// 뒤에나온 선택지의 방향은 현재보다 유리하지 않은 상황이다. 따라서 같은 상황이 되풀이된다.
			// 이거하면 실패했던 위치에서 다시 또 해본다. 주의...
//			visited[nr][nc] = false;  
		}
		return false;	// 세방향 모두 갈수 있는 경우 없었음, 이전 재귀로 돌아가서 다른 방향으로 탐색한다.
	}
}
