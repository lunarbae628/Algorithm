import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
s = []
visited = [False] * (N+1)
log = []
def dfs(start):

    if len(s) == M:
        print(*s)
        return
    
    for i in range(start,N+1):
        if visited[i]:
            continue
        
        visited[i] = True
        s.append(i)
        dfs(i+1)
        s.pop()
        visited[i] = False

dfs(1)