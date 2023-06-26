package P프린터;

import java.util.LinkedList;
import java.util.Queue;

public class P프린터_박예린 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();


        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
        }

        for (int i = 0; i < priorities.length; i++) {
            tempQueue.offer(priorities[i]);
        }


        int a = 0;
        int indexValue = queue.peek(); // indexValue : 2, queue : 2 5 3 2 9 4 6
        int count = 0;
        int temp = 0;
        int request = 0;

        // priorities : 2 1 3 2
        while(!queue.isEmpty() && indexValue >= queue.peek()) {
            int cnt = 0;
            int[] tempArr = new int[queue.size()];
            indexValue = queue.peek(); // indexValue : 2
            queue.poll(); // queue : 1 3 2


            while(!queue.isEmpty()) {
                if (indexValue >= queue.peek()) { // 2 1 // 1 3
                    tempArr[cnt] = indexValue; // tempArr[0] : 2; // tempArr[1] : 2;
                    cnt++; // cnt : 1
                    indexValue = queue.poll(); // indexValue : 1, queue : 3 2 2
                    queue.offer(indexValue); // queue : 1 3 2 2


                    if (location > 0) { // location : 2, location의 값 : 3
                        location--; // location : 1
                    } else {
                        location = queue.size() - 1;
                    }
                    break;
                } else {
                    break;
                }

            }
            indexValue = queue.peek();

        }
        answer = location + 1;

        return answer;
    }
}
