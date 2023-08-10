class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int play = 0;

        // # 치환
        m = changeMelody(m);

        // 파싱하기
        // musicinfos를 시작 시간, 끝나는 시간 / 노래 제목 / 멜로디
        int len = musicinfos.length;

        int[] time = new int[len];
        String[] title = new String[len];
        String[] melody = new String[len];

        for (int i = 0; i < len; i++) {
            String[] tmp = musicinfos[i].split(",");
            String[] start = tmp[0].split(":");
            String[] end = tmp[1].split(":");
            int hour = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
            int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);

            time[i] = hour + minute;

            title[i] = tmp[2];
            melody[i] = changeMelody(tmp[3]);
        }


        // 각 곡마다 재생 시간만큼 돌면서 확인
        for (int i = 0; i < musicinfos.length; i++) {

            StringBuilder radio = new StringBuilder();

            // melody를 재생 시간만큼 돌린다.
            for (int j = 0; j < time[i]; j++) {
                radio.append(melody[i].charAt(j % melody[i].length()));

            }

            if(radio.toString().contains(m) && play < time[i]) {
                answer = title[i];
                play = time[i];
            }
        }
        System.out.println(answer);

        return answer;
    }

    // 치환
    static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("E#", "J");
        oldMelody = oldMelody.replaceAll("F#", "K");
        oldMelody = oldMelody.replaceAll("G#", "L");
        oldMelody = oldMelody.replaceAll("B#", "O");


        String newMelody = oldMelody.replaceAll("A#", "M");

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
//        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        // Test case 4: "HELLO"
//        String m = "CDCDF";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDCDCDF", "13:00,13:59,WORLD,AA"};

        // Test case 5: "HELLO"
        String m = "CDCDF";
        String[] musicinfos = {"23:00,00:00,HELLO,CDCDCDF"};

        // https://school.programmers.co.kr/questions/20698
        // 27, 30번 반례
        System.out.println(solution(m, musicinfos));
    }
}