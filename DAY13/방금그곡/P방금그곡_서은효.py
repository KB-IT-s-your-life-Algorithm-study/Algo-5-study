def solution(m, musicinfos):
    answer = []
    # 플랫을 다른 단어로 정의함
    m = m.replace('C#','c').replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a")

    for info in musicinfos:
        # 쉼표로 쪼개기
        start, end, name, code = info.split(",")
        start_hour = start[:2]
        end_hour = end[:2]
        start_minute = start[3:]
        end_minute = end[3:]
        # 플랫을 다른 단어로 정의함
        code = code.replace('C#','c').replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a")
        temp_code = code

        # 시간과 분을 구함
        time = abs(((int(end_hour)*60) + int(end_minute)) - ((int(start_hour) * 60) + int(start_minute)))
        temp_time = time
        # 만약 시간보다 코드의 길이가 더 길다면,
        if time < len(code):
            # 재생 시간만큼 멜로디의 길이를 조절함
            temp_code = code[:time]

        # 멜로디의 길이보다 재생시간이 더 길다면
        if time > len(code):
            # 반복해서 재생함
            while time > len(code):
                temp_code += code
                time -= len(code)

        answer.append([temp_time, name,temp_code])

    # 재생시간 긴 순으로 정렬
    answer.sort(key= lambda x:(-x[0]))
    print(answer)
    for i in answer:
        # 기억하는 멜로디가 음악 안에 있다면
        if m in i[2]:
            return i[1]
    else:
        return "(None)"

print(solution("CCB", ["03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"]))



