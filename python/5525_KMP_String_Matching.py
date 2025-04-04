import sys
input = sys.stdin.readline

def kmp():
    cnt = 0
    pi = [0] + [i for i in range(subsize-1)]
    j = 0
    for i in range(size):
        while j > 0 and str1[i] != substr[j]:
            j = pi[j-1]
        if str1[i] == substr[j]:
            j += 1
        if j == subsize:
            cnt += 1
            j = pi[j-1]
    return cnt

n = int(input())
size = int(input())
str1 = input().rstrip()
substr = 'I'+ 'OI'*n
subsize = len(substr)
print(kmp())
