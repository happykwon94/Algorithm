package com.ssafy.swea.d3;

// 21.08.09 재귀를 사용해서 풀기는 했다. 조합문제, 실행시간이 너무 길다. 줄여볼 것(배열 여러개 쓰지 말고 합과 만족도를 매개변수로 전달)
// 조합 뽑는거 매일 치고 잠들기...
// improve에서 DP로 해결

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5215 {
	
	static int N = 0;
	static int L = 0;
	static int[][] arr;
	static boolean select[];
	static int MAX;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			arr = new int[N][2];
			select = new boolean[N];
			MAX = 0;
			
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			combination(0, 0 ,0);
			
			System.out.println("#" + t + " " + MAX);	
		}
        
        br.close();
	}
	
	private static void combination(int cnt, int sum, int max) {
		if(cnt == N) {
			if(sum <= L) {
				MAX = (max < MAX) ? MAX : max;
			}
			return ;
		}
		
		// 선택한 경우, 합과 만족도에 더 해줌
		select[cnt] = true;
		combination(cnt+1, sum + arr[cnt][1], max + arr[cnt][0]);
		
		// 선택하지 않은 경우, 합과 만족도에 더하지 않음
		select[cnt] = false;
		combination(cnt+1, sum, max);		
	}
	
}
