package com.ssafy.pro.lv3;

// 21.01.06 Programmers

public class 추석트래픽 {
    public static int solution(String[] lines) {
        int answer = 0;
        int len = lines.length;
        
        // 응답 시간
        int[] sTimes = new int[len];
        
        // 처리 시간
        int[] tTimes = new int[len];
        
        
        for(int i = 0; i < len; i++){
            // 응답 완료 시간
            String S = lines[i].split(" ")[1].replaceAll(":", "");
            
            // 처리시간 구하기
            String T = lines[i].split(" ")[2].split("s")[0];
            
            int hh = Integer.parseInt(S.substring(0, 2));
            int mm = Integer.parseInt(S.substring(2, 4));
            int ss = Integer.parseInt(S.substring(4, 6));
            int _ss = Integer.parseInt(S.substring(7));
            
            // 소숫점 아래 세번째 자리가 1이 되도록 전체 초로 계산
            sTimes[i] = (((hh*60*60) + (mm*60) + ss) * 1000) + _ss;
            tTimes[i] = (int)(Double.parseDouble(T)*1000.0); 
        }
        
        for(int i = 0; i < len; i++) {
        	// 처리시간은 시작 시간과 끝 시간을 포함하도록 계산
        	int endTime = sTimes[i] + 1000 - 1;
        	int cnt = 1;
        	for(int j = i+1; j < len; j++) {
            	// 처리시간은 시작 시간과 끝 시간을 포함하도록 계산
        		int targetStartTime = sTimes[j] - tTimes[j] + 1;
        		if(targetStartTime <= endTime)
        			cnt++;
        	}
        	
        	answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		
		System.out.println(solution(lines));
	}
}
