import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(Map.Entry<String, Integer> entrySet : map.entrySet()) {
            answer *= (entrySet.getValue() + 1);
        }

        return answer - 1;
    }
}