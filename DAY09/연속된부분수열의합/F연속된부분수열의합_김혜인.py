def solution(elements):
    sum_unique = set()
    # 성분 개수
    for n in range(len(elements)):
        # 시작점
        for i in range(len(elements)):
            # 배열의 길이 초과할 경우
            if n + i > len(elements):
                e_sum = sum(elements[i:]) + sum(elements[:i + n - len(elements)])
            else:
                e_sum = sum(elements[i:i + n])
            sum_unique.add(e_sum)
    return len(sum_unique)
 

## 끝점의 index 범위 초과하는 경우를 코딩을 못함. 구글링하여 그림그려진걸 보고 이해함.
