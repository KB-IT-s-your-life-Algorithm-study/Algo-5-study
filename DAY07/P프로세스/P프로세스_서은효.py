import copy
from collections import deque

def solution(priorities, location):

    answer = 0

    que = deque()

    for i in range(len(priorities)):
        que.append([i, priorities[i]])
    print(que)

    count = 0

    while que:
        num = que.popleft()

        flag = True
        #for i in que -> que에 변경이 생기면 오류가 발생
        #que를 카피해서 반복문에 사용
        for i in copy.deepcopy(que):
            if num[1] < i[1]: #큐에 우선순위가 더 큰 것이 있다면 flag 바꾼 후 break
                que.append(num)
                flag = False
                break

        if flag: #큐에 더 큰 우선순위가 없었으므로 프로세스를 실행시킴
            count += 1

            if num[0] == location:
                answer = count


    return answer

print(solution([1, 1, 9, 1, 1, 1],0))