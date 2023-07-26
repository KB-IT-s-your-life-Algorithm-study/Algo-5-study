import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;

        // 자카드 유사도 : 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값

        // 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
        // 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
        // 대문자와 소문자의 차이는 무시한다.
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> multiset1 = new ArrayList<>();
        ArrayList<String> multiset2 = new ArrayList<>();

        // Test case 3 : 43690
//        AA, A1, 1+, +A, AA, A2 => AA, AA
//        AA, AA, AA, A1, 12 => AA, AA, AA
//
//        2 / 3

//        [AA, A1, 1+, +A, AA, A2]
//        [AA, AA, AA, A1, 12]

//        [AA, AA]
//        [AA, AA, AA]

        multiset1 = makeMultiSet(str1);
        multiset2 = makeMultiSet(str2);

        Collections.sort(multiset1);
        Collections.sort(multiset2);

        // 같을 경우
        if(multiset1.equals(multiset2) && !multiset1.isEmpty()) {
            return 65536;
        }

        ArrayList<String> union = (ArrayList<String>) multiset1.clone(); // shallow copy

        union.addAll(multiset2);

        ArrayList<String> intersection = new ArrayList<>();

        int length = multiset1.size();


        for(int i = 0; i < multiset1.size(); i++) {
            if(multiset2.contains(multiset1.get(i))) {
                multiset2.remove(multiset1.get(i));
                intersection.add(multiset1.get(i));
            }
        }

        if(intersection.isEmpty() && union.size() != 0) return 65536;

        answer = (int) Math.floor(((float) intersection.size() / ((float) union.size() - (float) intersection.size() )) * 65536);

        return answer;
    }

    // 문자열이 영문자에 해당하는지 체크하는 함수
    public static boolean isEng(String str) {
        return str.matches("^[a-zA-Z]*$");
    }

    // 다중집합을 만드는 함수
    public static ArrayList<String> makeMultiSet(String str) {
        ArrayList<String> multiset = new ArrayList<>();

        for(int i = 0; i < str.length() - 1; i++) {
            String now = Character.toString(str.charAt(i));
            String next = Character.toString(str.charAt(i + 1));

            if(isEng(now) && isEng(next)) {
                multiset.add(now + next);
            }
        }

        return multiset;
    }

    public static void main(String[] args) {
        // Test case 1 : 16384
//        String str1 = "FRANCE";
//        String str2 = "french";

        // Test case 2 : 65536
//        String str1 = "handshake";
//        String str2 = "shake hands";

        // Test case 3 : 43690, 2/3
//        String str1 = "aa1+aa2";
//        String str2 = "AAAA12";


        // Test case 4 : 65536
//        String str1 = "E=M*C^2";
//        String str2 = "e=m*c^2";

        // Test case 5(반례) : 32768
//        String str1 = "abab";
//        String str2 = "baba";

        // Test case 6(반례) : 교집합은 없으나 합집합이 있을 때
        String str1 = "A+CE";
        String str2 = "DEF";


//        solution(str1, str2);
        System.out.println(solution(str1, str2));
    }
}