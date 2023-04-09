import java.util.*;


class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = nums.length/2;
            
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        if(count>set.size()){
            answer = set.size();
        }
        else answer = count;    

        return answer;
    }
}
