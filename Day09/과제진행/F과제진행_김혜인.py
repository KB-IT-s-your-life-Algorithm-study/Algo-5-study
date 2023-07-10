import copy
def solution(plans):
    answer = []
    stop = []
    plans = sorted(plans, key=lambda x : x[1])
    for i in range(len(plans)):
        if i != len(plans) - 1: # 마지막이 아니라면 
            temp = int(plans[i][1][0:2]) * 60 + int(plans[i][1][3:]) + int(plans[i][2])
            next = int(plans[i+1][1][0:2]) * 60 + int(plans[i+1][1][3:])
            if temp <=next:
                answer.append(plans[i][0]) # 다음 것 안에 끝났으면
                if len(stop) > 0: # 멈춘 것이 있다면
                    lis = copy.deepcopy(stop)
                    tp = next - temp
                    for j in range(len(stop)-1,-1,-1):     
                        if stop[j][1] <= tp:
                            tp -= stop[j][1]
                            answer.append(stop[j][0])
                            lis.pop()
                        else:
                            lis[-1][1] = stop[j][1] - tp
                            break
                    stop = copy.deepcopy(lis)
            else: # 못 끝낸다면
                stop.append([plans[i][0],temp - next])
        else:
            answer.append(plans[i][0]) # 마지막꺼

    for i in range(len(stop)-1,-1,-1):
        answer.append(stop[i][0])
    return answer



## 0~23.59 까지 시간을 흐르기 그냥 해버림 > 반복 길이 길어짐 > 런타임 에러
## 현재랑 다음 과제 시작 시간 비교하면서 멈춰둔 과제를 진행하는 과정에서, 멈춰든 과제와 남은 시간안에 해결하는 걸 어떻게 뽑을지 모름
## 구글링하여 뒷부분 해결(15~23번 코드를 제대로 새악ㄱ하지 못함 + 27 마지마꺼 끝내는 코드도 안짬)
