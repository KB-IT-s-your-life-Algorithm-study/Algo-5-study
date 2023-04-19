package P폰켓몬;

import java.util.ArrayList;
import java.util.List;

public class P모의고사 {
	class Solution {
		public int[] solution(int[] answers) {
			int[] stu1 = new int[] { 1, 2, 3, 4, 5 };
			int[] stu2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
			int[] stu3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
			
			int[] score = new int[] {0,0,0};

			
			for(int i = 0, k = answers.length ; i < k;i++) {
				if(answers[i] == stu1[i%5]) {
					score[0] += 1;
				}
				if(answers[i] == stu2[i%8]) {
					score[1] += 1;
				}
				if(answers[i] == stu3[i%10]) {
					score[2] += 1;
				}
			}
			
			int max = 0;
			for(int i = 0 ; i < 3 ;i++) {
				if(max < score[i]) {
					max = score[i];
				}
			}
			
			List<Integer> ans = new ArrayList<Integer>();
			
	        for(int i=0; i<score.length; i++) {
	        	if(max == score[i]) {
	        		ans.add(i+1);
	        	}
	        }
	        
	        int[] answer = new int[ans.size()];
	        for(int i=0; i<ans.size(); i++){
	            answer[i] = ans.get(i);
	        }
			

			return answer;
		}
	}

	public static void main(String[] args) {

	}

}
