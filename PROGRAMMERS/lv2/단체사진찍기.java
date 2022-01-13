package com.ssafy.pro.lv2;

// 22.01.13 Programmers

public class 단체사진찍기 {
    
    static String[] selected;
    static boolean[] visited;
    static String[] rules;
    static int result;
    
    public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		
		System.out.println(solution(n, data));
	}
    
    public static int solution(int n, String[] data) {
        int answer = 0;
        
        result = 0;
        rules = data;
        selected = new String[8];
        visited = new boolean[8];
        
        permutation(0, new String[]{"A", "C", "F", "J", "M", "N", "R", "T"});
        
        answer = result;
        
        return answer;
    }
    
    public static void permutation(int cnt, String[] data){
        if(cnt == 8){            
            for(int d = 0; d < rules.length; d++){
                String op1 = rules[d].substring(0, 1);
                String op2 = rules[d].substring(2, 3);
                String operator = rules[d].substring(3, 4);
                int dist = Integer.parseInt(rules[d].substring(4, 5));
                
                int idx1 = -1;
                int idx2 = -1;
                
                for(int i = 0; i < 8; i++){
                    if(selected[i].equals(op1))
                        idx1 = i;
                    
                    if(selected[i].equals(op2))
                        idx2 = i;
                    
                    if(idx1 != -1 && idx2 != -1)
                        break;
                }
                
                int temp = Math.abs(idx2-idx1) - 1;
                
                switch(operator){
                    case "<":
                        if(temp >= dist)
                            return;
                        break;
                    case ">":
                        if(temp <= dist)
                            return;
                        break;
                    case "=":
                        if(temp != dist)
                            return;
                        break;
                }
            }
            result++;
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(visited[i])
                continue;
            
            selected[cnt] = data[i];
            visited[i] = true;
            
            permutation(cnt+1, data);
            visited[i] = false;
        }
    }
}
