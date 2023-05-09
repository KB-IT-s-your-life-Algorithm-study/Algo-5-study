package P프린터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;

public class P프린터_조성환 {

	public static void main(String[] args) {
		int[] priorities = new int[] { 2, 1, 3, 2 };
		int location = 2;

		solution(priorities, location);

	}

	public static int solution(int[] priorities, int location) {
		
		int answer = 0;
		
		// 우선순위와 현재 위치(location)를 큐에 넣는다.
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		
		// 우선 순위를 큰 순서대로 넣을 리스트
		List<Integer> arr = new ArrayList<Integer>();
		
		// 값을 큐와 리스트에 담는다. 
		for(int i = 0; i < priorities.length ; i++) {
			q1.add(priorities[i]);
			q2.add(i);
			arr.add(priorities[i]);
		}
		
		// 내림차순 정렬
		Collections.sort(arr,Collections.reverseOrder());
		
		// 우선순위가 큰 순서대로 찾는다.
		for(int i = 0 ; i < arr.size() ; i++) {
			// 우선순위가 나오는대로 큐에서 poll
			while(true) {
				// q의 첫번째 값을 꺼낸다.
				int n1 = q1.poll();
				int n2 = q2.poll();
				// 우선순위가 가장 높을 때
				if(n1 == arr.get(i)) {
					// 위치에 있는 숫자면 답을 구하고 나온다.
					if(n2 == location) {
						answer = i + 1;
						break;
					// 아니면 그냥 나온다.
					}else {
						break;
					}
				// 우선순위가 우선되지 않으면 값을 다시 큐에 넣는다. 
				}else {
					q1.add(n1);
					q2.add(n2);
				}
			}
		}
		System.out.println(answer);
		return answer;
	}
	
}
