import sys
input = sys.stdin.readline
from math import sqrt
from heapq import heappop, heappush

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)
    if x == y:
        return
    if x < y:
        parent[y] = x
    else:
        parent[x] = y

n, m = map(int, input().split())
sites = []
parent = [i for i in range(n)]
hq = []
for i in range(n):
    x, y = map(int, input().split())
    for j in range(i):
        dist = sqrt((sites[j][0]-x)**2 + (sites[j][1]-y)**2)
        heappush(hq, (dist, i, j))
    sites.append((x, y))

for _ in range(m):
    a, b = map(int, input().split())
    union(a-1, b-1)

ans = 0
while hq:
    d, v1, v2 = heappop(hq)
    if find(v1) != find(v2):
        union(v1, v2)
        ans += d
print("{:.2f}".format(round(ans, 2)))