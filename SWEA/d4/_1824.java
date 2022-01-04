package com.ssafy.swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1824 {
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
	static class Point{
		int d, memory;

		public Point(int d, int memory) {
			super();
			this.d = d;
			this.memory = memory;
		}

		@Override
		public String toString() {
			return "(" + d + ", " + memory + ")";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + d;
			result = prime * result + memory;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (d != other.d)
				return false;
			if (memory != other.memory)
				return false;
			return true;
		}
		
	}
	
	private static char[][] map;
	private static HashMap<Pos, ArrayList<Point>> visited;
	private static int memory, R, C;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static boolean answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			visited = new HashMap<>();
			answer = false;
			
			memory = 0;
			
			for(int r = 0; r < R; r++) {
				char[] temp = br.readLine().toCharArray();
				for(int c = 0; c < C; c++) {
					map[r][c] = temp[c];
					visited.put(new Pos(r, c), new ArrayList<>());
				}
			}
						
			dfs(0, 0, 3);
			
			if(answer) {
				System.out.println("#" + t + " YES");
			} else {
				System.out.println("#" + t + " NO");
			}
			
		}
	}
	
	private static void dfs(int r, int c, int d) {
		// 좌표 검사
		if(map[r][c] == '@') {
			answer = true;
			return ;
		}
	
		// 현재 문자
		char current = map[r][c];
		
		if("^v<>".indexOf(current) != -1) {
			d = "^v<>".indexOf(current);
		}
		
		if(current == '_') {
			if(memory == 0)
				d = 3;
			else
				d = 2;
		}
		
		if(current == '|') {
			if(memory == 0)
				d = 1;
			else
				d = 0;
		}

		if(current == '+') {
			memory = ++memory%15;
		}
		
		if(current == '-') {
			if(memory == 0)
				memory = 15;
			else 
				memory--;
		}
		
		if(current >= '0' && current <= '9')
			memory = current - '0';
		
		if(current == '?') {
			for(int i = 0; i < 4; i++) {
				int nr = (R + r + dr[d]) % R;
				int nc = (C + c + dc[d]) % C;
				dfs(nr, nc, d);
				if(answer) {
					return;
				}
			}
		}
		
		Pos pos = new Pos(r, c);
		Point point = new Point(d, memory);
		ArrayList<Point> list = visited.get(pos);
		list.add(point);
		visited.put(pos, list);
		
		int nr = (R + r + dr[d]) % R;
		int nc = (C + c + dc[d]) % C;
		
		Pos temp = new Pos(nr, nc);

		dfs(nr, nc, d);
	}

	
}
