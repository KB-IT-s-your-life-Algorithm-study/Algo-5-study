def solution(sizes):
    # 초기화
    w = max(sizes[0][0], sizes[0][1])
    h = min(sizes[0][0], sizes[0][1])

    for i in range(len(sizes)):
        # 가로를 큰 값, 세로를 작은 값으로 세팅
        a = max(sizes[i][0], sizes[i][1])
        b = min(sizes[i][0], sizes[i][1])
        sizes[i][0] = a
        sizes[i][1] = b

        w = max(w, sizes[i][0])
        h = max(h, sizes[i][1])

    answer = w*h
    return answer