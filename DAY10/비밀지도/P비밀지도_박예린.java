import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        // 01001(2) = 9(10)

        // arr1, arr2의 배열 사이즈 처리
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];

        double result = Math.pow(2, n); // 16

        System.out.println(Arrays.toString(arr1));

        // arr1을 String 형태의 이진수로 변환
        for(int i = 0; i < n; i++) {
            binary1[i] = Integer.toBinaryString(arr1[i]);
            binary2[i] = Integer.toBinaryString(arr2[i]);

            // 2진수가 n-1자리일 때 0으로 채우기

            // binary1[i] 의 length로 조건문 바꾸기
            int len1 = binary1[i].length();

            if(len1 < n) {
                for(int j = 0; j < n - len1; j++) {
                    binary1[i] = "0" + binary1[i];
                }
            }

            // binary2[i] 의 length로 조건문 바꾸기
            int len2 = binary2[i].length();

            if(len2 < n) {
                for(int j = 0; j < n - len2; j++) {
                    binary2[i] = "0" + binary2[i];
                }
            }

            System.out.println(Arrays.toString(binary2));

        }

        // arr1, arr2를 오버레이함.
        // 공백 || 벽 = 벽
        // 공백 && 공백 = 공백

        // test
        System.out.println(binary2[0].charAt(3) - '0'); // char to int : '0'을 빼주기 (ASCII code 사용)

        // answer에 담기
        for(int i = 0; i < n; i++) {
            answer[i] = ""; // 초기화를 해주지 않으면 null인 상태에서 +연산이 된다.

            for(int j = 0; j < n; j++) {
                int tmp = (binary1[i].charAt(j) - '0') + (binary2[i].charAt(j) - '0');

                // tmp가 1 이상이면 #, 0이면 공백
                if(tmp == 0) {
                    answer[i] = answer[i] + " ";
                } else {
                    answer[i] = answer[i] + "#";
                }
            }
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        // test case 1
//        int n = 5;
//        int[] arr1 = {9, 20, 28, 18, 11};
//        int[] arr2 = {30, 1, 21, 17, 28};

        // test case 2
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        solution(n, arr1, arr2); // ["#####","# # #", "### #", "# ##", "#####"]
    }
}