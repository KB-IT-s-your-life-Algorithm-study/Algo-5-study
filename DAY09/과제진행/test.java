package 과제진행;

public class test {
	public static void main(String[] args) {
		
//		String[] arr = new String[] {"a","b","c"};
//		int[] a = new int[] {2,1,6};
		String a = "String";
//		int k = 3;
//		double a = 14.123;
//		int a = 10;

		System.out.println(solution(a));
	}

    static String solution(String myString) {
        String answer = "";
        
        char a = 'a';
        char A = 'A';
        int gap = (int)a - (int)A;
        
        
        for(int i = 0 ; i < myString.length() ; i++) {
        	if((int)myString.charAt(i) < (int)a) {
        		answer += (char)(gap+(int)myString.charAt(i));
        	}else {
        		answer += myString.charAt(i);
        	}
        }
        
        return answer;
    }
        
}
