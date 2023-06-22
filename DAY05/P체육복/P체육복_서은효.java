import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
         Arrays.sort(lost);
		 Arrays.sort(reserve);

        
        for(int i =0,len=lost.length; i<len; i++){
	        for(int j=0,jlen=reserve.length; j<jlen; j++){
                if(lost[i] == reserve[j]) {
	                reserve[j] = -1; 
	                lost[i] = -1; 
	            }
	        }
	    }
        
        
        ////////////////////////////////////////////////
	        for(int i =0,len=lost.length; i<len; i++){
	            for(int j=0,jlen=reserve.length; j<jlen; j++){

	            	
	                if(lost[i] +1 == reserve[j] || lost[i] -1 == reserve[j]) {
	                    
	                    reserve[j] = -1; 
	                    lost[i] = -1; 
	                }
	                
	            }
	        }

	        int lost_cnt = 0;
	        for(int st : lost) {
	        	if (st != -1){
	        		lost_cnt++;
	        	}
	        }
	        
	        
	        int answer = n - lost_cnt;
	        return answer;
    }
}