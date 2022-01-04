package com.ssafy.boj.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1786 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int lenT = T.length;
		int lenP = P.length;
		
		int[] pi = new int[lenP];
	    for(int i=1, j=0; i<lenP; i++){
	        while(j > 0 && P[i] != P[j]) {
	        	j = pi[j-1];  
	        }
	        if(P[i] == P[j]) pi[i] = ++j;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0,j=0; i<lenT; ++i) { 
			
			while(j>0 && T[i] != P[j]) j = pi[j-1]; 
			
			if(T[i] == P[j]) {
				if(j == lenP-1) {
					cnt++;
					list.add((i+1)-lenP); 
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			for(int x : list) {
				System.out.print(x+1+" ");
			}
		}
	}
}
