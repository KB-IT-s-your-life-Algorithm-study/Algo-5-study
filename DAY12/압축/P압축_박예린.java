import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();

//        System.out.println(msg.length());

        // 알파벳 배열 생성
        ArrayList<String> alphabet = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            alphabet.add(Character.toString((char) (i + 65)));
//            System.out.println(alphabet);
        }

        int remain = 0;

        for(int i = 0; i < msg.length(); i++) {
            String w = "";
            String str = "";

            str += msg.charAt(i);

            for(int j = i + 1; j < msg.length(); j++) {
                w = str;
                str += msg.charAt(j);

                if(!alphabet.contains(str)) {
                    if(alphabet.contains(w)) {
                        alphabet.add(str);

                        if(w.length() > 1) i += w.length() - 1;

                        remain = i;

//                        System.out.println("i = " + i);

//                        System.out.println("alphabet size = " + alphabet.size());
//                        System.out.println("alphabet index of = ");
//                        System.out.println(+ alphabet.indexOf(w) + 1);

                        answer.add(alphabet.indexOf(w) + 1);

//                        System.out.println("w = " + w);
//                        System.out.println("str = " + str);
//                        System.out.println("-----------------");
                    }

                    break;
                }
            }
        }

        String lastStr = "";

        if(msg.length() == 1) {
            answer.add(1);
        } else {
            // 마지막 남은 글자 answer에 추가
            for(int i = remain + 1; i < msg.length(); i++) {
                lastStr += msg.charAt(i);
            }

            answer.add(alphabet.indexOf(lastStr) + 1);
        }

//        System.out.println("lastStr = " + lastStr);
//        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
//        String msg = "KAKAO"; // 	[11, 1, 27, 15]
        String msg = "TOBEORNOTTOBEORTOBEORNOT"; // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
//        String msg = "ABABABABABABABAB"; // 	[1, 2, 27, 29, 28, 31, 30]


        // 반례 1 : 문자열로 'A'만 들어왔을 때 정답은 [1]이 되어야 합니다.
//        String msg = "A";
        // 반례 2 : "AAAAAA"는 [1,27,28]
        solution(msg);
    }
}