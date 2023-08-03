import math
def solution(r1, r2):
    answer = 0
    for i in range(1, r2+1) :  ##q
      ## 1사분면 위의 점, 양x축, y축 범위 선정
        if r1*r1 - i*i >= 0 :
            low = math.ceil(math.sqrt(r1*r1 - i*i))  ##점의 개수를 구해야 int형으로 바꿔줌
        else :
            low = 0
        high = math.floor(math.sqrt(r2*r2 - i*i))
        answer += (high - low + 1)  ##작은원의 높이가 0인 경우 반올림 후 +1 해줌
    return answer * 4  #1사분며의 정수점 개수를 구해서 *4개해줌
