from collections import deque

def solution(progresses, speeds):

    progresses = deque(progresses)
    speeds = deque(speeds)
    answer = []
    while progresses:
        tmp = 0
        for i in range(len(progresses)):
            progresses[i]+= speeds[i]
            
        while progresses and progresses[0] >= 100:
            progresses.popleft()
            speeds.popleft()
            tmp+=1

        if tmp > 0:
            answer.append(tmp)
        
    return answer