from collections import deque


def solution(cacheSize, cities):
    answer = 0
    que = deque()
    count = 0
    length = len(cities)

    if cacheSize == 0:
        answer = 5 * length
    else:
        for i in range(length):

            # 캐시가 꽉 찬 경우
            if len(que) == cacheSize:
                # 1. 현재 도시가 캐시 안에 있다면
                if any(cities[i].lower() in l for l in que):
                    index = 0
                    # cities[i]의 인덱스
                    for k in range(cacheSize):
                        if cities[i].lower() == que[k][1]:
                            index = k
                            break

                    # count +=1로 우선 순위를 가장 높이기
                    count += 1
                    que[index][0] = count
                    answer += 1

                # 2. 현재 도시가 캐시 안에 없다면
                else:
                    # 우선 순위가 가장 낮은 것을 지우고 대체, que[i][0]가 가장 낮은 것을 찾아야 함
                    min_priority = min(que)
                    que.remove(min_priority)
                    # 가장 높은 우선 순위로 대체 해줌
                    count += 1
                    que.append([count, cities[i].lower()])
                    answer += 5

            # 캐시가 비어 있는 경우
            else:
                # 1. 현재 도시가 캐시 안에 있다면
                if any(cities[i].lower() in l for l in que):
                    index = 0
                    # cities[i]의 인덱스
                    for k in range(cacheSize):
                        if cities[i].lower() == que[k][1]:
                            index = k
                            break

                    # count +=1로 우선 순위를 가장 높이기
                    count += 1
                    que[index][0] = count
                    answer += 1
                else:
                    count += 1
                    # 최근 사용 순위를 알 수 있는 count와 함께 append
                    que.append([count, cities[i].lower()])
                    answer += 5

    return answer


print(solution(5,
               ["jeju","jeju","jeju","jeju","jeju","jeju","jeju"]))
