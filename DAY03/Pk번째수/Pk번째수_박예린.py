def solution(array, commands):
    answer = []
    tmp = []
    
    for i in range(len(commands)):
        tmp = array[(commands[i][0]-1):commands[i][1]]
        tmp.sort()
        answer.append(tmp[commands[i][2]-1])

    return answer