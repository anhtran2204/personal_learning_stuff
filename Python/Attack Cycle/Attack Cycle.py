import random
mobHealth = random.randint(50, 600)
xpGain = random.randint(1, (mobHealth * 2))
xpBar = 0
xpLimit = 100
level = 1
pName = input("Player, Welcome to the game!\nWhat is your name?\n")
while True:
    try:
        playerHealth = int(input("How much is your Health?\n"))
        break
    except ValueError:
        print("\nThis is not a number, did you even learn Math!\n")
if playerHealth > mobHealth:
    print("This is gonna be an easy fight!\n")
else:
    print("You're definitely gonna lose!!\n")

while mobHealth >= 1:
    turn1 = 0
    while turn1 == 0:
        userChoice = int(input("Do you want to block or attack?\n1 - Block\n2 - Attack\n3 - Special Attack\n"
                               "4 - Heal\n5 - Run away\n"))
        if userChoice == 1:
            mobAttack = random.randint(1, 50)
            print("You blocked " + str(mobAttack) + " damage!\n")
        elif userChoice == 2:
            while True:
                try:
                    userIn = int(input("How much is your attack?\n"))
                    break
                except ValueError:
                    print("\nI didn't understand that, stop saying nonsense!\n")
            while True:
                try:
                    userIn2 = int(input("What is your Hit Chance>\n"))
                    break
                except ValueError:
                    print("\nI didn't understand that, stop saying nonsense!\n")
            diceRoll = (random.randint(1, 5)) + userIn2
            if diceRoll >= 25:
                critChance = random.randint(1, 5)
                userAttack = userIn
                if critChance >= 4:
                    userAttack = userIn * 2
                    print("Critical Hit!!\nIt seems you ARE capable of fighting!\n")
                print("You hit the monster for " + str(userAttack) + "damage!\n")
                mobHealth = mobHealth - userAttack
                if mobHealth <= 0:
                    break
                print("The monster has " + str(mobHealth) + " health remaining!\n")
            else:
                print("You miss!\nHow pathetic.")
            mobAttack = random.randint(1, 50)
            critChance = random.randint(1, 10)
            if critChance >= 6:
                mobAttack = mobAttack * 2
                print("Critical Hit!!\nCan't believe you got hit by that.\n")
            newPlayerHealth = playerHealth - mobAttack
            print("The Monster hit you for " + str(mobAttack) + "!\n")
            if newPlayerHealth <= 0:
                break
            else:
                print("You have " + str(newPlayerHealth) + " health remaining.\n")
        elif userChoice == 3:
            specialSkills = ["Star Dust", "Meteor Rain", "Lightning Spear", "Inferno Storm", "Black Tsunami",
                             "Heavenly Judgement"]
            userAttack = random.randint(100, 250)
            print("You used the Special Skill: " + random.choice(specialSkills) + "!!!\n")
            mobHealth = mobHealth - userAttack
            if mobHealth <= 0:
                break
            print("You hit the monster for " + str(userAttack) + " damage!\n")
            print("The monster has " + str(mobHealth) + " health remaining!\n")
        elif userChoice == 4:
            playerHeal = random.randint(50, playerHealth)
            newPlayerHealth = playerHealth + playerHeal
            if newPlayerHealth >= playerHealth:
                print("Stop healing!!!\nYou've already reached maximum health!!\n")
                newPlayerHealth = newPlayerHealth + (playerHealth - newPlayerHealth)
                print("You regained " + str(playerHeal) + " health!\nYour current health is " +
                      str(newPlayerHealth))
            else:
                print("You regained " + str(playerHeal) + " health!\nYour current health is " +
                      str(newPlayerHealth))
        elif userChoice == 5:
            print("Woah, why are you running away???\nStop being such a weakling, go back and fight!\n")
        else:
            print("Please stop saying nonsense!!\n")
if mobHealth <= 0:
    print("You defeated the monster!!\nWell, that's the least you should be able to do.\n")
    print("Anyway, you gained " + str(xpGain) + " xp!")
    xpBar += xpGain
    if xpBar >= xpLimit:
        level = level + 1
        xpBar = xpBar - xpLimit
        xpLimit += 0.2 * xpLimit
        print("You leveled up!!\nWell done!!")
if playerHealth <= 0:
    print("Too bad, YOU DIED!!!\nStop being weak to win!")
