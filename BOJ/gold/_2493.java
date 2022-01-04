package com.ssafy.boj.gold;

// 21.08.05
//	stack에 있는 값보다 큰 값이 들어오면 이전 값들은 의미가 없어진다.
//	더 작다면 나중에 들어오는 값들 중 작은 값들의 신호를 수신할 수 있으므로 stack에 보관
//	스택의 탑보다 새로 들어오는 값이 크면 새로 들어오는 값보다 큰 스택의 값을 만나기 전까지 꺼내고 집어넣는다. 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int i = 1;
		stack.push(Integer.parseInt(st.nextToken()));
		index.push(i);
		sb.append(0).append(" ");
		
		while(st.hasMoreTokens()) {
			int target = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				if(stack.peek() > target) {
					sb.append(index.peek()).append(" ");
					break;
				}
				
				stack.pop();
				index.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append(0).append(" ");				
			}
			
			stack.push(target);
			index.push(++i);
		}
		System.out.println(sb);
		
		br.close();
	}
}
