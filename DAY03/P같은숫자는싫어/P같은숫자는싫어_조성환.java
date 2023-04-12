package P같은숫자는싫어;

import java.util.*;

public class P같은숫자는싫어_조성환 {
    public int[] solution(int []arr) {
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        
        for(int i = 0 ; i < arr.length ; i++) {
        	if(st.peek() != arr[i]) {
        		st.push(arr[i]);
        	}
        }
        int[] answer = new int [st.size()];
        for(int i = st.size() -1 ; i > -1 ; i--) {
           answer[i] = st.pop();
        }
        return answer;
    }
}