package P조이스틱;

public class P조이스틱_조성환 {

	public static void main(String[] args) {

		String name = "JEROEN";
		
		System.out.println(solution(name));
	}
	
    public static int solution(String name) {
    	int answer = 0;
    	// 좌우 최대 이동횟수
    	int move_side = name.length() - 1;
    	
    	// 단어 길이 - 1 만큼 좌우 이동
    	for(int i = 0 ; i < name.length(); i++) {
    		// 왼쪽으로 이동 vs 우측으로 이동 (작은거 선택)
    		// 아스키코드를 이용해 알파벳(= 'A' + 본인 숫자까지의 거리) - 'A' = 본인 숫자까지의 거리
    		// 반대의 경우 26(알파벳 갯수) - 왼쪽으로의 거리 
    		answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
    		
    		// 다음 인댁스 부터 탐색
    		int indexA = i + 1;
    		
    		// 같은 글자라면 패스 
			while(indexA < name.length() && name.charAt(indexA) == 'A') {
				indexA++;
			}
			// i+i > 연속된 A문자열이 시작하기 전까지 갔다가 되돌아옴
			move_side = Math.min(move_side, i + i + name.length() - indexA);
			move_side = Math.min(move_side, (name.length() - indexA) * 2 + i);
		}
        
    	// 총 숫자
        return answer + move_side ;
    }
}