
def solution(array, commands):
    answer = []
    for num in commands:
        i, j, k = num
        
        temp = sorted(array[i-1:j])
        answer.append(temp[k-1])
    return answer
