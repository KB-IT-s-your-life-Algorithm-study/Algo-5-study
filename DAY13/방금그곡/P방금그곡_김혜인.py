def solution(m, musicinfos):
    answer = ''
    answer_total = 0
    m = melody_to_string(m)
    for info in musicinfos:
        start,end,title,board = info.split(',')     # 쉼표로 쪼개기

        total = calc_total_time(start,end)

        melody = melody_to_string(board)

        ## 멜로디 라인 쪼개기
        a = total//len(melody)
        b = total%len(melody)
        
        melody = melody*a+melody[:b]
        if m in melody:
            if answer_total < total:
                answer = title
                answer_total = total
    return answer if answer else '(None)'

## 플랫을 다른 단어로 정의하는 함수 만들기
def melody_to_string(board):
    converter = {
        'C':'a','C#':'b','D':'c','D#':'d','E':'e','F':'f','F#':'g','G':'h','G#':'i','A':'j','A#':'k','B':'l','E#':'m'
    }
    
    melody = ''
    idx = 0
    # 기억하는 멜로디가 음악 안에 있다면
    while idx < len(board):
        if idx+1 < len(board) and board[idx+1] == '#':
            melody += converter[board[idx]+'#']
            idx += 2
        else:
            melody += converter[board[idx]]
            idx += 1
    return melody


## 시간 분 쪼개서 다시 정의
def calc_total_time(start,end):
    sm = 60*int(start[:2])+int(start[3:])
    em = 60*int(end[:2])+int(end[3:])
    return em-sm
