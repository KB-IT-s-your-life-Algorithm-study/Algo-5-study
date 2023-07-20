import java.util.Arrays;

class Solution {
    public static int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        int[] bonus = new int[3];
        char[] option = new char[3];

        int scoreCnt = 0;
        int bonusCnt = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if(isNum(c)) {
                int num = c - 48;

                // 점수가 10일 때
                if(num == 1 && dartResult.charAt(i + 1) - 48 == 0) {
                    score[scoreCnt++] = 10;
                    i++;
                } else {
                    score[scoreCnt++] = num;
                }
            }

            switch (c) {
                case 'S':
                    bonus[bonusCnt++] = 1;
                    break;
                case 'D':
                    bonus[bonusCnt++] = 2;
                    break;
                case 'T':
                    bonus[bonusCnt++] = 3;
                    break;
                case '*':
                case '#':
                    option[bonusCnt - 1] = c;
                    break;
                default:
                    break;
            }
        }

//        System.out.println(Arrays.toString(score));
//        System.out.println(Arrays.toString(bonus));
//        System.out.println(Arrays.toString(option));

        // 옵션을 점수화한 결과를 담는 배열
        int[] optRes = new int[] {1, 1, 1}; // 곱하기 연산이므로 1로 초기화한다.

        for(int i = 2; i >= 0; i--) {
            if (option[i] == '*') {
                optRes[i] *= 2;
                if (i > 0) {
                    optRes[i - 1] *= 2;
                }
            } else if (option[i] == '#') {
                optRes[i] *= -1;
            }
        }

//        System.out.println(Arrays.toString(optRes));

        // 다트 게임은 세 번의 기회가 주어진다.
        for(int i = 0; i < 3; i++) {
            // 1. 단순 계산 (보너스가 없음.)

            // 2. 스타상
            // 2-1. i번째와 i-1번째 점수를 2배로 만든다.
            // 2-2. i == 0일 때는 i번째 점수만 2배가 된다.
            // 2-3. i, i+1번째에 스타상 연속 당첨 시 i번째 점수는 4배가 된다.
            //          [스타 효과 적용, 스타 + 스타 효과 적용, 스타]

            // 3. 아차상
            // 3-1. i번째 점수는 마이너스 된다.

            // 4. 스타상과 아차상 중첩
            // 4-1. 옵션은 존재하지 않거나 둘 중 하나만 존재한다.
            // 4-2. 옵션 : [아차 + 스타 효과 적용 => -2배, 스타, __]
            //      -> 스타 직전의 옵션이 무엇이었는지 체크해야 한다.

            answer += ((int) Math.pow(score[i] , bonus[i])) * optRes[i];
        }

        return answer;
    }

    // char가 0~9인지 체크하는 함수
    public static boolean isNum(char c) {
        return 47 < c && c < 58;
    }

    public static void main(String[] args) {
//        String dartResult = "10S2D*3T"; // Test case 1 : 37
//        String dartResult = "1D2S#10S"; // Test case 2 : 9
//        String dartResult = "1D2S0T"; // Test case 3 : 3
//        String dartResult = "1S*2T*3S"; // Test case 4 : 23
        String dartResult = "1D#2S*3S"; // Test case 5 : 5
//        String dartResult = "1T2D3D#"; // Test case 6 : -4
//        String dartResult = "1D2S3T*"; // Test case 7 : 59

//        solution(dartResult);
        System.out.println(solution(dartResult));
    }
}