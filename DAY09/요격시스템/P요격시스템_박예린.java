import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);

        int e = 0;

        for(int i = 0; i < targets.length; i++) {

            if(e > targets[i][0]) {
                continue;
            } else {
                answer++;
                e = targets[i][1];
            }

        }

        return answer;
    }
}