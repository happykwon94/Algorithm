package com.ssafy.swea.d3;

// 21.08.02

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1289{
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 해결해야할 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());
		int count = 1;
		
		while(T-- > 0) {
			//	테스트 케이스의 처음부터 탐색해가면서 현재의 init 값과 값이 달라지면 현재 위치에서 수정이 발생하므로
			//	result에 +1을 해주고 현재의 init 값을 바꿔준다.
			
			char init = '0';
			String testCase = br.readLine();
			int result = 0;
			
			// 개선 의견 -> 초기 init을 만들지 말고 이전 값과 비교하자!
			for(int i = 0; i<testCase.length(); i++) {
				if(testCase.charAt(i) != init) {
					result++;
					if(init == '0') {
						init = '1';
					} else {
						init = '0';
					}
				}
			}
			sb.append("#").append(count++).append(" " + result + "\n");
		}
		
		System.out.println(sb);
		
		br.close();
		sb = null;
	}
	
}
