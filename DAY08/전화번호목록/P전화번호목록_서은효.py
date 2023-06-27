def solution(phone_book):
    answer = True
    phone_book.sort() #정렬
    # [119, 119552441, 97674223]와 같이 아스키코드 순서대로 정렬
    # 정렬을 하면 앞 뒤만 비교하면 됨

    for i in range(len(phone_book)-1):
        targetLen = len(phone_book[i])
        if phone_book[i+1][:targetLen] == phone_book[i]:
            answer = False
            break
    return answer

print(solution(["119", "97674223", "1195524421"]))

