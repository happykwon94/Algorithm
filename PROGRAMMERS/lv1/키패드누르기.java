package com.ssafy.pro.lv1;

// 22.01.09 Programmers

public class 키패드누르기 {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for(int i = 0; i < numbers.length; i++){
            int current = numbers[i];
            
            if(current == 0)
                current = 11;
            
            if(current == 1 || current == 4 || current == 7){
                left = current;
                answer.append("L");
            } else if(current == 3  || current == 6 || current == 9){
                right = current;
                answer.append("R");
            } else {
                
                // current의 x 좌표, y 좌표는 1
                int currentX = current/3;
                
                // 각각의 번호를 좌표로 보고 거리를 계산, 왼쪽 줄과 오른쪽 줄은 고정된 좌표값이 존재함에 유의
                int leftAbs = Math.abs((left-1)/3 - currentX) + Math.abs((left-1)%3-1);
                int rightAbs = Math.abs((right-1)/3 - currentX) + Math.abs((right-1)%3-1);
                
                if(leftAbs == rightAbs){
                    if(hand.equals("right")){
                        right = current;
                        answer.append("R");
                    } else{
                        left = current;
                        answer.append("L");
                    }
                } else if(leftAbs < rightAbs){
                    left = current;
                    answer.append("L");                    
                } else {
                    right = current;
                    answer.append("R");                    
                }
            }
            
        }
    
        return answer.toString();
    }
    
    public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(solution(numbers, hand));
	}
}
