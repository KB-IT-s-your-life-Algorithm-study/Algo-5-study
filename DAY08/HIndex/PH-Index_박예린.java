import java.util.*;

public class Solution {
    public int solution(int[] citations) { // 3,0,6,1,5
        int answer = 0;
        Arrays.sort(citations); // 0,1,3,5,6

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) { // 1 1 2 0 0 0 0 0 6
                answer = h;
                break;
            }
        }
        return answer;
    }
}