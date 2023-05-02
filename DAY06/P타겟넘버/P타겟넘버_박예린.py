def solution(numbers, target):
    global answer
    answer = 0
    dfs(numbers, target, 0, 0)
    return answer

def dfs(numbers, target, result, depth):
    global answer

    resultAdd = 0
    resultSub = 0

    if(depth == len(numbers)):
        if(target == result):
            answer += 1
        return
    
    resultAdd = result + numbers[depth]
    resultSub = result - numbers[depth]

    dfs(numbers, target, resultAdd, depth+1)
    dfs(numbers, target, resultSub, depth+1)