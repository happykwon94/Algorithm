package com.ssafy.pro.lv1;

// 22.01.19 Programmers 2019 KAKAO BLIND RECRUITMENT

import java.util.Arrays;

public class 실패율 {
    static class Entry implements Comparable<Entry> {
        int round;
        double failRate;
        
        public Entry(int round, double failRate){
            this.round = round;
            this.failRate = failRate;
        }

		@Override
		public int compareTo(Entry o) {
			if(this.failRate == o.failRate) {
				return this.round - o.round;
			}
			return (this.failRate - o.failRate) < 0 ? 1 : -1;
		}
    }
    
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
                
        // 스테이지 진출자
        int[] stage = new int[N+2];
        
        // 아직 클리어하지 못한 사람 수
        int[] challenger = new int[N+2];
        
        for(int i = 0; i < stages.length; i++){
            for(int j = 1; j <= stages[i]; j++){
                stage[j]++;
            }
            
            challenger[stages[i]]++;
        }
        
        Entry[] list = new Entry[N];
        int pos = 0;
        
        for(int i = 1; i < N+1; i++) {
        	// 스테이지에 도달한 인원이 없을 수 있으므로 예외 처리
            if( challenger[i] == 0 || stage[i] == 0){
                list[pos++] = new Entry(i, 0);
                continue;
            }
            
        	list[pos++] = new Entry(i, (double)challenger[i]/stage[i]);
        }
        
        Arrays.sort(list);
        
        for(int i = 0; i < N; i++) {
        	answer[i] = list[i].round;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		System.out.println(Arrays.toString(solution(N, stages)));
	}
		
}
