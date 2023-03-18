package Alog2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 예제를 수직선에 나열하니 회의실 문제와 비슷하다고 판단 

public class J1828_냉장고_김혜인 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int arr[][] = new int[N][2];

		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		 Arrays.sort(arr, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] a, int[] b) {
	              return a[1]==b[1]? a[0]-b[0]: a[1]-b[1];
	            }
	        });

		/* 처음에 회의실 구한대로 최솟값 하려다가 실패
		int time = 0;
		int count = 1;
		for(int i=0; i<N; i++) {
			if(arr[i][0] >= time) {
				time = arr[i][1];
				count ++;
			}
		}System.out.println(count); */
		 
		//스터디 회의 후 최대값으로 바꿔야 한다는 팁 얻고 다시
		 
		int max = arr[0][1];
		int count = 1;
		
		for(int i=0; i<N; i++) {
			if(max<arr[i][0]) {
				max = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}
		