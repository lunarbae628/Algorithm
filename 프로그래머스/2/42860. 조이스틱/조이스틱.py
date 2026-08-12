def solution(name):

    change_move = 0

    for n in name:
        change_move += min(ord(n) - ord("A"), ord("Z") - ord(n) + 1)

    n = len(name)
    shortest = n - 1

    for i in range(n):
        next_idx = i + 1
        while next_idx < n and name[next_idx] == "A":
            next_idx += 1


        shortest = min(shortest, i * 2 + n - next_idx, i + 2*(n - next_idx))

    return change_move + shortest

     