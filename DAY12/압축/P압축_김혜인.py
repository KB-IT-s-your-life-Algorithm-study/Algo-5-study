def solution(msg):
    answer = []
    # 알파벳 단어에 해당하는 색인번호 dic생성
    dic= dict(zip("ABCDEFGHIJKLMNOPQRSTUVWXYZ", range(1, 27)))
    cnt = 27  ##알파벳 개수
    i = 0
    search = ''
    
    # i가 msg길이에 해당하는 값까지 증가되면 break

  
    while i < len(msg):
        search += msg[i]
        #  단어가 이미 dic에 있다면 증가
        if search in dic:
            i += 1
            continue


      
        # 단어가 dic에 없으면 dic에 단어 추가 
        else:
            dic[search] = cnt
            cnt += 1
            # 마지막 글자를 제외한 단어는 사전에 있으므로 제거해줌
            s = search[:-1]
            answer.append(dic[s])
            # search = ''로 초기화
            search = ''
    
    # search에 마지막 글자 남아있으니 마지막 글자의 색인번호 answer에 append
    answer.append(dic[search])
    return answer
