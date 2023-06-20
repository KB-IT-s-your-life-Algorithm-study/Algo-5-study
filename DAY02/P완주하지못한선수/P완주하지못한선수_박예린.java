package P완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

class P완주하지못한선수_박예린 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }


        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(!entry.getValue().equals(0)) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));

    }
}