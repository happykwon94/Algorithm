package com.ssafy.pro.lv1;

// 22.03.05 Programmers 연습문제

public class 문자열내p와y의개수 {
    public static boolean solution(String s){
        int pCnt = 0;
        int yCnt = 0;

        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p')
                pCnt++;
            else if(s.charAt(i) == 'y')
                yCnt++;
        }

        if(pCnt == 0 && yCnt == 0)
            return true;
        else{
            return pCnt == yCnt;
        }
    }

    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }
}
