package 캐시;

import java.util.Arrays;
import java.util.LinkedList;

public class P캐시_조성환 {
	public static void main(String[] args) {

		String[] cities = new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println(solution(3,cities));
	}

	static int solution(int cacheSize, String[] cities) {
		// 캐시가 뭔데 씹덕아
		int answer = 0;
		
		// 캐시 사이즈가 0이 되면
        if(cacheSize == 0)
            return cities.length*5;
        
        // 알고리즘으로 구하랍니다. 
        LinkedList<String> cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            String s = cities[i].toUpperCase();
            if(cache.remove(s)){
                answer += 1;
                cache.add(s);
            }else{
                answer += 5;
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
                cache.add(s);
            }
        }
        return answer;
    }
    
}
