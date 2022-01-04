package com.ssafy.boj.improve.gold;

// 21.08.13 미리 치킨집과 집 사이의 거리를 구해서 저장해놓고 사용

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class _15686_another {
	
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chickens = new ArrayList<>();
	static int N, M, ans = (int)1e9;	// ans에 10억 넣었음 최댓값 정해져있어서 그거보다 크게 씀
	static int[] sel;
	static int[][] dist; // 치킨집과 거리 저장할 배열
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br =  new BufferedReader(new StringReader("5 2\r\n" + 
				"0 2 0 1 0\r\n" + 
				"1 0 1 0 0\r\n" + 
				"0 0 0 0 0\r\n" + 
				"2 0 0 1 1\r\n" + 
				"2 2 0 1 2"));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		
		for(int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int V = Integer.parseInt(data[j]);
				
				// 집
				if(V == 1)
					// 행과 열의 좌표값 입력
					home.add(new int[] {i, j});
				// 치킨집
				else if(V == 2)
					 chickens.add(new int[] {i, j});
			}
		}
		
		// 치킨집과 집의 거리를 저장하자...
		// 13 : 치킨집 최댓값 / 100 : 집 최댓값
		dist = new int[13][100];
		for(int i = 0; i < chickens.size(); i++) {
			for(int j = 0; j < home.size(); j++) {
				// i번 째 치킨집, j번째 집 거리를 저장
				dist[i][j] = calcDist(chickens.get(i), home.get(j));
			}
		}
		
		// 조합 처리
		sel = new int[M];	// 살릴 치킨집 M개만 고를거니까
		comb(0, 0);
		System.out.println(ans);
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			// 도시의 치킨거리 구하기
			int cityDist = 0;
			for(int i = 0; i < home.size(); i++) {
				int homeDist = (int)1e9; // 집에서의 치킨 거리
				// sel에 몇번째 치킨집인지 위치가 저장되어 있음
				for(int j = 0; j < M; j++) {
					homeDist = Math.min(homeDist, dist[sel[j]][i]);
				}
				cityDist += homeDist;
			}
			
			ans = Math.min(ans, cityDist);
			
			return;
		}
		
		// 뽑아야할 배열만큼 순회
		for(int i = start; i < chickens.size(); i++) {
			// sel에 몇 번째 치킨집인지 저장
			sel[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	static int calcDist(int[] loc1, int[] loc2) {
		return Math.abs(loc1[0] - loc2[0]) + Math.abs(loc1[1] - loc2[1]);
	}
}
