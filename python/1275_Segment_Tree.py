import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
tree = [0 for _ in range(n * 4)]

def init(start, end, node):
    if start == end:
        tree[node] = arr[start]
        return tree[node]
    mid = (start + end) // 2
    left = init(start, mid, node * 2)
    right = init(mid + 1, end, node * 2 + 1)
    tree[node] = left + right
    return tree[node]

def nodeUpdate(target, new, start, end, node):
    if target < start or target > end:
        return
    if start == end:
        tree[node] = new
        arr[start] = new
        return
    mid = (start + end) // 2
    nodeUpdate(target, new, start, mid, node * 2)
    nodeUpdate(target, new, mid + 1, end, node * 2 + 1)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]

def query(start, end, node, left, right):
    if right < start or end < left:
        return 0
    if left <= start and end <= right:
        return tree[node]
    
    mid = (start + end) // 2
    return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right)

init(0, n-1, 1)
for _ in range(m):
    x, y, a, b = map(int, input().split())
    if x > y:
        x, y = y, x
    print(query(0, n-1, 1, x-1, y-1))
    nodeUpdate(a-1, b, 0, n-1, 1)