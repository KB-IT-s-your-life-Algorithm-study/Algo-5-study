def solution(clothes):


    category = dict() #딕셔너리 하나 생성

    # 1. 종류 별로 1씩 카운트
    for cloth in clothes: #입력 매개 변수 반복
        if cloth[1] not in category: #종류별로 몇개인지 카운트
            category[cloth[1]] = 1
        else:
            category[cloth[1]] += 1

    answer = 1 # 곱해야 하므로 1로 설정

    # 2. 종류 + 1(입지 않는 경우의 수)만큼을 곱한 후 아무것도 입지 않는 경우는 없으니 1을 제외하고 return
    for cloth in category:
        answer *= category[cloth] + 1

    return answer-1

print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))