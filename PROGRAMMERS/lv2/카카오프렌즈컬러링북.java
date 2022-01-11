package com.ssafy.pro.lv2;

// 22.01.11 Programmers

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public static void main(String[] args) {
//		int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		int[] answer= solution(6, 4, picture);
		System.out.println(Arrays.toString(answer));
    }
    
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
            	// 0은 채우지 않는 지점
            	// 한 번 방문했던 지점에 대해서는 BFS로 모두 탐색하므로 방문하지 않은 지점은 새로운 Area
            	if(picture[r][c] != 0 && !visited[r][c]) {
            		numberOfArea++;
            		int max = search(m, n, r, c, picture);
            		maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);            		
            	}
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    private static int search(int m, int n, int r, int c, int[][] picture) {
    	int area = 1;	// 시작점 영역
    	
    	Queue<int[]> queue = new LinkedList<int[]>();
    	queue.offer(new int[] {r, c});
    	visited[r][c] = true;	// 시작점 방문 확인
    	int current = picture[r][c]; // 시작지점의 값
    	
    	while(queue.size() != 0) {	// BFS 탐색
    		int[] currentPos = queue.poll();
    		
    		for(int d = 0; d < 4; d++) {
    			int nr = currentPos[0] + dr[d];
    			int nc = currentPos[1] + dc[d];
    			
    			// 방문 체크 && 범위 체크
    			if(nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
    				continue;
    			
    			// 인접한 영역이면 색칠
    			if(picture[nr][nc] == current) {
    				area++;
    				visited[nr][nc] = true;
    				queue.offer(new int[] {nr, nc});
    			}
    		}
    	}
    	
    	return area;
	}

}
