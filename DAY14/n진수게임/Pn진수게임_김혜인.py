arr = list('0123456789ABCDEF')  #list 하나 만들어둠

def func(n, base):
    if n == 0:
        return arr[0]

    # 각 자리수를 담는 리스트
    digits = []
    while n > 0:
        digits.append(arr[n % base])          # 마지막 자리 숫자
        n = int(n // base)          # 마지막자리제거
    return ''.join(digits[::-1])     # 뒤집어서 반환


def solution(n, t, m, p):
    digits = []
    turn = 0
    while len(digits) < t * m:  #반목무 조거 설정
        digits += list(func(turn, n))   #자리수 담는 함수 불러오기
        turn += 1
    return ''.join(digits[p-1::m][:t])   #뒤집어서반환
