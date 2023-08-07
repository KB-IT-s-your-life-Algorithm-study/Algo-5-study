package 방금그곡;

import java.util.*;

public class P방금그곡_조성환 {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        // 길이가 가장 긴 음악으로 선정해야하기 때문에
        int maxgap = 0;
        
        
        // 음악 나누기
        for (String music : musicinfos){
            String[] info = music.split(",");
            
            // 음악 길이 구하기
            int start = (Integer.parseInt(info[0].substring(0,2)) * 60) + 
                Integer.parseInt(info[0].substring(3,5));
            int end = (Integer.parseInt(info[1].substring(0,2)) * 60) + 
                Integer.parseInt(info[1].substring(3,5));
            int gap = end - start; 
            
            String title = info[2];
            String melody = info[3];
            
            // #이 붙은 계이름(2글자 소비 => 1글자) 변경 
            melody = melody.replaceAll("C#","H");
            melody = melody.replaceAll("D#","I");
            melody = melody.replaceAll("F#","J");
            melody = melody.replaceAll("G#","K");
            melody = melody.replaceAll("A#","L");
            
            // 찾을 음도 동일하게 변경 
            String new_m = m.replaceAll("C#","H");
            new_m = new_m.replaceAll("D#","I");
            new_m = new_m.replaceAll("F#","J");
            new_m = new_m.replaceAll("G#","K");
            new_m = new_m.replaceAll("A#","L");
            
            // 시간길이 만큼 음악 생성
            String music_melody = "";
            for (int i = 0; i < gap; i++){
                int k = i % melody.length();
                music_melody += melody.charAt(k);
            }
            
            // 찾을 음악 + 길이가 가장 길면 answer
            if (music_melody.contains(new_m) && gap > maxgap) {
                answer = title;
                maxgap = gap;
            }
        }
        
        // 없으면 none 출력
        if(answer == ""){
            return "(None)";
        }
        
        return answer;
    }
}
