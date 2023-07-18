import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> arrayList = new ArrayList<>();

        if(cacheSize == 0) return cities.length * 5;

        for (String city : cities) {
            city = city.toUpperCase();

            // 캐시에 data가 있음. (Hit)
            if(arrayList.contains(city)) {
//                arrayList.indexOf(city);
                arrayList.remove(city); // remove는 city가 있는 인덱스를 찾아서 지워준다.
                arrayList.add(city);
                answer += 1;
            } else {
                if(arrayList.size() == cacheSize) {
                    arrayList.remove(0);
                }
                arrayList.add(city);
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test case 1 : 50
//        int cacheSize = 3;
//        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        // Test case 2 : 21
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        solution(cacheSize, cities);
    }
}