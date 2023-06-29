def solution(citations):
    citations.sort() #배열순서대로 정렬해줌
    answer = 0

    for h in range(max(citations)):  #배열에서가장큰수에대해for문돌리기
        count=0
        for n in range(len(citations)):
            if h<=citations[n]:
                count+=1
        if count>=h:
            answer=max(answer, h)

    return answer
