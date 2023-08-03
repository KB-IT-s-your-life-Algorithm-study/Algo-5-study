import java.util.ArrayList;

class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        // 일치하는 음악의 인덱스 저장
        ArrayList<Integer> candidate = new ArrayList<>();

        // 0. 파싱하기
        // musicinfos를 시작 시간, 끝나는 시간 / 노래 제목 / 멜로디
        int len = musicinfos.length;

        int[] time = new int[len];
        String[] title = new String[len];
        String[] melody = new String[len];

        for(int i = 0; i < len; i++) {
            String[] tmp = musicinfos[i].split(",");

            tmp[1] = tmp[1].replaceAll(":", "");
            tmp[0] = tmp[0].replaceAll(":", "");

            time[i] = Integer.parseInt(tmp[1]) - Integer.parseInt(tmp[0]);

            title[i] = tmp[2];
            melody[i] = changeMelody(tmp[3]);
        }

        // 1. m과 musicinfos의 멜로디가 일치하는 것을 찾기
        // m의 0번째 인덱스를 musicinfos에서 찾는다.
        // musicinfos의 인덱스 i번째부터 +1을 하면서 m의 인덱스와 일치하는지 확인한다.
        // 이 과정을 음악 하나하나 for문으로 확인하면 낭비이므로 for문 한번에 모든 음악과 일치하는지 확인한다.

        String segment = "";

        for(int i = 0; i < len; i++) {
            System.out.println("노래 제목 = " + title[i]);
            String music = m;

            // segment 초기화
            segment = "";

            for(int j = 0; j < music.length(); j++) {
                System.out.println("------------");
                System.out.println("j = " + j);

                if(music.charAt(j) != '#') {
                    segment += music.charAt(j);
                }

                System.out.println(music);

                if(j < music.length() - 1 && music.charAt(j + 1) == '#') {
                    segment += '#';
                } else if(music.length() > 1 && j == 0 && music.charAt(1) == '#') {
                    segment += '#';
                }
                System.out.println("segment = " + segment);



                if(music.length() == 0) {
                    System.out.println("이제 없어..");
                    break;
                }

                int lengthOfMusic = melody[i].length();
//            System.out.println(lengthOfMusic);
                int idx = melody[i].indexOf(segment);

                System.out.println("idx = " + idx);

                if(melody[i].charAt(idx + 1) != '#' && idx != -1) {
                    System.out.println("멜로디에 있음...");
                    System.out.println("music = " + music);

                    if(music.equals(segment)) {
                        System.out.println("일치함,,,");

                        if(candidate.isEmpty() || (melody[candidate.get(0)].length() > melody[i].length())) {
                            candidate.add(i);

                        }


                        System.out.println("m에서 segment 지움");
                        music = music.replaceAll(segment, "");
                        System.out.println(music);

                        break;
                    }
//                System.out.println("멜로디 인덱스");
//                System.out.println(m.charAt(idx));
                }

                if(idx + segment.length() == melody[i].length()) {
                    System.out.println("멜로디 마지막");
                    System.out.println(segment);

                    System.out.println("m에서 segment 지움");
                    music = music.replaceAll(segment, "");
                    System.out.println(music);

                    if(music.equals("")) {
                        if(candidate.isEmpty() || melody[candidate.get(0)].length() > melody[i].length()) {
                            candidate.add(i);

                        }
                    }

                    System.out.println("candidate = ");
                    System.out.println(candidate);

                    // segment 초기화
                    segment = "";

                    // j 초기화
                    j = -1;

                    continue;
                }

            }
        }

        // 하나의 musicinfos에 대하여
        // 만약 indexOf가 있었고, 끝에 다다랐으면 그 때의 segment를 기억한다.
        // segment에 해당하는 부분을 m에서 지운다.

        // Test case 2
        // CC#B CC#B CC#B CC#B
        // CC#B CC#B CC#B

        System.out.println(candidate.get(0));
        answer = title[candidate.get(0)];

        return answer;
    }

    // 치환
    static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");

        return newMelody;
    }

    public static void main(String[] args) {
        // Test case 1 : "HELLO"
//        String m = "ABCDEFG";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        // Test case 2 : "FOO"
//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        // Test case 3: "WORLD"
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m, musicinfos));
    }
}