
# 3번째 학생이 2번째 학생한테 체육복 안주면, 2번째 학생은 못받음
#lost: 체육복 도난(못받은 학생 0, 받은학생 1)
#reserve 리스트 돌면서 1차이가 나면(체육복 빌려준 경우) lost 요소의 flag 1로 바꿔주기
# 도난 당하면 lost 의 flag  1채우기
def solution(n, lost, reserve):
    answer=0
    lost.sort()
    reserve.sort()
    reserve2 = [r for r in reserve if r not in lost]
    lost2 = [l for l in lost if l not in reserve]
    for r in reserve2:
        if r-1 in lost2:
            lost2.remove(r-1)
        elif r+1 in lost2:
            lost2.remove(r+1)
    answer = n - len(lost2)
    return answer
