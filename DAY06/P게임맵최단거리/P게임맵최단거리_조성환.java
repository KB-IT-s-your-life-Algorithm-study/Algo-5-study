package P게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class P게임맵최단거리_조성환 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } };
		System.out.println(solution(arr));
	}
	
	// 높이와 넓이
	static int n, m;
	// 방문했는지 안했는지 확인하는 배열
	static boolean[][] isVisited;

	public static int solution(int[][] maps) {
		int answer = 0;
		
		// 높이와 넓이구하기 + 방문 배열 생성
		n = maps.length;
		m = maps[0].length;
		isVisited = new boolean[n][m];
		
		// 최단 거리 구하는 함수 실행
		searchMaze(maps);
		
		// 도착지에 최단거리 
		// 만약 최단거리가 1(1번이라도 움직였으면 2이기 때문에)이면 도착할 수 없는 것으로 간주(-1)
		if(maps[n - 1][m - 1] == 1) {
			answer = -1;
		}else {			
		answer = maps[n - 1][m - 1];
		}
		
		// 출력
		return answer;
	}

	//BFS
	static void searchMaze(int[][] maps) {
		// 선입 선출
		Queue<int[]> que = new LinkedList<>();
		// 델타 탐색
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		// 출발지점 add + 출발지점 방문등록(돌아오지 못하게)
		que.add(new int[] { 0, 0 });
		isVisited[0][0] = true;
		
		// !que.isEmpty() ==> 움직일 곳이 없다. 
		while (!que.isEmpty()) {
			// 현재 위치
			int[] nowNode = que.poll();
			// 현재 위치가 도착지면 return 
			if (nowNode[0] == n - 1 && nowNode[1] == m - 1) {
				return;
			}
			// 아니면 계속
			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int new_y = dy[i] + nowNode[0];
				int new_x = dx[i] + nowNode[1];
				// 범위를 벗어나지 않는 선에서 
				if (new_y >= 0 && new_y < n && new_x >= 0 && new_x < m) {
					// 방문하지 않았다면
					if (isVisited[new_y][new_x] != true && maps[new_y][new_x] == 1) {
						//방문처리
						isVisited[new_y][new_x] = true;
						// 이동 + 1 / 현재 위치 que에 추가
						maps[new_y][new_x] += maps[nowNode[0]][nowNode[1]];
						que.add(new int[] { new_y, new_x });
					}
				}
			}

		}

	}
}
