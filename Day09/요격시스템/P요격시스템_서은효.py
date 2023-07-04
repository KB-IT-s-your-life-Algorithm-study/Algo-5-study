def solution(targets):
    answer = 1

    # 1. (s,e) 중 e를 기준으로 정렬
    #[[1, 4], [4, 5], [3, 7], [4, 8], [5, 12], [11, 13], [10, 14]]와 같이 뒷자리를 기준으로 정렬
    #targets[i][1]가 정의해놓은 targets[i-1][0]에 포함되는지 확인하면 됨
    targets.sort(key=lambda x:x[1])

    # 2. (s,e)를 초기화
    s = targets[0][0]
    e = targets[0][1]

    # 3. # 1과 같은 기준으로 성립되지 않는 경우 +1 -> 총 몇개의 미사일이 필요한지 알 수 있음 
    for i in range(1, len(targets)):
        if not e > targets[i][0]:
            #print(targets[i],"에서 answer + 1 ")
            answer += 1
            s = targets[i][0]
            e = targets[i][1]

    return answer


print(solution([[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]))