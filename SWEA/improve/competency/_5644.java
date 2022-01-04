/*
 * 기본 데이터 입력받기
 * 플레이어 이동시키기
 * 플레이어 이동시 각 위치에서 배터리 충전이 가능한 최대값 찾기
 */
package com.ssafy.swea.improve.competency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _5644 {
	static class Player {
		int x, y;
		Player(int x, int y) {
			this.x = x;
			this.y = y;
		}
		void move(int dir) {
			x += dx[dir];
			y += dy[dir];
		}
	}
	static class BC {
		int x, y, c, p;	// x, y, 충전범위, 처리량
		BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
		
	}
	static int M, A, ans;	// 총 이동시간, BC의 총 개수
	static int[] pathA, pathB;
	static Player playerA, playerB;
	static ArrayList<BC> bc;
	
	// 이동없음, 상,우,하,좌
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; ++t) {
			ans = 0;
			M = sc.nextInt(); // 총 이동시간
			A = sc.nextInt(); // BC 개수

			playerA = new Player(1, 1);
			playerB = new Player(10, 10);

			pathA = new int[M + 1];
			pathB = new int[M + 1];
			
			for (int c = 1; c <= M; ++c) pathA[c] = sc.nextInt();
			for (int c = 1; c <= M; ++c) pathB[c] = sc.nextInt();

			// AP 의 정보 (4, 4), 1, 100 : 좌표, 충전범위(Coverage), 성능(Performance)
			bc = new ArrayList<>();
			for (int a = 0; a < A; ++a) {
				bc.add(new BC(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			
			// 충전량으로 정렬
			Collections.sort(bc, (a, b) -> b.p - a.p);
			
			bc.add(0, new BC(0, 0, 0, 0));	// 충전량 0을 하나 추가해서 만약, 이동중에 해당되는 충전소가 없을 경우 사용
			System.out.println(bc);
			
			// 문제 풀기 시작
			solve();
			
			System.out.println("#" + t + " " + ans);
		}
	}

	// 매 시간마다의 두 사용자의 최대 충전량의 합을 구하여 모두 더함.
	static void solve() {
		for (int time = 0; time <= M; ++time) { // 처음 있는 자리부터 처리해야하므로 시간은 0부터
			// 두 플레이어 위치 이동
			playerA.move(pathA[time]);
			playerB.move(pathB[time]);

			// 현재의 위치에서 최대 충전량 계산하자
			int[] paBC = getCharge(playerA);
			int[] pbBC = getCharge(playerB);
			
			/*
			 * 케이스를 따져보자
			 * 
			 * 0번 충전기는 충전량 0 - 못찾은 경우 사용
			 * 
			 * 					  A			  B			충전량
			 * A만 있는 경우		BC1, 0		0, 0		BC1 + 0
			 * B만 있는 경우		0, 0		BC1, 0		BC1 + 0
			 * A와 B가 다른 영역   BC1, 0		BC2, 0		BC1 + BC2
			 * 
			 * 같은 영역일 경우는 가장 큰 영역을 선택하고 다른 영역중 큰 값을 선택한다.
			 * 최대충전 같은 영역	BC1, 0		BC1, 0		BC1 + max(BC2, BC3)
			 * 최대충전 같은 영역	BC1, BC2	BC1, BC3	BC1 + max(BC2, BC3)
			 * 최대충전 같은 영역	BC1, BC2	BC1, 0		BC1 + max(BC2, BC3)
			 * 최대충전 같은 영역	BC1, 0		BC1, BC3	BC1 + max(BC2, BC3)
			 */
			
			
			if (paBC[0] != pbBC[0]) {
				ans += bc.get(paBC[0]).p + bc.get(pbBC[0]).p;
			} else {
				// 같은 충전소에 둘다 충전이 가능하면 충전량이 같으니 둘 중 아무거나 충전량으로 사용하고
				// 같은 충전소에 한쪽만 충전이 가능하면 하나는 0,다른 하나는 0이 아닌 값이므로
				// 결국, 최대값으로 사용하면 됨.
				ans += bc.get(paBC[0]).p + Math.max(bc.get(paBC[1]).p, bc.get(pbBC[1]).p);
			}
		}
	}

	// 현재 위치에서 가장 충전량이 많은 2군데의 정보를 가져온다.(왜 2군데?? 두명의 사용자가 같은 충전소를 볼수 있어서)
	static int[] getCharge(Player p) {
		int[] maxBC = {0, 0};
		int ind = 0;
		int pos = 1;	// 왜 위치를 1부터 찾는가?? 첫번째는 충전소를 찾지 못했을때 사용하기 위해서..
		while (ind < 2 && pos <= A) {
			if (check(bc.get(pos), p)) {
				maxBC[ind++] = pos;
			}
			++pos;
		}
		return maxBC;
	}
	
	// 충전가능여부
	// 충전소번호, 플레이어 위치
	// 충전이 불가능하다면 0을 리턴
	static boolean check(BC bc, Player p) {
		return Math.abs(bc.x - p.x) + Math.abs(bc.y - p.y) <= bc.c;
	}
}
