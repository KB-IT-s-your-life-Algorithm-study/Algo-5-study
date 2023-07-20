
def solution(str1, str2):
    # 두 집합 모두 대문자로 변환
    str1 = str1.upper()
    str2 = str2.upper()

    # 1. 문자열 2개씩 쪼개기
    A = [str1[i:i+2] for i in range(0, len(str1)-1) if str1[i:i+2].isalpha()]
    B = [str2[i:i+2] for i in range(0, len(str2)-1) if str2[i:i+2].isalpha()]

    # 교집합을 찾아내기 위한 A의 카피 리스트
    A1 = A.copy()
    intersection = []

    for i in B:
        if i in A1 and i.isalpha():
            A1.remove(i)
            intersection.append(i)

    # 합집합 = A+B
    union = A+B

    # 합집합 - 교집합
    for i in intersection:
        if i in union:
            union.remove(i)

    intersection_len = len(intersection)
    union_len = len(union)

    # 두 집합 모두 공집합일 경우 예외처리
    if not intersection_len and not union_len:
        return 65536

    return int(float(intersection_len/union_len) * 65536)


print(solution("aa1+aa2","AAAA12"))




