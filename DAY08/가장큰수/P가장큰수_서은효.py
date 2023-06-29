# 해결 방법을 못 찾아서 구글링

def solution(numbers):
    # 1. 문자열로 바꾸기
    numbers = list(map(str, numbers)) # 문자열로 바꾸기

    # 2. 3을 곱한 값을 key로 역순 정렬
    # 1000이하로 3자리수를 맞춰주기 위함
    # ex) 30보다 3이 먼저 나와야 하는데 이럴 경우를 위해 3을 곱한 값을 기준으로 역순 정렬한 것
    numbers.sort(key=lambda x:x*3, reverse=True)

    # 3. 큰 순서대로 정렬한 것을 문자열로 이어붙인 것
    # 이 때 [0, 0, 0 ,0]인 경우를 위해 int로 변환 후에 문자열로 변환하고 리턴함
    return str(int(''.join(numbers)))

print(solution([6, 10, 2]))