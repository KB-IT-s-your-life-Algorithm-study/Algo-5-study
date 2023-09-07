import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int tmp = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 셔틀 대기열을 시간 순으로 변환 및 정렬
        for(String str : timetable) {
            int hour = Integer.parseInt(str.substring(0, 2));
            int min = Integer.parseInt(str.substring(3, 5));

            pq.add(hour * 60 + min);
        }

        int start = 9 * 60;
        int end = 0;
        int count = 0; // 한 타임에 타는 크루 수

        // n : 셔틀 운행 횟수
        for(int i = 0; i < n; i++) {
            count = 0;

            while(!pq.isEmpty()) {
                int crew = pq.peek();

                if(crew <= start && count < m) {
                    count++;
                    pq.poll();
                } else break; // 다른 타임으로 넘어감

                end = crew - 1; // 콘이 가장 마지막 순서이므로 자리가 남지 않았을 때의 답
            }
            start += t;
        }

        // 가장 마지막 타임에 자리가 남음
        if(count < m) end = start - t;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", end / 60));
        sb.append(":");
        sb.append(String.format("%02d", end % 60));

        return sb.toString();
    }
}