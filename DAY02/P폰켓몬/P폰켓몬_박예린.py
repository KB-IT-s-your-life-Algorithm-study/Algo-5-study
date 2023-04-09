def solution(nums):
    dict = {}

    # 폰켓몬 hash dictionary 초기화
    for n in nums:
        if(n not in dict):
            dict[hash(n)] = n

    answer = len(dict)
    if(len(nums)/2 < len(dict)):
        answer = len(nums)/2

    return answer