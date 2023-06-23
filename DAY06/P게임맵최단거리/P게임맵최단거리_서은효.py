from collections import deque


def BFS(n,m,maps):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    queue = deque()
    queue.append((0,0))#처음 시작

    while queue:
        x,y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0<=nx<n and 0<=ny<m and maps[nx][ny]==1: #검증
                queue.append((nx,ny)) #큐에 다시 저장
                maps[nx][ny] = maps[x][y] + 1 #DP

    if maps[n-1][m-1] == 1: #만약 n-1,m-1(목표지)가 1인 경우
        return -1 #목표지가 1이라면 목표지까지 더해가며 도달하지 못했다는 뜻
    else:
        return maps[n-1][m-1] #그렇지 않다면 더해온 값을 리턴 

def solution(maps):
    n = len(maps) #행
    m = len(maps[0]) #열
    answer = BFS(n,m,maps) #배열의 크기와 배열
    return answer


print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))
