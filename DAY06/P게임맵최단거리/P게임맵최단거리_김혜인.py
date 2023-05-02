from collections import deque

## maps 매개변수로 빈 deque queue 생성 
def bfs(maps):
    cnt = 1
    queue = deque()
    max_x = len(maps)  ##차수 결정
    max_y = len(maps[0])
    queue.append([max_x-1, max_y-1, cnt])
    maps[max_x-1][max_y-1] = 0
    
    ##움직이는 요소
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]
    
    while queue:
        x, y, cnt = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx == 0 and ny == 0: ##map이 0이 아닌지 확인함 > 방문하지 않느 경로 탐색하기
                return cnt + 1
            if 0 <= nx < max_x and 0 <= ny < max_y:
                if maps[nx][ny] != 0:  ##위의 조건 만족하면 새로운 맵 값 설정되면 > 새로운 좌표
                    maps[nx][ny] = 0
                    queue.append([nx, ny, cnt+1])

    return -1
#위의 조건 반복하지 않으면 루프 반복  >> 대상 경로 없으면 유효한 경로가 없ㅇ늬까 -1반환
def solution(maps):
    answer = bfs(maps)
    return answer
