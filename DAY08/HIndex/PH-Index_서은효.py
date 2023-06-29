def solution(citations):

    citations.sort()
    #[0, 1, 3, 5, 6]
    length = len(citations) #최댓값을 알고 싶으므로 작은 수부터 내림차순 정렬
    default = 0 #해당되는 값을 못찾았을 경우에 출력될 deafult

    for i in range(length):
        hIndex = citations[i]
        high = length - i # h편 이상 인용된 논문의 개수

        if hIndex >= high: #i가 h편 이상 인용된 논문의 개수 이상일 경우
           return high #인용된 논문의 "횟수"를 리턴함
    return default

print(solution([3, 0, 6, 1, 5]))