def solution(targets):
    answer = 0
    targets.sort(key=lambda x:x[1])
    answer = 0
    end = -1  # 마지막으로 요격한 미사일
  
##for문 돌리면서 s가 이전 미사일 e와 같거나 큰 경우 요격x 
    for s, e in targets:
        if s >= end:  # 이전에 요격한 미사일로는 현재 미사일을 요격할 수 없는 경우
            answer += 1
            end = e  # 현재 미사일을 요격함으로써 끝나는 지점을 좌표를 업데이트 해준다.
    return answer
