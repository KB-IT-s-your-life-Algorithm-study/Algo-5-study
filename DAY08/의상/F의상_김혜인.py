def solution(clothes):
    answer = 1
    aDict = {}
    for i in clothes:
        if i[1] in aDict:
            aDict[i[1]] += 1
        else:
            aDict[i[1]] = 1
    for i in aDict.keys(): 
        answer *= aDict[i] +1
    answer -= 1

    return answer
  ##잘몰라서 구글링. 이해되는 코드 가져옴
