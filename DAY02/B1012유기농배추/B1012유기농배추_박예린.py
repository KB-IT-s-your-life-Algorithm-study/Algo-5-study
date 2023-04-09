from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]

T = int(input()) # Test case의 개수

def bfs(graph, a, b):
    queue = deque() # 탐색마다 새롭게 초기화
    queue.append((a,b))
    graph[a][b] = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]

            # 좌표가 범위를 넘어가지 않게 조건문 처리
            if next_x < 0 or next_x >= N or next_y < 0 or next_y >= M:
                continue
            
            # 배추를 발견하면, visited 대신 배추의 위치의 값을 0으로 변경한다.
            if graph[next_x][next_y] == 1:
                graph[next_x][next_y] = 0
                queue.append((next_x, next_y))
    return

# Test case만큼 반복
for i in range(T):
    count = 0 # BFS의 수행 횟수, 답

    '''
    배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50),
                        세로길이 N(1 ≤ N ≤ 50),
    배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)
    그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
    '''

    N, M, K = map(int, input().split())
    graph = [[0]*M for _ in range(N)] # Python의 2차원 배열 초기화


    # graph에 배추의 위치 초기화
    for j in range(K):
        x, y = map(int, input().split())
        graph[x][y] = 1

    for a in range(N):
        for b in range(M):
            # 배추가 있다면 bfs 수행
            if graph[a][b] == 1:
                bfs(graph, a, b)
                count += 1
    print(count)