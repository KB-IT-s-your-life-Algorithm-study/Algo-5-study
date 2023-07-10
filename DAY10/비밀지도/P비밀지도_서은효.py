def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        a = format(arr1[i], 'b').zfill(n)
        b = format(arr2[i], 'b').zfill(n)
        print("a= ", a, end="")
        print("b= ",b)
        str = ""
        for j in range(n):
            if a[j] == "1" or b[j] == "1":
               str += "#"
            else:
                str += " "
        answer.append(str)

    return answer

print(solution(5,[9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))