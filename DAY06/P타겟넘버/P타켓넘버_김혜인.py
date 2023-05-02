
def solution(numbers, target):
    answer = 0
    n = len(numbers)

    def dfs(idx, result):
        nonlocal answer
        if idx == n:  # 배열의 모든 숫자를 확인한 경우
            if result == target:  # 목표 숫자를 만든 경우
                answer += 1
            return
        else:
            dfs(idx + 1, result + numbers[idx])  # 현재 숫자를 더하는 경우
            dfs(idx + 1, result - numbers[idx])  # 현재 숫자를 빼는 경우

    dfs(0, 0)  # DFS 탐색 시작
    return answer
