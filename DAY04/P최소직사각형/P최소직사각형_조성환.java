package P폰켓몬;

public class P최소직사각형 {
	class Solution {
	    public int solution(int[][] sizes) {
	    	int wid = 0;
	    	int hei = 0;
	    	for(int i = 0, k = sizes.length;i < k ; i ++) {
	    		if(sizes[i][0] > sizes[i][1]) {
	    			if(wid < sizes[i][0]) {	    				
	    				wid = sizes[i][0];
	    			}if(hei < sizes[i][1]) {	    				
	    				hei = sizes[i][1];
	    			}
	    		}else {
	    			if(wid < sizes[i][1]) {	    				
	    				wid = sizes[i][1];
	    			}if(hei < sizes[i][0]) {	    				
	    				hei = sizes[i][0];
	    			}
	    		}
	    	}
	    	
	        int answer = wid * hei;
	        return answer;
	    }
	}
}
