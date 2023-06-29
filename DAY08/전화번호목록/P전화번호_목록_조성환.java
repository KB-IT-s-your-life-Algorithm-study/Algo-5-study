package 전화번호목록;

import java.util.HashMap;
import java.util.Map;

public class P전화번호_목록_조성환 {

	public static void main(String[] args) {

		String[] phone_book = new String[]{ "119", "97674223", "1195524421" };

		System.out.println(solution(phone_book));
	}

    static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 해시 선언
        Map<String, Integer> map = new HashMap<>();

        // 모든 전화번호를 담는다.
        for (int i = 0; i < phone_book.length; i++) 
            map.put(phone_book[i], i);
        
        // 반복문을 돌려 부분들이 안에 있는지 확인한다.
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 0; j < phone_book[i].length(); j++)
            	// 각 내용들이 해쉬 안에 존재하는지 확인
                if (map.containsKey(phone_book[i].substring(0, j))) {
                	// 없으면 false
                	answer = false;
                }
        
        return answer;
    }
}