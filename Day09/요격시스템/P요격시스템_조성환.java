package 요격시스템;

import java.util.Arrays;

public class P요격시스템_조성환 {
	public static void main(String[] args) {

		int[][] targets = new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

		System.out.println(solution(targets));
	}

    static int solution(int[][] targets) {
    	
    	// 일단 한 발 이상은 쏘니까
    	int answer = 1;
    	
    	// 오름차순 정렬
    	Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });
    	
    	
    	// 첫 번째 요격 위치
    	int line = targets[0][1];
    	
    	// 요격 위치에 겹치는 부분이 있으면 계속 진행, 없으면 새로운 요격 발사 
    	for(int i = 1 ; i < targets.length ; i++) {  
    		if(line > targets[i][0] && line <= targets[i][1]) {
    			continue;	
    		}
    		// 요격 미사일이 한 발 더 필요하면 발사 후 위치 조정
    		else {    		
    			answer += 1;
    			line = targets[i][1];
    		}
    	}
    	
        return answer;
    }
}
