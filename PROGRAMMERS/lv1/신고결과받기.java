package com.ssafy.pro.lv1;
import java.util.*;

// 22.01.15 Programmers <2022 KAKAO BLIND>

public class 신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, LinkedList<String>> decl = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            decl.put(id_list[i], new LinkedList<String>());
            result.put(id_list[i], 0);
        }
        
        // <신고당한 사람, 신고한 사람 배열>
        for(int i = 0; i < report.length; i++){
            String[] data = report[i].split(" ");

            if(decl.containsKey(data[1])){
                // Map에서 꺼내서 추가한 후 다시 저장
            	LinkedList<String> temp = decl.get(data[1]);
            	if(temp.contains(data[0]))
            		continue;
            	temp.add(data[0]);
                decl.put(data[1], temp);
            }
        }
        
        for(int i = 0; i < id_list.length; i++){
        		
            int cnt = decl.get(id_list[i]).size();
            
            if(cnt < k)
            	continue;
            
            LinkedList<String> temp = decl.get(id_list[i]);
            while(temp.size() != 0) {
            	String target = temp.poll();
            	result.put(target, result.get(target) + 1);
            }
        }
        
        for(int i = 0; i < id_list.length; i++){
            answer[i] = result.get(id_list[i]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		for(int x : solution(id_list, report, k)) {
			System.out.println(x);
		}
	}
}
