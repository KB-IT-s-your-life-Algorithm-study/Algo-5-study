package P게임맵최단거리;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class P게임맵최단거리_서은효 {

	static boolean isVistied[][];
	static int [] dx = {1,0,-1,0};
	static int [] dy = {0,1,0-1};
	
	
	public static boolean check(int x, int y) {
		if(x<0 || x>=5 || y<0 || y>=5) return false;
		else return true;
	}
	
	public static void BFS(int x, int y, int [][] map) {
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int [] {x,y});
	
		while(!que.isEmpty()){
			int[] now = que.poll();
			int nowx = now[0];
			int nowy = now[1];
			
			for(int i=0; i<4; i++) {
				int next_x = nowx + dx[i];
				int next_y = nowy + dy[i];
				
				if(!check(next_x, next_y)
						|| map[next_x][next_y] == 0
						|| isVistied[next_x][next_y]) {
					continue;
				}
				que.add(new int[] {next_x, next_y});
				map[next_x][next_y] = map[now[0]][now[1]] +1;
				isVistied[next_x][next_y] = true;
			}
			

			
		}
		
		
		
	}
	
    public static int solution(int[][] maps) {
        int answer = 0;
        
    	isVistied = new boolean [5][5];
    	isVistied[0][0] = true;
    	
    	BFS(0,0, maps);
    	answer = maps[4][4];
        return answer;
        
        
    }
    public static void main(String[] args) throws IOException {
    	int [][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    	int result = solution(map);
    	System.out.println(result);
    }
}
