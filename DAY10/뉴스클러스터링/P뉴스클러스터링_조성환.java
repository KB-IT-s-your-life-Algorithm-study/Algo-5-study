package 뉴스클러스터링;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P뉴스클러스터링_조성환 {
	public static void main(String[] args) {

		String arr1 = "aa1+aa2";
		String arr2 = "AAAA12";

		System.out.println(solution(arr1, arr2));
	}
	static String rep(String a) {
		// 대문자 변환
		String st = a.toUpperCase();
        // 특수문자제거(영대문자 + 숫자를 제외한 모든 문자)
        String match = "[^A-Z]";
        st = st.replaceAll(match, " ");
		return st;
	}
	static int solution(String str1, String str2) {
		// 최대
        int answer = 65536;
        
        // 문자 정리
        String st1 = rep(str1);
        String st2 = rep(str2);
        
        // 2글자씩 배열
        List<String> str1_arr = new ArrayList<String>();
        List<String> str2_arr = new ArrayList<String>();
        
        // 자르기
        for(int i = 0 ; i < str1.length() - 1 ; i++ ) {
        	String word = "";
        	if(st1.charAt(i) == ' ' || st1.charAt(i+1) == ' ') {
        		continue;
        	}
        	word += st1.charAt(i);
        	word += st1.charAt(i+1);
        	if(!str1_arr.contains(word)) {        		
        		str1_arr.add(word);
        	}
        }
        
        for(int i = 0 ; i < st2.length() - 1 ; i++ ) {
        	String word = "";
        	if(st2.charAt(i) == ' ' || st2.charAt(i+1) == ' ') {
        		continue;
        	}
        	word += st2.charAt(i);
        	word += st2.charAt(i+1);
        	if(!str2_arr.contains(word)) {        		
        		str2_arr.add(word);
        	}
        }
        
        List<String> match = new ArrayList<String>();
        List<String> all = new ArrayList<String>();
        
        for(int i = 0 ; i < str1_arr.size() ; i++ ) {
        	if(str2_arr.contains(str1_arr.get(i))) {
        		if(!match.contains(str1_arr.get(i))) {        			
        			match.add(str1_arr.get(i));
        		}
        	}
        	if(!all.contains(str1_arr.get(i))) {        			
    			all.add(str1_arr.get(i));
    		}
        }
        for(int i = 0 ; i < str2_arr.size() ; i++ ) {
        	if(str1_arr.contains(str2_arr.get(i))) {
        		if(!match.contains(str2_arr.get(i))) {        			
        			match.add(str2_arr.get(i));
        		}
        	}
        	if(!all.contains(str2_arr.get(i))) {        			
    			all.add(str2_arr.get(i));
    		}
        }
        answer = answer / all.size() * match.size();
        
        return answer;
    }
}
