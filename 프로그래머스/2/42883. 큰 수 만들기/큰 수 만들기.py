def solution(number, k):
    
    stack = []

    for n in number:
        while k > 0 and stack and stack[-1] < n:
            stack.pop()
            k -= 1

        stack.append(n) 
    
    
    if k > 0:
        for i in range(k):
            stack.pop()

    return "".join(stack)