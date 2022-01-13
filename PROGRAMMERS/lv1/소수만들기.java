package com.ssafy.pro.lv1;

// 22.01.14 Programmers 에라토스테네스의 체, 조합

public class 소수만들기 {
    
    static boolean[] check;
    static int selected[];
    static int[] temp;
    static int result;
    
    public static int solution(int[] nums) {
        result = 0;
        temp = nums;
        selected = new int[3];
        check = new boolean[2998];
        check[0] = check[1] = true;
        
        for(int i = 2; i < 2998; i++){
            if(!check[i]){
            	for(int j = i*i; j < 2998; j += i) 
                    check[j] = true;                
            }   
        }
        
        comb(0, 0);
        
        int answer = result;
        
        return answer;
    }
    
    public static void comb(int cnt, int start){
        if(cnt == 3){
            int sum = 0;
            for(int x : selected){
                sum += x;
            }
            
            if(!check[sum])
                result++;
                
            return;
        }
        
        for(int i = start; i < temp.length; i++){
            selected[cnt] = temp[i];
            comb(cnt+1, i+1);
        }
    }
    
    public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(solution(nums));
	}
}
