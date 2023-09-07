class Solution {
    public static int solution(String[] lines) {
        int answer = 0;
        int len = lines.length;
        int[] start = new int[len];
        int[] end = new int[len];

        for (int i = 0; i < len; i++) {
            String[] time = lines[i].split(" ");
            String[] parse = time[1].split(":");

            int processing = (int) (Double.parseDouble(time[2].substring(0, time[2].length() - 1)) * 1000);
            end[i] += Integer.parseInt(parse[0]) * 60 * 60 * 1000;
            end[i] += Integer.parseInt(parse[1]) * 60 * 1000;
            end[i] += (int) (Double.parseDouble(parse[2]) * 1000);
            start[i] = end[i] - processing + 1;
        }

        // 처리 시간 최대 3초
        for (int i = 0; i < len; ++i) {
            int startSection = start[i];
            int endSection = startSection + 1000;

            int cnt = search(len, start, end, startSection, endSection);

            answer = Math.max(cnt, answer);
        }

        for (int i = 0; i < len; ++i) {
            int startSection = end[i];
            int endSection = startSection + 1000;

            int cnt = search(len, start, end, startSection, endSection);

            answer = Math.max(cnt, answer);
        }

        return answer;
    }

    static int search(int len, int[] start, int[] end, int startSection, int endSection) {
        int count = 0;

        for (int i = 0; i < len; ++i) {
            // 구간 안에 포함
            if (start[i] >= startSection && start[i] < endSection) {
                count++;
            } else if (end[i] >= startSection && end[i] < endSection) {
                // 시작점 상관 없이 포함
                count++;
            } else if (start[i] <= startSection && end[i] >= endSection) {
                // 양끝 모두 구간을 포함
                count++;
            }
        }
        return count;
    }
}