package 의상;

import java.util.*;

public class P의상_조성환 {

	public static void main(String[] args) {

		String[][] clothes = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
	
    static int solution(String[][] clothes) {
    	// 옷은 최소 한 벌
    	int answer = 1;
    	
    	// 중복방지 해시맵 생성
    	Map<String, Integer> map = new HashMap<>();
    	
    	// 반복문으로 종류 : 갯수
    	for(int i = 0; i < clothes.length; i++) {
    		// 처음이면 1로 put
			if(map.get(clothes[i][1]) == null) {
				map.put(clothes[i][1], 1);
			}
			// 존재면 +1
			else {
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			}
		}
    	
    	for(String s : map.keySet()) {
			//옷의 개수 + 옷을 고르지 않는 경우
			answer *= (map.get(s) + 1);
		}
		//옷을 하나도 고르지 않는 경우 -
		answer = answer - 1;
    	
        return answer;
    }
}
