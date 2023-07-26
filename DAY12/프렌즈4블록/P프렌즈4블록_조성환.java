package 프렌즈4블록;

import java.util.*;

public class P프렌즈4블록_조성환 {
	// 블록이 있는지 없는지 확인을 위한 boolean 2중 배열 
	static boolean v[][];  
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 단어 2중 배열
        char copy[][] = new char[m][n]; 
        
        // board 복사 
        for(int i=0; i<m ; i++){
            copy[i] = board[i].toCharArray();
        }
        
        // 
        boolean flag = true;
        while(flag){
             v = new boolean[m][n];
            flag = false;
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                	// 빈칸 이라면 다시
                    if(copy[i][j] == '#') {
                    	continue; 
                    }
                    // 2*2 체크(4개가 모두 같다면 true)
                    if(check(i,j,copy)){   
                        v[i][j] = true;
                        v[i][j+1] = true;
                        v[i+1][j] = true;
                        v[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            // 지워진 숫자만큼 +
            answer += erase(m,n,copy);
            v = new boolean[m][n];
        }
        return answer;
    }
    
    // 2 * 2가 같은 배열이라면
    public static boolean check(int x, int y, char[][] board){
        char ch = board[x][y];
        // 2*2 칸이 모두 같다면 true  
        if(ch == board[x][y+1] && ch== board[x+1][y] && ch == board[x+1][y+1]){
            return true;
        }
        return false;
    }
    
    // 같은 블록 제거
    public static int erase(int m, int n, char[][] board){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(v[i][j]) 
                    board[i][j] = '.';
            }
        }
        
        /* 큐를 이용해 세로로 제거 작업 진행 */
        for(int i=0; i < n; i++){
        	// 이거 왜 char 아니고 character임?
            Queue<Character> q = new LinkedList<>();
            // 지우는 블록 카운트 + 1
            for(int j = m - 1 ; j >= 0 ; j--){
                if(board[j][i] == '.'){ 
                	cnt++;  
                }else{
                    q.add(board[j][i]);
                }
            }
            int idx=m-1;
            // 비어있다면 삭제한 블록 위의 블록들 내리기
            while(!q.isEmpty()){
                board[idx--][i] = q.poll();
            }
            // 빈칸 채우기
            for(int j = idx ; j >= 0; j--){
                board[j][i] = '#';
            }
        }
 
        return cnt;
    } 
}
