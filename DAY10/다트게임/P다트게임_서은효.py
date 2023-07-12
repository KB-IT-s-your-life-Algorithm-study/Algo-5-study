# 해설 참조

def solution(dartResult):

    dartResult = dartResult.replace('10', 'A')

    dic = { 'S': 1, 'D':2, 'T': 3}
    stack = []

    for i in dartResult:
        if i == "#":
            temp = stack.pop()
            stack.append(temp * -1)

        if i == "*":
            temp_1 = stack.pop()

            # 스택에 1개 이상의 수가 있다면
            if len(stack):
                temp = stack.pop()
                stack.append(temp * 2)
            stack.append(temp_1 * 2)
        if i in ("S", "D", "T"):
            # stack에 있던 마지막 수를 꺼내 제곱 후 다시 push
            temp = stack.pop()
            stack.append(temp ** dic[i])

        if i.isdigit() or i == 'A':
            if i == "A":
                stack.append(10)
            else:
                stack.append(int(i))

    return sum(stack)


print(solution("1S2D*3T"))