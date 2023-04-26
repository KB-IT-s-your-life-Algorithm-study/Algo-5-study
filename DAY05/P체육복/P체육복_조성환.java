package tset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P체육복_조성환 {

	public static void main(String[] args) {

		int n = 5;
		int[] lost = new int[] {2,4};
		int[] reserve = new int[] {3};
		
		System.out.println(solution(n, lost, reserve));
	}
	
	 public static int solution(int n, int[] lost, int[] reserve) {
		 	
		 	// 결국 체육복을 못 빌린 사람의 수
		 	int no_wear = 0;	
		 	// 체육복이 필요한 사람
		 	List<Integer> lost_man = new ArrayList<>();
		 	// 체육복이 남는 사람
		 	List<Integer> sub_man = new ArrayList<>();
		 	
		 	// 옷 상태
		 	int[] wear_on = new int[n+1];
		 	
		 	// 정렬
		 	Arrays.sort(lost);
		 	Arrays.sort(reserve);
		 	
		 	// 여벌 옷이 있는 사람
		 	for(int i = 0 ; i < reserve.length ; i++) {
		 		wear_on[reserve[i]] += 1;
		 	}
		 	
		 	// 훔쳐진 사람
		 	for(int i = 0 ; i < lost.length ; i++) {
		 		// 여벌이 있으면 입는다.
		 		if(wear_on[lost[i]] != 0) {		 			
		 			wear_on[lost[i]] -= 1;
		 		// 없으면 없는 사람으로
		 		}else {
		 			lost_man.add(lost[i]);
		 		}
		 	}
		 	
		 	// 여벌이 있는 사람
		 	for(int i = 0 ; i < n+1 ; i++) {
		 		if(wear_on[i] == 1) {
		 			sub_man.add(i);
		 		}
		 	}
		 	
		 	// 만약 체육복이 없는 사람이 빌릴 여벌이 없다면 명 수 체크
		 	for(int i = 0 ; i < lost_man.size() ; i++) {
		 		int num1 = sub_man.indexOf(lost_man.get(i) - 1);
		 		int num2 = sub_man.indexOf(lost_man.get(i) + 1);
		 		
		 		// 1씩 작거나 클 때 여벌이 있는지 체크 (else > 여벌이 있다.)
		 		if(num1 == -1) {
		 			// 둘 다 없는 경우 체크
		 			if(num2 == -1) {
		 				no_wear += 1;
		 			// 만약 존재시 여벌 리스트에서 삭제
		 			}else {
		 				sub_man.remove(num2);
		 			}
		 		}else {
		 			sub_man.remove(num1);
		 		}
		 	}
		 	
		 	// 전체 인원에서 빼기
	        int answer = n - no_wear;
	        return answer;
	    }


}
