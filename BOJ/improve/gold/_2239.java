package com.ssafy.boj.improve.gold;
/*
 * DFS + 백트래킹
 * 
 * 1-1. 0인 위치를 찾는다.
 *    2-1. 0인 위치에 들어갈 수 있는 숫자를 찾아서 넣어준다.
 *         3-1. 1 - 9 반복하면서 가능한 수를 찾는다.(행, 열, 박스 체크)
 *         3-2. 가능한 숫자를 0의 위치에 넣는다. 
 *         
 * 1-2. 0인 위치가 없다면 답을 찾은 경우이다.
 * 
 * 1-2가 나올동안 1-1 반복
 */
import java.util.Scanner;

public class _2239 {
    // 0부터 80번까지를... 0부터 8이 1줄 9부터 17이 2줄.. 이런식으로 인덱스를 관리합니다.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(
				"103000509\n" + 
				"002109400\n" + 
				"000704000\n" + 
				"300502006\n" + 
				"060000050\n" + 
				"700803004\n" + 
				"000401000\n" + 
				"009205800\n" + 
				"804000107");
		for (int i = 0; i < 9; i++)
			sb.append(sc.next());
		
		dfs(sb.toString().toCharArray());

		for (int i = 0; i < 81; i += 9) {
			System.out.println(ans.substring(i, i + 9));
		}
	}

	static String ans = null;

	static void dfs(char[] s) {
		// 이미 답을 찾았으면 그만.
		if (ans != null)
			return;
		// 처음으로 0이 아닌 인덱스를 찾습니다.
		int idx = -1;
		for (int i = 0; i < 81; i++) {
			if (s[i] == '0') {
				idx = i;
				break;
			}
		}
		// 0인곳이 안남았으면 정답입니다.
		if (idx == -1) {
			ans = new String(s);
			return;
		}
		
		// 처음 0이 시작되는 위치의 행이 몇번째 행인지
		int rowStart = idx / 9;
		
		// 몇번째 열인지
		int colStart = idx % 9;
		
		// 그 행열 위치의 정사각박스의 출발점이 어딘지(0, 3, 6)
		int boxStart = rowStart / 3 * 3 * 9 + colStart / 3 * 3;
		
		// 작은수부터 넣어봅니다 1~9
		for (int i = 1; i < 10; i++) {
			// 가로 세로 박스를 검사해서
			if (check(s, (char) (i + 48), rowStart, colStart, boxStart)) {
				// 원래값 챙기고
				char tmp = s[idx];
				// 찾은 값 넣고
				s[idx] = (char) (i + 48);
				// 다음 스탭
				dfs(s);
				// 원복
				s[idx] = tmp;
			}
		}
	}

	static boolean check(char[] s, char val, int rs, int cs, int bs) {
//		System.out.printf("rs : %d, cs : %d, bs : %d%n", rs, cs, bs);
		// 9개에 대해서
		for (int i = 0; i < 9; i++) {
			// 내가 있는 행에 같은 값 있는지
			if (s[rs * 9 + i] == val)
				return false;
			// 열에 같은 값 있는지
			if (s[cs + 9 * i] == val)
				return false;
		}
		// 박스 검사.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (s[bs + 9 * i + j] == val)
					return false;
			}
		}
		return true;
	}
}