
import java.util.HashMap;


class Solution {
    public String solution(String[] participant, String[] completion) {
         String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int par_len = participant.length;
        int com_len = completion.length;
 
        for(String n : participant){
            
            if(map.containsKey(n)){
                map.put(n, map.get(n) +1);
            }
            else
                map.put(n,  1);
        }

       
        for (String n : completion){
            if(map.containsKey(n)){
                map.put(n,map.get(n) -1 );
            }
        }
        
        for(String n : participant){
            if(map.get(n) != 0)
                answer = n;
        }
        return answer;
    }
}