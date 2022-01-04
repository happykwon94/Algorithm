package com.ssafy.boj.silver;

// 21.08.12 오타 좀 신경쓰자 그거 찾는데 시간이 너무 오래걸린다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16935 {
	
	static int[][] arr;
	static int[][] org;
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		org = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int m = 0; m < M; m++) {
				org[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		char[] command = br.readLine().replaceAll(" ", "").toCharArray();
		
		for(int r = 0; r < R; r++) {
			method(command[r]-'0');
		}
		
		print();
		
		br.close();
		
	}
	
	private static void method(int num) {
		switch(num) {
		case 1:
			verticalReverse();
			break;
		case 2:
			horizontalReverse();
			break;
		case 3:
			rotate();
			break;
		case 4:
			reverseRotate();
			break;
		case 5:
			divideRotate();
			break;
		case 6:
			divideReverseRotate();
			break;
		}
	}
	
	private static void print() {
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				System.out.print(org[n][m]+ " ");
			}
			System.out.println();
		}
	}
	
	private static void lengthSwap() {
		int temp = N;
		N = M;
		M = temp;
	}
	
	private static void verticalReverse() {
		arr = new int[N][];
		for(int n = 0; n < N; n++) {
			arr[n] = Arrays.copyOf(org[N-n-1], M);
		}
		org = arr;
	}
	
	private static void horizontalReverse() {
		arr = new int[N][M];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				arr[n][m] = org[n][M-m-1];
			}
		}
		org = arr;
	}
	
	private static void rotate() {
		lengthSwap();
		arr = new int[N][M];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				arr[n][M-m-1] = org[m][n];
			}
		}
		org = arr;
	}
	
	private static void reverseRotate() {
		lengthSwap();
		arr = new int[N][M];		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				arr[N-n-1][m] = org[m][n];
			}
		}
		org = arr;

	}
	
	private static void divideRotate() {
		// 1영역
		arr = new int[N][M];
		
		for(int n = 0; n < N/2; n++) {
			for(int m = 0; m < M/2; m++) {
				arr[n][M/2 + m] = org[n][m];
			}
		}
		
		// 2영역
		for(int n = 0; n < N/2; n++) {
			for(int m = M/2; m < M; m++) {
				arr[N/2 + n][m] = org[n][m];				
			}
		}
		
		// 3영역
		for(int n = N/2; n < N; n++) {
			for(int m = M/2; m < M; m++) {
				arr[n][m - M/2] = org[n][m];				
			}
		}
		
		// 4영역
		for(int n = N/2; n < N; n++) {
			for(int m = 0; m < M/2; m++) {
				arr[n-N/2][m] = org[n][m];				
			}
		}
		
		org = arr;

	}

	private static void divideReverseRotate() {
		arr = new int[N][M];
		
		// 1영역
		for(int n = 0; n < N/2; n++) {
			for(int m = 0; m < M/2; m++) {
				arr[N/2 + n][m] = org[n][m];
			}
		}
		
		// 2영역
		for(int n = 0; n < N/2; n++) {
			for(int m = M/2; m < M; m++) {
				arr[n][m - M/2] = org[n][m];				
			}
		}
		
		// 3영역
		for(int n = N/2; n < N; n++) {
			for(int m = M/2; m < M; m++) {
				arr[n - N/2][m] = org[n][m];				
			}
		}
		
		// 4영역
		for(int n = N/2; n < N; n++) {
			for(int m = 0; m < M/2; m++) {
				arr[n][M/2 + m] = org[n][m];				
			}
		}
		
		org = arr;

	}
}
