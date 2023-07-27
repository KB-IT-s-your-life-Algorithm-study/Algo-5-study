public class Solution {

    private int checkBlock(char[][] map, int m, int n){
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];  //블록 여부 확인
        
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                if(map[i][j] == '.') continue; // 블록이 없는 경우
                checkFour(map, isChecked, i, j);
            }
        }
        
        //2*2배열 만들기
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isChecked[i][j]) {
                    map[i][j] = '.'; // 삭제할 블록 표시
                    cnt++;  //삭제되면 개수 증가
                }
            }
        }
        
        return cnt;
    }
    
    // 지울 블록 조건 확인
    // 2*2 캍이 모두 같을 경우
    private void checkFour(char[][] map, boolean[][] isChecked, int r, int c){
        
        char block = map[r][c];
        
        for(int i = r; i < r + 2; i++){
            for(int j = c; j < c + 2; j++){
                if(map[i][j] != block) return;
            }
        }
        
        for(int i = r; i < r + 2; i++){
            for(int j = c; j < c + 2; j++){
                isChecked[i][j] = true;
            }
        }
        
    }
    
    //블록 지움 처리  <> 굳이 함수 안만들어도 될듯 성환오빠꺼 보니까 걍 큐로 지워벎
    public void dropBlock(char[][] map, int m, int n){
        for(int j = 0; j < n; j++){
            for(int i = m-1; i >= 0; i--){
                if(map[i][j] == '.'){
                    for(int ii = i - 1; ii >= 0; ii--){
                        if(map[ii][j] != '.'){
                            map[i][j] = map[ii][j];
                            map[ii][j] = '.';
                            break;
                        }
                    }
                }
            }

        }
    }
    //블록 정렬
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for(int i = 0 ; i < m ; ++i) {
            map[i] = board[i].toCharArray();
        }
        
        while(true){
            int cnt = checkBlock(map, m, n);
            if(cnt == 0) break; // 더이상 지울 블록 없는 경우
            answer += cnt;
            
            dropBlock(map, m, n);
        }
        
        return answer;
    }
}
