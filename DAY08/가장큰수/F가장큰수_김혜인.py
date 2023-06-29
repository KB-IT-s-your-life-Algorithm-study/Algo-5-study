def solution(numbers):
  tmp = []
  answer = ''
  number = list(map(str, numbers)) ## 문자열 ㅂ녀경
  for num in numbers: ##자릿수 맞추기 위해 for 문 돌림
    len_n = len(num)
    if len_num==1:
        tmp.append(num*6)
    elif len_num==2:
        tmp.append(num*3)
    else:
        tmp.append(num*2)
  sort_index=[i[0] for i in sorted(enumerate(tmp), key=la,bda x:x[1])]

  for i in range(len*(numbers)-1, -1, -1) 큰 수대로 붙이기
  answer += numbers[sort_indes[i]]
 )

#1~6 테스트 런타임 에러
