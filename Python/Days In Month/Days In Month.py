a = int(input())

if 1 > a > 12:
    print("Invalid Input")

if a < 8:
    if a % 2 == 1:
        print(31)
    elif a == 2:
        print(28)
    else:
        print(30)
else:
    if a % 2 == 1:
        print(30)
    elif a == 8:
        print(31)
    else:
        print(31)