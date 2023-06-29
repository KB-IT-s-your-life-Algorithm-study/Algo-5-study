package 가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class P가장_큰_수_조성환 {

	public static void main(String[] args) {

		int[] numbers = new int[] {6, 10, 2};

		System.out.println(solution(numbers));
	}

	static String solution(int[] numbers) {

		String answer = "";
		
		// String 배열을 담을 배열 생성
		String[] str = new String[numbers.length];

		// String으로 변환
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }    
        
    	//두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬) >> 3 이랑 31 중에 3이 앞으로 가도록
    	Arrays.sort(str, new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			return (o2+o1).compareTo(o1+o2);
    		}
    	});
    	
    	// 뜬금 맨 앞이 0이면? 0출력 
    	if(str[0].equals("0")) {
    		return "0";
    	}
        answer = String.join("", str);
	
		return answer;

	}
}
