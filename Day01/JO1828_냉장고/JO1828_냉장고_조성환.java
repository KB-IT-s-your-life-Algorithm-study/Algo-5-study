package EX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2주차과제_조성환 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] temp = new int[N][2];


		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			temp[i][0] = Integer.parseInt(st.nextToken()); // 최저 온도
			temp[i][1] = Integer.parseInt(st.nextToken()); // 최고 온도
		}
		
		// 최고 온도 기준으로 정렬
		Arrays.sort(temp, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		// 냉장고가 하나는 무조건 있어야한다.(첫 화학 물질은 카운트 X기 때문)
		int ref = 1 ; 
		
		// 첫번째 화학물질을 기준으로 시작
		int max = temp[0][1];
		
		// 화학물질 하나씩 확인
		for (int i = 0 ; i < N ; i++) {
			// 다음 화학물질의 최저 온도가 최고 온도 아래 => 같은 냉장고 공유
			if(temp[i][0] <= max) {
				// 중복되는 온도의 최고 온도를 지정
				if(temp[i][1] < max) {
					max = temp[i][1];
				}
			// 안 겹치면 다시 시작
			}else {
				ref++;
				max = temp[i][1];
			}
		}
		System.out.println(ref);
	}

}
