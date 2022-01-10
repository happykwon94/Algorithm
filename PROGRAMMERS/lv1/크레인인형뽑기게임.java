package com.ssafy.pro.lv1;

// 22.01.10 Programmers

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> st = new Stack<Integer>();
        
        for(int m = 0; m < moves.length; m++){
            int c = moves[m]-1;
            for(int r = 0; r < board.length; r++){
                if(board[r][c] == 0)
                    continue;
                
                // 인형을 만났을 때, 빈 바구니
                if(st.isEmpty()){
                    st.push(board[r][c]);
                    board[r][c] = 0;
                    break;
                } else if(!st.isEmpty() && st.peek() != board[r][c]){
                    st.push(board[r][c]);
                    board[r][c] = 0;
                    break;
                } else {
                    answer += 2;
                    st.pop();
                    board[r][c] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}
}
