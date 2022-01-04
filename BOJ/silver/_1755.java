package com.ssafy.boj.silver;

// 21.09.27

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1755 {
	/** 
	 * 	주어진 데이터를 읽은 값과 실제 값을 담을 자료형 Data
	 * 	읽었을 때를 기준으로 정렬하기 위해 Comparable을 상속받음
	 * 
	 * */
	static class Data implements Comparable<Data>{
		// 주어진 정수 값을 한 글자씩 읽었을 때의 문자열
		String key;
		
		// 주어진 정수의 실제 값
		int value;
		
		// 생성자
		public Data(String key, int value) {
			super();
			this.key = key;
			this.value = value;
		}
		
		// 정렬여부를 확인하기 위해 오버라이딩
		@Override
		public String toString() {
			return "Data [key=" + key + ", value=" + value + "]";
		}
		
		// 문자열을 기준으로 정렬해야 하므로 메소드 오버라이딩
		@Override
		public int compareTo(Data o) {
			int len = Math.min(this.key.length(), o.key.length());
			// 사전순 정렬을 하기위해 문자 한개씩 비교
			for(int i = 0; i < len; i++) {
				if(this.key.charAt(i) < o.key.charAt(i)) {
					return -1;
				} else if(this.key.charAt(i) > o.key.charAt(i)) {
					return 1;
				}
			}
			return 0;		
		}
	}
	
	public static void main(String[] args) throws Exception {
		// input을 가져오기 위한 객체 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 결과를 출력하기 위한 객체 선언
		StringBuilder sb = new StringBuilder();
		
		// input을 받아옴
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// input으로 받은 범위 내부 정수의 갯수
		int cnt = N-M+1;
		
		// 정수의 갯수만큼 배열 선언
		Data[] list = new Data[cnt];
		
		// 한 글자씩 읽을 수 있도록 매칭되는 문자열
		String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		// 배열에 저장할 값의 위치 인덱스
		int pos = 0;
		for(int num = M; num <= N; num++) {
			// 저장할 문자열
			String str = "";
			
			// 한 글자씩 읽기 위한 자릿수 처리, N과 M은 최댓 2자릿수 입력만 들어옴
			int x = num/10;
			int y = num%10;
			
			// 두 자릿수 입력의 경우만 처리 
			if(x != 0) {
				str += numbers[x];
			}
			
			str += numbers[y];
			
			// 배열에 객체로 집어넣음
			list[pos++] = new Data(str, num);
		}
		
		// Comparable 인터페이스의 compareTo메소드를 오버라이딩하여 구현하였기 때문에
		// Data객체의 key를 기준으로 사전 순서로 정렬됨
		Arrays.sort(list);
		
		// 출력문 작성
		for(int i = 1; i <= cnt; i++) {
			sb.append(list[i-1].value);
			
			// 마지막 값에 여백이 들어가지 않도록 처리
			if(i == cnt)
				break;
			
			if(i%10 == 0) {
				// 10개 출력시 줄바꿈
				sb.append("\n");
			} else {
				// 띄어쓰기 처리
				sb.append(" ");
			}
		}
		
		// 결과값 출력
		System.out.println(sb);
		
		// 자원 반환 처리
		br.close();
		sb = null;
		list = null;
	}
}
