package com.ssafy.pro.lv2;

import java.util.*;

// 22.01.04 Programmers

public class 오픈채팅방 {
	  public String[] solution(String[] record) {
	        String[] answer = {};
	        
	        HashMap<String, String> map = new HashMap<>();
	        Queue<String> messages = new LinkedList<String>();
	        
	        for(int i = 0; i < record.length; i++){
	            String[] input = record[i].split(" ");
	            
	            switch(input[0]){
	                case "Enter":
	                    map.put(input[1], input[2]);
	                    messages.offer(input[1] + "님이 들어왔습니다.");
	                    break;
	                case "Leave":
	                    messages.offer(input[1] + "님이 나갔습니다.");
	                    break;
	                case "Change":
	                    map.put(input[1], input[2]);
	                    break;
	            }
	        }
	        
	        answer = new String[messages.size()];
	        int i = 0;
	        
	        while(messages.size() != 0){
	            String current = messages.poll();
	            String id = current.split("님")[0];
	            
	            answer[i++] = map.get(id) + "님" + current.split("님")[1];
	        }
	        
	        return answer;
	    }
}
