def solution(m, musicinfos):
    answer = ''
    answer_total = 0
    m = melody_to_string(m)
    for info in musicinfos:
        start,end,title,board = info.split(',')

        total = calc_total_time(start,end)

        melody = melody_to_string(board)
        
        a = total//len(melody)
        b = total%len(melody)
        
        melody = melody*a+melody[:b]
        if m in melody:
            if answer_total < total:
                answer = title
                answer_total = total
    return answer if answer else '(None)'

def melody_to_string(board):
    converter = {
        'C':'a','C#':'b','D':'c','D#':'d','E':'e','F':'f','F#':'g','G':'h','G#':'i','A':'j','A#':'k','B':'l','E#':'m'
    }
    
    melody = ''
    idx = 0
    while idx < len(board):
        if idx+1 < len(board) and board[idx+1] == '#':
            melody += converter[board[idx]+'#']
            idx += 2
        else:
            melody += converter[board[idx]]
            idx += 1
    return melody

def calc_total_time(start,end):
    sm = 60*int(start[:2])+int(start[3:])
    em = 60*int(end[:2])+int(end[3:])
    return em-sm
