def solution(clothes):
    

    hash = {}

    for c in clothes:
        hash[c[1]] = hash.get(c[1], 0) + 1

    answer = 1

    for key in hash:
        answer *= hash.get(key) + 1

    return answer - 1
