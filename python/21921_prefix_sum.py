import sys
input = sys.stdin.readline

n, x = map(int, input().split())
arr = list(map(int, input().split()))
arrsum = [0 for _ in range(n+1)]
max_v = 0
cnt = 0

# 누적합으로 된 list 만들기기
for i in range(n):
    arrsum[i+1] = arrsum[i] + arr[i]

# minus 연산 하나로 기간 동안의 합 구할 수 있음음
for j in range(x, n+1):
    visit = arrsum[j] - arrsum[j-x]
    if visit > max_v:
        max_v = visit
        cnt = 1
    elif visit == max_v:
        cnt += 1

if max_v:
    print(max_v)
    print(cnt)
else:
    print("SAD")