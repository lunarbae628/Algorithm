def solution(arr):
    q = []
    for num in arr:
        if q and q[-1] == num:
            continue
        else:
            q.append(num)
        
    return q