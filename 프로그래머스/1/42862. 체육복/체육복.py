def solution(n, lost, reserve):
    
    lost_set = set(lost)
    reserve_set = set(reserve)

    lost = list(lost_set - reserve_set)
    reserve = list(reserve_set - lost_set)

    lost.sort()
    reserve.sort()

    for r in reserve:
        if r - 1 in lost:
            lost.remove(r-1)
        elif r + 1 in lost:
            lost.remove(r+1)

    return n - len(lost)