package P타겟넘버;

public class P타겟넘버_조성환 {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1};
		System.out.println(solution(arr,3)); 
	}
	
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        // 함수 실행
        answer = DFS(numbers, target, 0);
        return answer;
    }
    
    static int DFS(int[] numbers, int target,int depth) {
    	int answer = 0;
    	// 마지막까지 탐색했다면 return
    	if(depth == numbers.length) {
    		int tot = 0;
    		// 만약 길이 == 답이면 방법은 1가지뿐
    		for(int i = 0 ; i < numbers.length ; i++) {
    			tot += numbers[i];
    		}
    		if(tot == target) {
    			return 1;
    		// 답 return
    		}else {
    			return 0;
    		}
    	}else {
    		// +일 때 재귀
	        answer += DFS(numbers, target, depth+1);
	        // - 일 때 재귀
	        numbers[depth] *= -1;
	        answer += DFS(numbers, target, depth+1);
	        // depth + 1한 값 return
    		return answer;
    	}
    }
}
