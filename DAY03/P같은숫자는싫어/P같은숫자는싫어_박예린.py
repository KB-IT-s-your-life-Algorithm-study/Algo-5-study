def solution(arr):
    answer = []

    while(arr):
        top = arr.pop()
        while(arr and top == arr[-1]):
            arr.pop()

        answer.append(top)
    
    answer.reverse()
    
    return answer