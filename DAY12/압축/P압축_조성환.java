package 압축;

import java.util.*;

public class P압축_조성환 {
    // 해쉬맵 선언 (중복 방지)
	HashMap<String, Integer> dict = new HashMap<>();
	
    public int[] solution(String msg) {
        int[] answer;
        
        // 리스트 선언
        ArrayList<Integer> ans = new ArrayList<>();        
        
        int dictIdx = 1;
        
        // dict 생성(A~Z)
        for(int i='A'; i<='Z'; i++){
            dict.put( String.valueOf((char)i), dictIdx++) ;
        }
       
        int idx = 0;
        
        // 주어진 msg길이 만큼
        while(idx < msg.length()){
            String w = "";
            while(idx < msg.length()){
                // dict에 존재하지 않는다면 break
            	if(!dict.containsKey(w+msg.charAt(idx))){
                    break;
                }else{
                    // 존재한다면 현재 마지막 인덱스 + 1
                	w += msg.charAt(idx);
                }
                idx++;
            }
            
            // 없는 단어 추가 
            ans.add(dict.get(w));
            if(idx < msg.length()){
                dict.put(w+msg.charAt(idx), dictIdx++);
            }            
        }
        
        // 답을 출력할 사전
        answer = new int[ans.size()];
        for(int i =0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
           
        return answer;
}
}
