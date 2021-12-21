a = int(input())
digitSum = []

while a >= 1:
    digit = a % 10
    if digit == 0:
        digitSum.insert(0, 0)
        a //= 10
    else:
        digitSum.insert(0, digit)
        a //= 10

counter = 0
for x in range(len(digitSum) - 1):
    newDigitSum = digitSum[:]
    newDigitSum.sort()
    if newDigitSum == digitSum:
        counter = 1
    else:
        break

if counter:
    print("YES")
else:
    print("NO")
