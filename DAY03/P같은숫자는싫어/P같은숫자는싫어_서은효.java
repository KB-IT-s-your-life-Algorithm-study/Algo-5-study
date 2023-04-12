package P같은숫자는싫어;

import java.util.Stack;

public class P같은숫자는싫어_서은효 {



    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for(int x : arr) {
        	if(stack.size() == 0)
        		stack.push(x);
        	if(stack.peek() != x ) {
        		stack.push(x);
        	}
        		
        }
        int[] answer = new int[stack.size()];
       
        
        for(int i =answer.length-1 ; i>=0; i--) {
        	 
        	answer[i] = stack.pop();
        }
        
        return answer;
       
    }


    public static void main(String[] args) {
	int arr2[] = {1,1,3,3,0,1,1};
	//System.out.println((arr2));
	
	System.out.println(solution(arr2));
}

}
