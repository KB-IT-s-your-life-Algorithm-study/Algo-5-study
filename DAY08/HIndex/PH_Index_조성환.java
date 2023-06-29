package HIndex;

import java.util.Arrays;

public class PH_Index_조성환 {

	public static void main(String[] args) {

		int[] citations = new int[] { 3, 0, 6, 1, 5 };

		System.out.println(solution(citations));
	}

	static int solution(int[] citations) {
		// 인용된 논문의 횟수가 최소한 인용 갯수보단 같거나 많아야한다. 
		
		int answer = 0;
		
		// 오름차순 정렬
		Arrays.sort(citations);
		
		// 총 논문 갯수
		int n = citations.length;
		
		// 인용한 논문 갯수 - 1씩 하면서 최댓값 구하기
		for(int i = 0 ; i < n ; i++ ) {
			// 인용한 논문 수
			int h = n - i;
			
			// 횟수 >= 갯수면 답
			if(citations[i] >= h) {
				answer = h;
				break;
			}
		}
		
		return answer;

	}
}
