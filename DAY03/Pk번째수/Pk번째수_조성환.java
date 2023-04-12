package Pk번째수;

import java.util.*;

public class Pk번째수_조성환 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    	int i ;
    	int j ;
    	int k ;
        for(int v = 0 ; v < commands.length;v++) {
        	i = commands[v][0];
        	j = commands[v][1];
        	k = commands[v][2];
        	int[] arr = new int[j - i + 1];
        	for(int l = 0 ; l < j - i + 1 ; l++) {
        		arr[l] = array[i + l - 1];
        	}
        	Arrays.sort(arr);
        	answer[v] = arr[k -1];
        }
        
        return answer;
    }
}