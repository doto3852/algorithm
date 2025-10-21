import sys
input = sys.stdin.readline

n = int(input())
pipe = [[] for _ in range(58)]
amount = [[0 for _ in range(58)] for _ in range(58)]
flow = [[0 for _ in range(58)] for _ in range(58)]
for _ in range(n):
    s,e,a = input().split()
    s = ord(s)-65
    e = ord(e)-65
    amount[s][e] += int(a)
    amount[e][s] += int(a)
    pipe[s].append(e)
    pipe[e].append(s)
max_flow = 0

def bfs(f, t):
    path = [-1 for _ in range(58)]
    q = [f]
    for i in q:
        for j in pipe[i]:
            if amount[i][j] - flow[i][j] > 0 and path[j] < 0:
                q.append(j)
                path[j] = i
                if j == t:
                    c = float('inf')
                    curr = t
                    while curr != f:
                        c = min(c, amount[path[curr]][curr] - flow[path[curr]][curr])
                        curr = path[curr]
                    curr = t
                    while curr != f:
                        flow[path[curr]][curr] += c
                        flow[curr][path[curr]] -= c
                        curr = path[curr]
                    return c
    return 0

while True:
    c = bfs(0, 25)
    if c > 0:
        max_flow += c
    else:
        break
print(max_flow)