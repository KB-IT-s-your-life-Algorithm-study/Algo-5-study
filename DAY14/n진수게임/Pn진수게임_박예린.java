class Solution {
    public static String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < t * m; i++) {
            result.append(Integer.toString(i, n));
        }

        for(int j = p - 1; answer.length() < t; j += m) {
            answer.append(result.charAt(j));
        }

        return answer.toString().toUpperCase();
    }
}