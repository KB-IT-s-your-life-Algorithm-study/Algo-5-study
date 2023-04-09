package B1012유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1012유기농배추_서은효 {
	static int tk;
	static int width;
	static int height;
	static int k;
	static int [][] arr;
	static int [] dx = {-1, 1, 0, 0};
	static int [] dy = {0, 0 , -1, 1};

	
	public static void DFS(int x, int y) {
		arr[x][y] = 0;
		for(int i =0; i<4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 & nx < height && ny >=0 && ny < width) {
				if(arr[nx][ny] == 1) {
					DFS(nx, ny);
				}
				else 
					continue;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		tk = Integer.parseInt(bf.readLine()); //test case 
		StringTokenizer token;
		
		
		for(int t=0; t<tk; t++) {
			int cnt = 0;
			token = new StringTokenizer(bf.readLine());			

			width = Integer.parseInt(token.nextToken());		
			height = Integer.parseInt(token.nextToken());
			k = Integer.parseInt(token.nextToken());//배추 위치 
			arr = new int [height][width];
			
			for(int i = 0; i<k; i++) {
				token = new StringTokenizer(bf.readLine());
				int row = Integer.parseInt(token.nextToken());
				int col =  Integer.parseInt(token.nextToken());
				arr[col][row] = 1;
			}
			for(int i =0; i<height; i++) {
				for(int j = 0; j<width; j++) {
					if(arr[i][j] == 1) {
						DFS(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
		

		
		
		
//		for(int i =0; i<height; i++) {
//			for(int j = 0; j<width; j++) {
//				System.out.print(arr[i][j]);
//			}System.out.println();
//		}
	
		
		
		
		
		
		
		
		
	}
}
