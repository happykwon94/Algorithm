package com.ssafy.swea.competency;

// 21.08.18 조합에 대한 이해가 더 필요함, 외워서 쓰는거 외에...

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4012 {
	
	static int MIN;
	static int N;
	
	static int[][] synergy;
	static boolean[] selected;
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			MIN = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			
			synergy = new int[N][N];
			selected = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0, 0);
			
			System.out.println("#" + t + " "+ MIN);
		}
	}
	
	private static void comb(int cnt, int start) {
		if(start == N)
			return; // 0,1을  뽑아서 2,3이랑 돌리나 2,3을 뽑아서 0,1이랑 돌리나 똑같으므로 start가 3, 끝에 도달한 순간 리턴
		
		if(cnt == N/2) {
			int taste1 = 0;
			int taste2 = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					if(selected[i] && selected[j]) {
						taste1 += synergy[i][j] + synergy[j][i];
					} else if(!selected[i] && !selected[j]) {
						taste2 += synergy[i][j] + synergy[j][i];						
					}
				}
			}
			
			MIN = MIN > Math.abs(taste1 - taste2) ? Math.abs(taste1-taste2) : MIN;
			
			return ;
		}
		
		for(int i = start; i < N; i++) {
			selected[i] = true;
			comb(cnt+1, i+1);
			selected[i] = false;
		}
	}
	
	
}
