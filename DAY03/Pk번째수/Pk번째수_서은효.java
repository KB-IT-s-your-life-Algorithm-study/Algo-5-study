package Pk번째수;

import java.util.Arrays;

public class Pk번째수_서은효 {
	
	static int index;
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer;
        //[[2, 5, 3], [4, 4, 1], [1, 7, 3]]
        answer = new int[commands[0].length];

        for(int i =0,len= commands[0].length ; i<len;i++) {
        	
        	int first = commands[i][0];
        	int last = commands[i][1];
        	int k = commands[i][2];
        	
        	int [] arr = new int[last - first + 1];
        	
        	for(int j = first-1, p=0; j<last;j++,p++) {
        		arr[p] = array[j]; 	
        	}
        	
        	Arrays.sort(arr);
        	
        	answer[i] = arr[k-1];
        	
        }
        
        return answer;
    }

    public static void main(String[] args) {
		int arr [] = {1, 5, 2, 6, 3, 7, 4};
		int com [][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int s[] = solution(arr, com);
	
	}

}
