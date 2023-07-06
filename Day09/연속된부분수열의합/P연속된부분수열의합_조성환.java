package 연속된부분수열의합;

import java.util.Arrays;

public class P연속된부분수열의합_조성환 {
	public static void main(String[] args) {

		int[] sequence = new int[] {1, 2, 3, 4, 5};
		int k = 7;
		System.out.println(Arrays.toString(solution(sequence, k)));
	}

	static int[] solution(int[] sequence, int k) {

		
		// 총 길이
		int len_n = sequence.length;
		
		// 시작과 끝 합
		int max_sum = 0;
		int start = 0;
		int end = len_n;
		
		// 전체 탐색 (시작과 끝이 함께 증가)
		for(int S = 0, E = 0; S < len_n; S++) {
			// 합이 k보다 작을 때 까지 R의 값을 1씩 증가
            while(E < len_n && max_sum < k) {
            	max_sum += sequence[E++];
            }
            
            // 합이 k와 같으면
            if(max_sum == k) {
            	// 수열의 길이를 비교한다.
                int range = E - S - 1;
                if((end - start) > range) {
                	start = S;
                	end = E - 1;
                }
            }
            
            max_sum -= sequence[S];
        }
		
		int[] answer = {start, end};
			
        return answer;
    }
}
