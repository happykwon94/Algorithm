package com.ssafy.boj.improve.gold;

// 21.08.13 기존 방식에서 입력 받는 코드의 양을 줄인 것

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {
	
	static int N;
	static int M;
	static int MIN;
	static List<Position> selected;
	static List<Position> chickens;
	static List<Position> homes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		MIN = Integer.MAX_VALUE;
		
		selected = new ArrayList<Position>();
		chickens =new ArrayList<Position>();
		homes = new ArrayList<Position>();
		
		int pos = 0;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				pos = Integer.parseInt(st.nextToken());
				if(pos == 1)
					homes.add(new Position(r, c));
				if(pos == 2)
					chickens.add(new Position(r, c));
			}
		}
		
		combination(0, 0);
		
		System.out.println(MIN);
		
		br.close();
	}
	
	private static void combination(int cnt, int start) {
		// 살아남은 치킨집 선택
		if(cnt == M) {
			// dis : 전체 치킨거리 / cd : 그 집에서의 최소 치킨거리
			int dis = 0;
			for(int h = 0; h < homes.size(); h++) {
				int cd = Integer.MAX_VALUE;
				for(int c = 0; c < M; c++) {
					cd = Math.min(cd, Math.abs(selected.get(c).x - homes.get(h).x)
							+ Math.abs(selected.get(c).y - homes.get(h).y));
				}
				dis += cd;
			}
			
			MIN = Math.min(MIN, dis);
			
			return ;
		}
		
		for(int i = start; i < chickens.size(); i++) {
			selected.add(chickens.get(i));
			combination(cnt+1, i+1);
			selected.remove(selected.size()-1);
		}
	}
}

class Position{
	int x;
	int y;
	
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}