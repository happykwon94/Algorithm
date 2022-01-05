package com.ssafy.pro.lv1;

//22.01.05 Programmers

public class 숫자문자열과영단어 {
	 public static int solution(String s) {
	        int answer = 0;
	        String[] alphaes = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	        
	        for(int i = 0; i<10; i++){
	            if(s.contains(alphaes[i])) {
	            	s = s.replaceAll(alphaes[i], values[i]);
	            }
	        }
	        
	        answer = Integer.parseInt(s);
	        
	        return answer;
	    }
	public static void main(String[] args) {
//		String s = "one4seveneight";
		String s = "23four5six7";
//		String s = "2three45sixseven";
//		String s = "123";
		
		System.out.println(solution(s));
	}
}
