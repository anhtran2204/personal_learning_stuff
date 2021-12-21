import random
import os


def pickUpItem(items):
    if items in inventory:
        print("\nYou already picked it up.\n")
    else:
        print("\nYou found a " + str(items) + "!\n")
        stop = False
        while not stop:
            pickUp = input("Do you want to pick it up?\nyes/no\n").lower()
            if pickUp == "yes":
                inventory.append(items)
                print("\nYou acquired the " + str(items) + "!\n")
                stop = True
            elif pickUp == "no":
                print("Maybe later then.\n")
                stop = True
            else:
                print("I don't understand.\n")


inventory = []
weapChoice = []
playerHealth = 200
xpBar = 0
xpLimit = 100
level = 1
zombieHealth = 0


def combat():
    global xpBar, xpLimit, level, zombieHealth
    score = 0
    zombieKind = ["Walking Zombie", "Running Zombie", "Crawling Zombie", "Bulky Zombie", "Radiating Zombie",
                  "Toxic Zombie", "Zombie Hound", "Human Centipede Zombie", "Chimera Zombie"]

    zombie = random.choice(zombieKind)
    print("You encountered a " + str(zombie) + "\n")

    if len(weapChoice) > 0:
        if str(weapChoice[0]) == "knife" or str(weapChoice[0]) == "katana" or str(weapChoice[0]) == "handgun" or \
                str(weapChoice[0]) == "baseball bat" or str(weapChoice[0]) == "machete":
            if zombie == "Walking Zombie":
                zombieHealth = random.randint(100, 200)
            elif zombie == "Running Zombie":
                zombieHealth = random.randint(140, 290)
        elif str(weapChoice[0]) == "assault rifle" or str(weapChoice[0]) == "sniper rifle" or str(
                weapChoice[0]) == "machine gun" or \
                str(weapChoice[0]) == "SMG" or str(weapChoice[0]) == "chainsaw" or str(weapChoice[0]) == "shotgun":
            if zombie == "Walking Zombie":
                zombieHealth = random.randint(100, 200)
            elif zombie == "Running Zombie":
                zombieHealth = random.randint(140, 290)
            elif zombie == "Crawling Zombie":
                zombieHealth = random.randint(250, 320)
            elif zombie == "Bulky Zombie":
                zombieHealth = random.randint(350, 450)
            elif zombie == "Radiating Zombie":
                zombieHealth = random.randint(180, 300)
            elif zombie == "Toxic Zombie":
                zombieHealth = random.randint(210, 300)
            elif zombie == "Zombie Hound":
                zombieHealth = random.randint(150, 260)
            elif zombie == "Human Centipede Zombie":
                zombieHealth = random.randint(360, 500)
            elif zombie == "Chimera Zombie":
                zombieHealth = random.randint(600, 800)

    else:
        if zombie == "Walking Zombie":
            zombieHealth = random.randint(100, 200)

    xpGain = random.randint(1, zombieHealth)

    if playerHealth > zombieHealth:
        print("This is gonna be an easy fight!\n")
    else:
        print("You're definitely gonna lose!!\n")

    while zombieHealth >= 1:
        try:
            print(weapChoice)
            userChoice = int(input("What do you want to do?\n1 - Block\n2 - Inventory\n3 - Attack\n4 - Run "
                                   "away\n"))
            if userChoice == 1:
                zombieAttack = random.randint(1, 50)
                print("You blocked " + str(zombieAttack) + " damage!\n")

            # Open inventory and use item
            elif userChoice == 2:
                # Print inventory and then input an item,
                # the input is then put in an array at the start.
                # Only check the first index of array for item choice.
                if len(inventory) == 0:
                    print("Your inventory is currently empty.\n")
                else:
                    print(inventory)
                    bagItem = input("What item do you want to use?\n")
                    if bagItem in inventory:
                        weapChoice.insert(0, bagItem)
                        print("Equipped " + str(bagItem) + ".\n")
                    else:
                        print("Item don't exist.\n")

                    # Check if first aid kit to heal
                    if bagItem == "first aid kit":
                        playerHeal = random.randint(50, playerHealth)
                        newPlayerHealth = playerHealth + playerHeal
                        if newPlayerHealth >= playerHealth:
                            print("You've already reached maximum health!!\n")
                            newPlayerHealth = newPlayerHealth + (playerHealth - newPlayerHealth)
                            print("You regained " + str(playerHeal) + " health!\nYour current health is " +
                                  str(newPlayerHealth))
                            inventory.remove("first aid kit")
                        else:
                            print("You regained " + str(playerHeal) + " health!\nYour current health is " +
                                  str(newPlayerHealth) + "\n")
                    elif bagItem == "flashbang":
                        print("The zombie is stunned.\n")

                    elif bagItem == "grenade":
                        grenadeDmg = zombieHealth * (round(random.uniform(0.4, 0.7), 1))
                        print("The grenade hit the zombie.\n")
                        print("You hit the zombie for " + str(int(grenadeDmg)) + " damage!\n")
                        zombieHealth = zombieHealth - grenadeDmg
                        if zombieHealth <= 0:
                            break
                        print("The zombie has " + str(int(zombieHealth)) + " health remaining!\n")
                        inventory.remove("grenade")

            # Check type of weapon and attack zombie
            elif userChoice == 3:
                attackPoint = None
                ammos = None
                if len(weapChoice) == 0:
                    print("Go to inventory and equip a weapon first\n")
                else:
                    if str(weapChoice[0]) == "knife":
                        attackPoint = random.randint(9, 15)
                    elif str(weapChoice[0]) == "assault rifle":
                        attackPoint = random.randint(40, 80)
                        ammos = 50
                    elif str(weapChoice[0]) == "sniper rifle":
                        attackPoint = random.randint(60, 100)
                        ammos = 10
                    elif str(weapChoice[0]) == "machine gun":
                        attackPoint = random.randint(120, 190)
                        ammos = 100
                    elif str(weapChoice[0]) == "shotgun":
                        attackPoint = random.randint(80, 130)
                        ammos = 6
                    elif str(weapChoice[0]) == "machete":
                        attackPoint = random.randint(18, 32)
                    elif str(weapChoice[0]) == "SMG":
                        attackPoint = random.randint(60, 120)
                        ammos = 60
                    elif str(weapChoice[0]) == "baseball bat":
                        attackPoint = random.randint(20, 30)
                    elif str(weapChoice[0]) == "chainsaw":
                        attackPoint = random.randint(80, 100)
                    elif str(weapChoice[0]) == "katana":
                        attackPoint = random.randint(50, 70)
                    elif str(weapChoice[0]) == "handgun":
                        attackPoint = random.randint(20, 40)
                        ammos = 10

                    # Enter hitChance of weapon
                    while True:
                        try:
                            if str(weapChoice[0]) == "handgun" or str(weapChoice[0]) == "assault rifle" or \
                                    str(weapChoice[0]) == "sniper rifle" or str(weapChoice[0]) == "machine gun" \
                                    or str(weapChoice[0]) == "shotgun" or str(weapChoice[0]) == "SMG":
                                hitChance = int(input("\nWhat is your Hit Chance>\n"))
                                if ammos == 0:
                                    print("You're out of ammo.\nPlease reload.\n")
                                    break
                                ammos -= 1
                                break
                            elif str(weapChoice[0]) == "knife" or str(weapChoice[0]) == "machete" or \
                                    str(weapChoice[0]) == "baseball bat" or str(weapChoice[0]) == "chainsaw" \
                                    or str(weapChoice[0]) == "katana":
                                hitChance = int(input("\nWhat is your Hit Chance>\n"))
                                break
                        except ValueError:
                            print("\nI didn't understand that!\n")

                    # Critical Hit
                    diceRoll = (random.randint(1, 5)) + hitChance
                    if diceRoll >= 25:
                        critical = random.randint(1, 5)
                        userAttack = attackPoint
                        if critical >= 4:
                            userAttack = attackPoint * 2
                            print("Critical Hit!!\n")
                        print("You hit the zombie for " + str(int(userAttack)) + " damage!\n")
                        zombieHealth = zombieHealth - userAttack
                        if zombieHealth <= 0:
                            break
                        print("The zombie has " + str(int(zombieHealth)) + " health remaining!\n")
                    else:
                        print("You miss!\n")

                    zombieAttack = random.randint(1, 50)
                    critical = random.randint(1, 10)
                    if critical >= 6:
                        zombieAttack = zombieAttack * 2
                        print("Critical Hit!!\n")
                    newPlayerHealth = playerHealth - zombieAttack
                    print("The Monster hit you for " + str(int(zombieAttack)) + "!\n")
                    if newPlayerHealth <= 0:
                        break
                    else:
                        print("You have " + str(int(newPlayerHealth)) + " health remaining.\n")

            # Run away
            elif userChoice == 4:
                print("\nYou ran away from the zombie\n")
                break
            # Re-enter input
            else:
                print("I don't understand!!\n")
        except ValueError:
            print("I don't understand!!\n")
    # Check if zombie is killed
    if zombieHealth <= 0:
        print("You killed the zombie!!\n")
        print("You gained " + str(xpGain) + " xp!\n")
        xpBar += xpGain
        if xpBar >= xpLimit:
            level = level + 1
            xpBar -= xpLimit
            xpLimit += 0.2 * xpLimit
            print("You leveled up!!\nWell done!!\n")
            print("You are now level " + str(level))
        score += 10
        return score
    # Check if you died
    if playerHealth <= 0:
        print("Too bad, YOU DIED!!!\n")


flag = 0
while flag < 3:
    item = input("Enter item: ")
    pickUpItem(item)
    flag += 1

os.system('cls')
# array = []
# while True:
#     item = input("Enter item: ")
#     array.insert(0, item)
#     print(array)

# print("\nYOU ESCAPED THE SCHOOL !!!\n")
# time.sleep(2)
# print("~~~~~~~~~~~~ YOU WIN ~~~~~~~~~~~~\n")
