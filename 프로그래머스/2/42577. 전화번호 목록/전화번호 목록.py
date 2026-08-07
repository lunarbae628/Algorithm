def solution(phone_book):
    
    hash = {}
    
    for p in phone_book:
        hash[p] = 1
        
    for number in phone_book:
        tmp = ""
        for n in number[:-1]:
            tmp += n
            if tmp in hash:
                return False;
    
    answer = True
    return answer