def solution(progresses, speeds):
    answer = []
    days = 0 
    cnt = 0 # 완료된 기능
    while len(progresses) > 0:
    	# 기능의 진행상황이 0보다 클 때, 그 동안 지난 날짜만큼의 speed를 구해서 그 지난 날짜에 더해줌
        if(progresses[0]+days*speeds[0])>=100:
            # 완료되면 pop(제거)
            progresses.pop(0)
            speeds.pop(0)
            # 완료된 기능 수
            cnt += 1
        else:
        	# 완료되면 answer에 더해주고 제거
            if cnt > 0:
                answer.append(cnt)
                cnt = 0
            # 완료된 기능이 없으면 days 추가
            else:
                days+=1
    answer.append(cnt)
    return answer
