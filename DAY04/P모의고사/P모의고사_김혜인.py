def solution(answers):
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]  #점수 초기화    
    for i in range(len(answers)):
    
    #각 수포자가 찍는 방법 반복문 돌리기
        if answers[i] == p1[i%len(p1)]:
            score[0] += 1
        if answers[i] == p2[i%len(p2)]:
            score[1] += 1
        if answers[i] == p3[i%len(p3)]:
            score[2] += 1
    
    #max값 찾기
    max_score = max(score)
    answer = []
    for i in range(len(score)):
        if score[i]==max_score:
            answer.append(i+1)
    return answer
