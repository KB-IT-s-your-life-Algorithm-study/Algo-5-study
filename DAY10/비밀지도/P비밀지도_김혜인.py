def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):  ## 지도 길이만큼 반복
        map = list()
        for _ in range(n):  ## 지도 길이만큼 반복(이진수로 변환했을 떄 같음)
            if ((arr1[i] % 2) or (arr2[i] % 2)):  ##2로 나눈 나머지가 둘중에 하나도 1이면 벽추가
                map.append('#')
            else:
                map.append(' ')  ##아니면 공백추가

            arr1[i] //= 2
            arr2[i] //= 2
        
        map.reverse()  ##리스트 역순으로 바꿔줌
        
        String = ''
        for j in map:
            String += j
            
        answer.append(String)
        
    return answer
