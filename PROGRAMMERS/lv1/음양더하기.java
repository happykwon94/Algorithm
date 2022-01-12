package com.ssafy.pro.lv1;

//22.01.12 Programmers

public class 음양더하기 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = signs.length;
        
        for(int i = 0; i < len; i++){
            if(signs[i])
                answer += absolutes[i];
            else 
                answer -= absolutes[i];
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		
		System.out.println(solution(absolutes, signs));
	}
}
