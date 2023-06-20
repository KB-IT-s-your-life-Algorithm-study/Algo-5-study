import java.util.*;

class P게임맵최단거리_박예린 {
    static int[][] visited;
    static int M;
    static int N;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    
    static boolean checkValid(int x, int y) {
        if(x < 0 || x >= M || y < 0 || y >= N) return false;
        return true;
    }

    static void BFS(int[][] maps) {
        Queue<int[]> que = new ArrayDeque<int[]>();
        
        que.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!que.isEmpty()) {
            int[] now = que.remove();
            int y = now[0];
            int x = now[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!checkValid(ny, nx)) {
                	continue;	
                }
                if(visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    que.add(new int[]{ny, nx});
                }
                    
            }
        }
    }
    
    public static int solution(int[][] maps) {
        int answer = 0;
        
        M = maps.length;
        N = maps[0].length;
        visited = new int[M][N];
            
        BFS(maps);        
        answer = visited[M-1][N-1] == 0 ? -1 : visited[M-1][N-1];        
        
        return answer;
    }
}