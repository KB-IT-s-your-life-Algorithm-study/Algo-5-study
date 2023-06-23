package P기능개발;

import java.util.LinkedList;
import java.util.Queue;

public class P기능개발_박예린 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length]; // 아직 answer 배열의 사이즈를 모르기 때문에 임시 배열을 선언한다.
        int[] leftProg = new int[progresses.length]; // 남은 진도

        Queue<Integer> queue = new LinkedList<Integer>(); // 잔여 일수를 queue에 저장한다.

        for (int i = 0; i < progresses.length; i++) {
            leftProg[i] = 100 - progresses[i];  // 잔여 진도율을 배열에 저장한다.

            if (leftProg[i] % speeds[i] == 0) {
                queue.add(leftProg[i] / speeds[i]);
            } else {
                queue.add((leftProg[i] / speeds[i]) + 1); // 소수점이 있을 경우 올림 계산을 해준다.
            }
        }

        int size = 0;

        while(!queue.isEmpty()) {
            int day = queue.poll(); // queue에서 First out
            int count = 1; // 원소 하나가 있고 연산을 시작하면 count = 1

            while(!queue.isEmpty() && day >= queue.peek()) { // 순서대로 값을 비교하면서 먼저 순서의 잔여일수(day)를 기준으로 day가 최댓값일 때까지 count++한다.
                count++;
                queue.poll();
            }
            temp[size] = count; // day보다 큰 값이 나오는 순간 배포되는 작업의 수를 temp에 저장한다.
            size++; // answer의 size
        }

        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = temp[i];
        }
        return answer;
    }
}