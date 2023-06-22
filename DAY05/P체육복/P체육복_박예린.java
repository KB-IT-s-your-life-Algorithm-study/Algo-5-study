package P체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> lostList = new ArrayList<>();

        for(int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }

        ArrayList<Integer> reserveList = new ArrayList<>();

        for(int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }

        for(int i = 0; i < reserve.length; i++) {
            if(lostList.contains(reserveList.get(i))) {
                lostList.remove(lostList.indexOf(reserveList.get(i)));
                reserveList.remove(i);
            }
        }

        for(int i = 0; i < reserveList.size(); i++) {
            if(lostList.contains(reserveList.get(i) - 1)) {
                lostList.remove(lostList.indexOf(reserveList.get(i) - 1));
            } else if(lostList.contains(reserveList.get(i) + 1)) {
                lostList.remove(lostList.indexOf(reserveList.get(i) + 1));
            }
        }

        answer = n - lostList.size();

        return answer;
    }
}