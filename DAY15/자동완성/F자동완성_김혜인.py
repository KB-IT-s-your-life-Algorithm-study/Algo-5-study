##이분탐색 시간 초기화...
def b(current_word, words):
    start = 0
    length = len(current_word)
    end = length
    result = 0

   ##이분탐색
    while start <= end:
        count = 0
        mid = int((start+end)/2)  ##중간단어 지정 후 비교
        subset = current_word[:mid]
        for word in words:
            if subset in word:
                count += 1
        if count > 1: 
            if mid == length:
                return mid
            start = mid + 1
        else:
            end = mid - 1 ##중간과 길이 다를 때 
            result = mid
    return result

def solution(words):
    answer = 0
    for word in words:
        answer += ㅠ(word, words)
    return answer
