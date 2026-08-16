def solution(s):
    cnt = 0
    for _ in s:
        if _ == "(":
            cnt+=1
        else:
            cnt-=1
        
        if cnt < 0:
            return False
    
    if cnt == 0:
        return True
    else:
        return False
        

