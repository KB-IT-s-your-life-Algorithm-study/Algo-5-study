
def solution(progresses, speeds):
    answer = []
    day = 0

#90 30 55
    while progresses:
        count = 0
        temp = (100 - progresses[0]) / speeds[0]
        if temp <= day:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
            # 30 55
            while progresses:
                temp = (100 - progresses[0]) / speeds[0]
                if temp <= day:
                    progresses.pop(0)
                    speeds.pop(0)
                    count += 1
                else:
                    break
            answer.append(count)
        else:
            day += 1
    return answer




#print(solution([95, 90, 99, 99, 80, 99],[1, 1, 1, 1, 1, 1]))