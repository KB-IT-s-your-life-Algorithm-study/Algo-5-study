import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();

        for(String phone_number : phone_book) {
            set.add(phone_number);
        }

        for(String phone_number : phone_book) {
            for (int i = 1; i < phone_number.length(); i++) {
                if (set.contains(phone_number.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}