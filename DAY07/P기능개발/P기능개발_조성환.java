package P기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P기능개발_조성환 {

	public static void main(String[] args) {
		int[] progresses = new int[] {1, 1, 1, 1};
		int[] speeds = new int[] {100, 50, 99, 100};
		
		solution(progresses, speeds);

	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
    	// Queue
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	// 앞 부터 완성되는 날짜를 큐에 add
    	for(int i = 0 ; i < progresses.length ; i++) {
    		// 완성되는 날짜 
    		int a = (100 - progresses[i]) / speeds[i];
    		// 나머지가 있다면 하루 추가 (작업량이 남았다면 하루 추가)
    		if((100 - progresses[i]) % speeds[i] > 0) {
    			a += 1;
    		}
    		// q에 추가
    		q.add(a);
    	}
    	
    	// 답을 담을 리스트
    	List<Integer> lst = new ArrayList<>();
    	
    	// 빌 때까지 반복문
    	while(q.size() > 0) {
    		// 한 번에 배포되는 프로그램의 수
    		int a = 1;
    		// 배포 최소 1개
    		int poll_num = q.poll();
    		// q가 비어있지 않으면 다음 수를 체크할 필요가 없다. 
    		if(q.size() > 0) {    		
    			// 다음 프로그램이 배포 가능한지 확인
    			while(poll_num >= q.peek()) {
    				// 한 번에 배포되는 프로그램 수 추가 
    				a += 1;
    				// 큐에서 제거
    				q.poll();
    				// q가 빈다면 종료
    				if(q.size() == 0) {
    					break;
    					
    				}
    			}
    		}
    		// 배포
    		lst.add(a);
    	}
    	
    	// 답에 맞는 형식(배열)로 변환
    	int[] answer = new int[lst.size()];
    	for(int i = 0 ; i < lst.size() ; i++) {
    		answer[i] = lst.get(i);
    	}
        return answer;
    }

}
