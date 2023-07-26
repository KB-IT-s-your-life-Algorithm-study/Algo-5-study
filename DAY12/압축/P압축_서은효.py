def solution(msg):
    answer = []

    #A~Z까지 기본적인 사전 하나 만들기
    dic = []
    for number in range(65,91):
        dic.append(chr(number))

    #슬라이싱 할 front와 end
    front_cut = 0
    end_cut = 1

    # while문 flag
    flag = True

    while flag:
        #msg를 슬라이싱함
        message = msg[front_cut:end_cut]

        #만약에 end가 msg+1과 같아진다면 => 마지막 인덱스라는 뜻
        if end_cut == len(msg)+1:
            #사전의 색인을 출력하고 반복문을 중단함
            answer.append(dic.index(message) + 1)
            flag = False

        #만약 사전에 message가 있다면
        if message in dic:
            #사전에 없는 단어가 나올때까지 End를 추가시켜감
            end_cut += 1

        # 사전에 없는 단어라면
        else:
            #사전에 새로운 단어를 추가하고
            dic.append(message)
            #message를 end-1로 되돌림
            message = msg[front_cut:end_cut-1]
            #사전 색인을 출력함
            answer.append(dic.index(message) + 1)
            #end는 그대로 두고, front만 end-1로 변경하기 
            front_cut = end_cut-1


    return answer

print(solution("ABABABABABABABAB"))
