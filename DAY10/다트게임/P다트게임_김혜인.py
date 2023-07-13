def solution(dartResult):
    res = []
    cnt = 0 #점수
    dartResult=dartResult.replace("10", "t")
    
    for n in dartResult:
        if n.isnumeric():
            cnt += int(n)
            continue
        elif n == 't': #10점일때
            cnt += 10
            continue
        elif n == 'S':
            res.append(cnt)
        elif n == 'D':
            res.append(cnt ** 2)
        elif n == 'T':
            res.append(cnt ** 3)
        elif n == '*': #스타상 & 두 판 이상 헀ㅇ르 경우
            if len(res)>1:
                res[-1] *= 2  #현재 점수 2배
                res[-2] *= 2  #직전 점수 2배
            else :## 한판만 한 경우 
                res[-1] *= 2
        elif n == '#': 
            res[-1] *= -1
        cnt=0
    return(sum(res))
