package com.ssafy.pro.lv1;

public class 부족한금액계산하기 {
	  public static long solution(int price, int money, int count) {
	        long answer = money;
	        long total = 0;
	                    
	        for(int i = 1; i <= count; i++){
	            total += price*i;
	        }
	        
	        if(total - answer > 0)
	            return (total - answer);
	        else
	            return 0;
	    }
	  
	  public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		
		System.out.println(solution(price, money, count));
	}
}
