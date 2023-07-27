from collections import deque

def solution(cacheSize, cities):
    answer = 0
    cache = deque(maxlen=cacheSize)
    if cacheSize == 0:  # 캐시 크기가 0일 때
        return len(cities) * 5

    for c in cities:
        c = c.lower()  # 대소문자 구분하지 않기 위해 모두 소문자로 변경
        if c in cache:  
            answer += 1
            cache.remove(c)  # 데이터 삭제
        else: 
            answer += 5
        cache.append(c)
    return answer
