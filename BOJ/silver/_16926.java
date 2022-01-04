package com.ssafy.boj.silver;

// 21.08.11 애매모호 설명 다듣고 풀었다. 그냥 하나씩하나씩 다 돌렸다. 뭔가 규칙이 있을 거 같았는데...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16926 {
	
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int R;
	static int N;
	static int M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1씩 회전시킬건데 몇 번씩 반복하냐 => 회전횟수
		for(int r = 0; r < R; r++) {			
			rotate();
		}
		
		// 이차원 배열 출력
		for (int r = 0; r < N; r++) {			 
			for (int c = 0; c < M; c++) {
				System.out.print(arr[r][c] + " "); 
			}
			System.out.println();
		}
		
		br.close();
	}
	
	private static void rotate() {
		// 안쪽 가장 작은 사각형의 시작 좌표 계산
		int minPos = Math.min(N, M) / 2;
		// 가장 큰 사각형부터 시작
		for(int cnt = 0; cnt < minPos; cnt++) {
			
			// 시작값이 지워지므로 기억해야함
			int temp = arr[cnt][cnt];
			
			// 출발점 좌표
			int r = cnt;
			int c = cnt;
			
			// 시계방향으로 탐색하면서 회전시킴
			for(int idx = 0; idx < 4; idx++) {
				// 바깥으로 튀어나가거나 안쪽 사각형 영역을 침범하면 정지
				while(true) {
					int nr = r + dx[idx];
					int nc = c + dy[idx];
					
					if(nr < cnt || nr >= N - cnt || nc < cnt || nc >= M - cnt) {
						break;
					}
					
					// 이동한 좌표의 값 이전 값에다 덮어쓰기
					arr[r][c] = arr[nr][nc];
					
					r = nr;
					c = nc;
				}
			}
			// 위의 과정이 수행되면 arr[1][0]의 자리에  한 칸 회전하여
			// arr[0][1]에서 arr[0][0]에 있던 값이 복사되므로 기억했던 temp의 값을 다시 삽입
			arr[cnt+1][cnt] = temp;
		}
		
	}

}
