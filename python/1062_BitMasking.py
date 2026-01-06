import sys
from itertools import combinations
input = sys.stdin.readline

n, k = map(int, input().split())
words = []
basic = {'a', 'n', 't', 'i', 'c'}

if k < 5:
    print(0)
    exit()

for _ in range(n):
    word = input().rstrip()
    mask = 0
    for ch in set(word[4:-4]):
        mask |= (1 << (ord(ch) - ord('a')))
    words.append(mask)

learn = ['b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z']
max_v = 0

base = 0
for ch in basic:
    base |= (1 << (ord(ch) - ord('a')))

for comb in combinations(learn, k - 5):
    teach = base
    for ch in comb:
        teach |= (1 << (ord(ch) - ord('a')))
    ans = 0
    for word in words:
        if word & ~teach == 0:
            ans += 1
    max_v = max(max_v, ans)

print(max_v)