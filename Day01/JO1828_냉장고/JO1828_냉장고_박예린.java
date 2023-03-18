package day7.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1828_냉장고_박예린 {
	/**
	 * 정올 1828 : 냉장고
	 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=3050
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 * */
	
	static int search(int [][] arr, int N) {
		int res = 1;
		int count;
		int index = 0;
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			count = 0;
			System.out.println("i = " + i);
			max = arr[i][1];
			for(int j = i + 1; j < N; j++) {
				if(max > arr[j][1]) {
					max = arr[j][1];
				}
				
				
				if(max <= arr[j][0]) {
					System.out.println("arr[j][0] = " + arr[j][0]);
					count++;
					System.out.println("count = " + count);
					index = j;
					System.out.println("index = " + index);

					break;
				}
			}
			System.out.println("----------------------");
			if(count == 0) {
				System.out.println("res!!!!!!!!!!!!!!!!!!!!!!! = "+res);
				res++;
				break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int [N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> {
		    return o1[0]-o2[0];
		});
		
		System.out.println(Arrays.deepToString(arr));
		System.out.println(search(arr, N));
	}
}
