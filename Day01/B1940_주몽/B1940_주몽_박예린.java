package day7.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1940_주몽_박예린 {
	/**
	 * 백준 1940 : 주몽
	 * https://www.acmicpc.net/problem/1940
	 * 
	 * */
	
	static int [] arr;
	static int N, M, R;
	static int [] selection; 		// 현재 선택한 요소
	static boolean [] isSelected; 	// 마킹배열 - 선택했는지 체크
	static int cnt = 0;
	
	static void combination(int r , int start) {
		int sum = 0;

		if(r == R) {
			for(int i=0; i<R; i++) {
				sum += arr[selection[i]];
				if(sum == M) {
					cnt++;
					break;
				}
			}
			sum = 0;
			return;
		}

		for(int i=start; i<arr.length; i++) {
			if(isSelected[i]) continue;		// 중복인 경우 skip
			isSelected[i] = true;			// 중복 마킹
			selection[r] = i;				// 선택
			combination(r+1 , i );				// 다음 재귀로
			isSelected[i] = false;			// 선택한걸 되돌려줘야 함
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int [N];
		
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		R = 2;
		selection = new int [R];
		isSelected = new boolean [arr.length];

		combination(0,0);
		System.out.println(cnt);
	}
}
