def solution(participant, completion):
    dict = {}
    sum = 0

    # 참가자 hash dictionary 초기화
    for p in participant:
        dict[hash(p)] = p # key: hash(p), value: p
        sum += hash(p)

    for c in completion:
        if(dict[hash(c)] in completion):
            sum -= hash(c)

    # 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주
    answer = dict[sum]
    
    return answer

