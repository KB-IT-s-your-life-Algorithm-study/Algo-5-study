from collections import deque

N = int(input()) # 컴퓨터 대수
V = int(input()) # 연결선 개수
graph = [[] for i in range(N+1)] # 그래프 초기화
visited = [0]*(N+1) # 방문 여부

# 그래프 초기화
for i in range(V):
    a, b = map(int, input().split())
    graph[a] += [b]
    graph[b] += [a]

# 1번 컴퓨터가 웜 바이러스에 걸림.
visited[1] = 1

'''
deque(iterable, [, maxlen])
: 초기화 함수. iterable(리스트 등)을 인자로 건네면 이를 deque화 시켜준다.
-> deque에 원소 1을 갖는 리스트로 초기화 함.
'''
dq = deque([1])

# BFS 탐색
while dq:
    now = dq.popleft()

    for i in graph[now]:
        if visited[i] == 0:
            visited[i] = 1
            dq.append(i)

print(sum(visited) - 1) # 1번 컴퓨터를 제외한 웜 바이러스에 걸리게 되는 컴퓨터의 수