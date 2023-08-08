def solution(files):
    answer = []
    arr = []  # 정렬할 파일명 
    len_files = len(files)  # 파일 수

    for i in range(len_files):
        HEAD, NUMBER = '', ''  #, 로 구분
        for j in files[i]:
            if not j.isdigit() and not NUMBER:  # HEAD
                HEAD += j.lower()
            elif j.isdigit() and HEAD:  # NUMBER 
                NUMBER += j
            else:  # TAIL 부분
                break
        arr.append((HEAD, NUMBER, i))  ## 파일명에 head, number 넣기 > 후에 정렬

    arr.sort(key=lambda x: (x[0], x[1], x[2]))  # HEAD, NUMBER, 입력된 순서로 정렬됨

    for i in range(len_files):
        answer.append(files[arr[i][-1]])  # 정렬된 파일명을 answer 결과로 내보내기
    return answ
