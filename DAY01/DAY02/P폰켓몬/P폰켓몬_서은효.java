package DAY02.P폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int len = nums.length/2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int x: nums){
            set.add(x);
        }
        
        if(set.size() > len)
            return len;
        else 
            return set.size();
    }
}
