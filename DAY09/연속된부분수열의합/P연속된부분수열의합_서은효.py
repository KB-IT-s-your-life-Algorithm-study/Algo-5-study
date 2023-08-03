

def solution(sequence, k):
    answer = []

    # 1. sequence 길이
    length = len(sequence)
    # 2. 앞으로 더해질 합
    n = sequence[0]
    # 3. 마지막 인덱스가 어디인 지 알기 위한 것
    idx = 0

    # 4. 인덱스를 알기 위해 enumerate 반복
    for i,v in enumerate(sequence):

        # 5. n(합)이 k보다 작고 인덱스가 -2일 때
        while n<k and idx <= length-2:
            idx += 1
            n += sequence[idx]

        # 6. 같아지는 순간 answer에 (idx-i)길이, [시작 인덱스, 끝 인덱스]
        if n==k:
            answer.append([idx-i,[i,idx]])
        n -= v

    # 7. 길이가 가장 짧은 것부터 찾을 테니 idx-i 기준 정렬
    answer.sort()
    return answer[0][1]
print(solution([1, 2, 3, 4, 5], 7))