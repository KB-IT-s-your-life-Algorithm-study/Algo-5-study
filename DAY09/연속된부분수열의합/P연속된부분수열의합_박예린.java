import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int N = sequence.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        if(sequence[0] == k) {
            answer = new int[]{0, 0};
            return answer;
        } else if(sequence[N - 1] == k) {
            answer = new int[]{N - 1, N - 1};
            return answer;
        }

        while (start < N) {
            if (sum > k || end == N) {
                sum -= sequence[start++];
            } else {
                sum += sequence[end++];
            }
            if (sum == k) {
                if(length > end - start) {
                    length = end - start;

                    answer[0] = start;
                    answer[1] = end - 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] sequence = {2,2,2,2,2};// {1, 1, 1, 2, 3, 4, 5};//{1, 2, 3, 4, 5}; // {2, 2, 2, 2, 2}; //   //  // {1, 1, 1, 2, 3, 4, 5}; //  //  // ;
        int k = 2; // 7;
        solution(sequence, k); // [6, 6]

        System.out.println(Arrays.toString(solution(sequence, k)));
    }
}