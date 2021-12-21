inventory = []


def appendArray(item):
    inventory.append(item)


flag = 0
while flag < 5:
    item = input("Enter items: ")
    appendArray(item)
    flag += 1

print(inventory)
