package 두원사이;

import java.util.*;

// 망할 이과식 문제 원의 반지름 이런거도 아니네 ㅡ,ㅡ
public class P두원사이_조성환 {
	public static void main(String[] args) {

		int r1 = 2;
		int r2 = 4;

		System.out.println(solution(r1,r2));
	}

	static long solution(int r1, int r2) {
        long answer = 0;
        
        // 한 분면씩 나올 수 있는 정수 갯수 구하기
        for (int i = 1; i < r2; i++) {
            if (i < r1) {
                answer += getMaxY(i, r2, "r2") - getMaxY(i, r1, "r1");
            } else {
                answer += getMaxY(i, r2, "r2");
            }
        }
        answer *= 4;
        answer += (r2 - r1 + 1) * 4;
        return answer;
    }
	
	// x축별로 최대 y값을 가져오기
    static int getMaxY(long x, long r, String rName) {
    	// 킹타고라스 정리로 x 축 별로 최대로 가질 수 있는 점의 개수
        double max = Math.sqrt(r * r - x * x);
        
        //의 최대
        int maxToInt = (int) max;
        
        // r1일때 기준 0,0은 하나 빼주기
        if (rName.equals("r1") && max - maxToInt == 0.0) {
            return maxToInt - 1;
        } else {
            return maxToInt;
        }
    }
}
