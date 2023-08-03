def solution(m, musicinfos):
    answer = ''
    # 플랫을 다른 단어로 정의함
    m = m.replace('C#','c').replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a")
    print(m)
    for info in musicinfos:
        # 쉼표로 쪼개기
        start, end, name, code = info.split(",")
        start_hour = start[:2]
        end_hour = end[:2]
        start_minute = start[3:]
        end_minute = end[3:]
        # 플랫을 다른 단어로 정의함
        code = code.replace('C#','c').replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a")

        # 시간과 분을 구함
        hour = int(end_hour) - int(start_hour)
        minute = int(end_minute) - int(start_minute)

        #만약에 시간이 있다면
        if hour > 0:
            # 분으로 변환해서 더함
            hour = hour * 60
            minute += hour

        while minute > 0:
            print(minute)
            code += code
            minute -= 1



    return answer

print(solution("CC#BCC#BCC#BCC#B",["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]	))
