import java.util.Arrays;

class Solution {
    public static int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        // 결과값 출력
        System.out.println(Arrays.toString(words));

        String word = words[0];
        int count = word.length();
        String prefix = "";

//        System.out.println(word);
//        System.out.println(count);

        // 단어의 수만큼 for문
        for(int i = 1; i < words.length; i++) {
            System.out.println("i = " + i);

            int flag = -1;

            if(count > 0 && !isPrefix(prefix, words[i])) {
                prefix = "";
                word = words[i];
                continue;
            }

            // 글자 수만큼 for문
            for(int j = 0; j < word.length(); j++) {
                System.out.println("j = " + j );

                if(word.charAt(j) != words[i].charAt(j)) {
                    flag++;
                    System.out.println("word.charAt(j) = " + word.charAt(j));
                    System.out.println("words[i].charAt(j) = " + words[i].charAt(j));

                    count += j + 1;
                    System.out.println("count = " + count);
                    break;
                } else {

                }
            }
            count += word.length() + 1;

            prefix += word;
            System.out.println("prefix = " + prefix);

            word = "";
            word += words[i];
            System.out.println("word = " + word);



        }

        System.out.println(count);


        return answer;
    }

    static boolean isPrefix(String prefix, String str) {
        boolean result = true;

        for(int k = 0; k < prefix.length(); k++) {
            if (prefix.charAt(k) != str.charAt(k)) {
                result = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"go","gone","guild"};

        String[] words = {"word","war","warrior","world"}; // war, warrior, word, world



        solution(words);
    }
}