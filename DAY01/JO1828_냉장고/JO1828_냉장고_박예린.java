package JO1828_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1828_냉장고_박예린 {
	/**
	 * 정올 1828 : 냉장고
	 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=3050
	 * */
	
	static int search(int [][] arr, int N) {
		int count = 1;
		int max = arr[0][1]; // 냉장고에 들어갈 수 있는 온도 범위 상한선의 초기값
		
		for(int i = 0; i < N; i++) {
			// 현재 온도 범위의 상한선과 다음 화학 물질의 최저 온도가 같아도 그 온도로 유지할 수 있음. 
			if(max >= arr[i][0]) {
				// 온도 범위 상한선 업데이트
				if(max > arr[i][1]) max = arr[i][1];
				continue;
			} else {
				// 상한선을 초과하는 경우 i번째부터 같은 냉장고에 들어갈 수 없음.
				count++;
				max = arr[i][1];
			}
		}
		return count;
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
		
		// 화학 물질의 최저 온도를 기준으로 오름차순 정렬
		Arrays.sort(arr, (o1, o2) -> {
		    return o1[0]-o2[0];
		});
		
		System.out.println(search(arr, N));
	}
}
