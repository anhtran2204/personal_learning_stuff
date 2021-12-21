import os
import time
import random


# Function to clear the console
def clear():
    os.system('cls||clear')


inventory = []
weapChoice = []
playerHealth = 200
xpBar = 0
xpLimit = 100
level = 1
zombieHealth = 0


# Combat with monster
# Edit for player to
# meet different kinds
# of zombies.
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
                        print("\nEquipped " + str(bagItem) + "...\n")
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
            print("You are now level " + str(level) + "\n")
        score += 10
        return score
    # Check if you died
    if playerHealth <= 0:
        print("Too bad, YOU DIED!!!\n")


# Function to pick up items in rooms
def pickUpItem(items):
    if items in inventory:
        print("\nYou already picked it up.\n")
        time.sleep(2)
    else:
        print("You found " + str(items) + "!\n")
        stop = False
        while not stop:
            pickUp = input("Do you want to pick it up.\nyes/no\n").lower()
            if pickUp == "yes":
                inventory.append(items)
                print("\nYou acquired the " + str(items) + "!\n")
                stop = True
                time.sleep(2)
            elif pickUp == "no":
                print("Maybe later then.\n")
                stop = True
                time.sleep(2)
            else:
                print("I don't understand.\n")


# Function for the game itself
def game():
    # Initial setup for responses
    yes_no = ["yes", "no"]
    direction = ["left", "right", "forward", "backward", "up", "down"]

    # Intro Get Player Name
    name = input("What is your name?\n")
    time.sleep(2)
    print("\nHey, " + name + ". I hope you're ready.\n")
    time.sleep(2)
    print("Time to go....\n")
    time.sleep(2)

    # Game Start
    response = ""
    # loop continues until a correct response is given
    while response not in yes_no:
        response = input("Would you like to start?\nyes/no\n")
        response = response.lower()
        if response == "yes":
            print("")
        elif response == "no":
            print("Maybe later then.\n")
            quit()
        else:
            # error message for bad responses
            print("I don't understand.\n")

    time.sleep(2)
    clear()

    # Instructions that the directions should be like
    # how we move in real life, such as you go left to another
    # hallway, but you go backward to get back to that first hallway.#
    print("\nWarning!")
    time.sleep(2)
    print("You should based the directions on how you normally walk, not based on the game.\n")
    time.sleep(2)
    clear()

    # Background
    print("\nYou wake up and find yourself in a school. ")
    time.sleep(2)
    print("The classroom is empty but there are crashing sounds in the hall. ")
    time.sleep(2)
    print("What do you do?\n")
    time.sleep(2)

    player_loc = "algebra 1"
    turn = 10
    score = 0

    while turn > 0:
        # Message every turn
        print("The sounds are getting closer...\n")
        time.sleep(2)

        # GROUND FLOOR
        if player_loc == "algebra 1":  # Starting room
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("You're in the algebra classroom #1 on the ground floor. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 2
                    player_loc = "first hallway upper"  # went to 1st hall upper
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    pickUpItem("handgun")  # pick up gun
                    pickUpItem("first aid kit")
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # First hallway after going left from algebra #1
        if player_loc == "first hallway upper":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the upper part of first hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "math class 1"  # went left to go back to math classroom #1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "garden"  # went to garden
                    score = combat()
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn -= 1
                    player_loc = "first hallway lower"  # went forward to lower part 1st hall
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn += 1
                    player_loc = "canteen"  # went backward to canteen
                    score = combat()
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Lower part of the first hallway after going forward
        # from the upper part.
        if player_loc == "first hallway lower":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the lower part of first hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "algebra 2"  # went left to algebra 2
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "second hallway"  # went right to second hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    player_loc = "algebra 3"  # went forward to algebra 3
                    score = combat()
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "first hallway upper"  # went backward to 1st hall upper
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Algebra 2 classroom after going left from the lower part
        # of the first hallway.
        if player_loc == "algebra 2":  # Room has zombie
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the algebra classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    pickUpItem("machine gun")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    turn -= 1
                    player_loc = "first hallway lower"  # went right to 1st hall lower
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Algebra 3 classroom after going forward
        # from the lower part of the first hallway.
        if player_loc == "algebra 3":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the algebra classroom #3. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    player_loc = "first hallway lower"  # went backward to 1st hall lower
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Second hallway after going right
        # from the lower part of first hallway
        if player_loc == "second hallway":
            subMathClass = ["pre cal 1", "pre cal 2", "geometry"]
            chooseSubMath = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the second hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseSubMath not in subMathClass:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three other rooms.\nDo you want to open them?\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSubMath = int(input("\nWhich door do you want to open? 1, 2 or 3?\n"))
                                if chooseSubMath == 1:
                                    player_loc = "pre cal 1"  # 1st room is pre cal 1
                                    time.sleep(2)
                                    break
                                elif chooseSubMath == 2:
                                    player_loc = "pre cal 2"  # 2nd room, next to 1st, is pre cal 2
                                    time.sleep(2)
                                    break
                                elif chooseSubMath == 3:
                                    player_loc = "geometry"  # 3rd room, next to 2nd, is geometry
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "garden"  # went right to garden
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1

                    player_loc = "third hallway"  # went forward to third hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "first hallway lower"  # went backward to lower 1st hall
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Pre cal 1 classroom after
        # going left from the second hallway.
        if player_loc == "pre cal 1":
            response = ""
        while response not in direction:
            if turn <= 0:
                time.sleep(2)
                break
            time.sleep(2)
            response = input("\nYou're in the pre-cal classroom 1. \nWhere would you like to "
                             "go?\nleft/right/forward/backward\n")
            response = response.lower()
            if response == "left":
                print("\nYou went left.\n")
                time.sleep(2)
                pickUpItem("katana")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "right":
                print("\nYou went right.\n")
                turn -= 1
                player_loc = "second hallway"  # went right to second hallway
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "forward":
                print("\nYou went forward.\n")
                time.sleep(2)
                score = combat()
                print("Score: " + str(score))
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "backward":
                print("\nYou went backward.\n")
                time.sleep(2)
                score = combat()
                print("Score: " + str(score))
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "up":
                print("\nYou went up.\n")
                time.sleep(2)
                print("There're no stairs to go up.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "down":
                print("\nYou went down.\n")
                time.sleep(2)
                print("You're already on the ground floor.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "restart":
                restartGame = input("Do you want to restart? yes/no\n").lower()
                if restartGame == "yes":
                    time.sleep(2)
                    print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                    restart(True)
                    time.sleep(2)
                elif restartGame == "no":
                    time.sleep(2)
                    print("\nContinuing....\n")
                    restart(False)
                    time.sleep(2)
                else:
                    print("I don't understand.\n")
            else:
                print("I don't understand.\n")
                turn -= 3
                print("Turns left: " + str(turn))
                time.sleep(2)

        # Pre cal 2 classroom after
        # going left from the second hallway.
        if player_loc == "pre cal 2":
            response = ""
        while response not in direction:
            if turn <= 0:
                time.sleep(2)
                break
            time.sleep(2)
            response = input("\nYou're in the pre-cal classroom 2. \nWhere would you like to "
                             "go?\nleft/right/forward/backward\n")
            response = response.lower()
            if response == "left":
                print("\nYou went left.\n")
                time.sleep(2)
                print("There's nothing here.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "right":
                print("\nYou went right.\n")
                turn -= 1
                player_loc = "second hallway"  # went right to second hallway
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "forward":
                print("\nYou went forward.\n")
                time.sleep(2)
                print("There's nothing here.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "backward":
                print("\nYou went backward.\n")
                time.sleep(2)
                print("There's nothing here.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "up":
                print("\nYou went up.\n")
                time.sleep(2)
                print("There're no stairs to go up.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "down":
                print("\nYou went down.\n")
                time.sleep(2)
                print("You're already on the ground floor.\n")
                turn -= 1
                print("Turns left: " + str(turn))
                time.sleep(2)
            elif response == "restart":
                restartGame = input("Do you want to restart? yes/no\n").lower()
                if restartGame == "yes":
                    time.sleep(2)
                    print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                    restart(True)
                    time.sleep(2)
                elif restartGame == "no":
                    time.sleep(2)
                    print("\nContinuing....\n")
                    restart(False)
                    time.sleep(2)
                else:
                    print("I don't understand.\n")
            else:
                print("I don't understand.\n")
                turn -= 3
                print("Turns left: " + str(turn))
                time.sleep(2)

        # Pre cal 3 classroom after
        # going left from the second hallway.
        if player_loc == "geometry":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the geometry classroom. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    player_loc = "second hallway"  # went right to second hallway
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Garden after going right from upper part of
        # first hallway, or going right from second hallway
        # or going right from third hallway or going right
        # from fourth hallway.
        if player_loc == "garden":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the garden. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "second hallway"  # went left to second hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "fourth hallway"  # went right to fourth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    player_loc = "third hallway"  # went forward to third hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "first hallway"  # went backward to first hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Third hallway after going forward from
        # the second hallway.
        if player_loc == "third hallway":
            advMathClass = ["calc 1", "calc 2", "stats"]
            chooseAdvMath = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the third hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseAdvMath not in advMathClass:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three doors.\nDo you want to open them?\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseAdvMath = int(input("\nWhich door do you want to open? 1, 2 or 3?\n"))
                                if chooseAdvMath == 1:
                                    player_loc = "calc 1"  # 1st room is calculus 1
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseAdvMath == 2:
                                    player_loc = "calc 2"  # 2nd room, next to 1st, is calculus 2
                                    time.sleep(2)
                                    break
                                elif chooseAdvMath == 3:
                                    player_loc = "stats"  # 3rd room, next to 2nd, is stats
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "garden"  # went right to garden
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "fourth hallway"  # went forward to fourth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "second hallway"  # went backward to second hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    score = combat()
                    print("Score: " + str(score))
                    turn += 1
                    player_loc = "eleventh hallway"  # went upstairs to eleventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Calculus #1 after going left from third hallway
        if player_loc == "calc 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the calculus classroom #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "third hallway"  # went right to third hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("SMG")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    time.sleep(2)
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Calculus #2 after going left from third hallway
        if player_loc == "calc 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the calculus classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "third hallway"  # went right to third hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Stats classroom after going left from third hallway
        if player_loc == "stats":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the statistics classroom. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "third hallway"  # went right to third hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Fourth hallway after going forward from third hallway
        # or from going right from the garden
        if player_loc == "fourth hallway":
            sciClassLeft = ["sci 2", "sci 4", "fourth hallway wc"]
            sciClassRight = ["sci 1", "sci 3"]
            chooseSci = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the fourth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseSci not in sciClassLeft:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see two doors.\nDo you want to open them?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSci = int(input("\nWhich door do you want to open? 1, 2 or 3?\n"))
                                if chooseSci == 1:
                                    player_loc = "sci 2"  # 1st room on the left of hallway is science 1
                                    time.sleep(2)
                                    break
                                elif chooseSci == 2:
                                    player_loc = "sci 4"  # 2nd room on right of hallway is science 4
                                    time.sleep(2)
                                    break
                                elif chooseSci == 3:
                                    player_loc = "fourth hallway wc"  # 3rd room on the right of hallway is wc
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseSci not in sciClassRight:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see two doors.\nDo you want to open them?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSci = int(input("\nWhich door do you want to open? 1 or 2?\n"))
                                if chooseSci == 1:
                                    player_loc = "sci 1"  # 1st room on the right of hallway is science 1
                                    time.sleep(2)
                                    break
                                elif chooseSci == 2:
                                    player_loc = "sci 3"  # 2nd room on the right of hallway is science 3
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "canteen"  # went forward to canteen
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "third hallway"  # went backward to third hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("You went up.")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "ninth hallway"  # went upstairs to ninth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # 4th hallway WC after going left from
        # fourth hallway.
        if player_loc == "fourth hallway wc":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the fourth hallway WC. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "fourth hallway"  # went right to fourth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Science #1 after going right from fourth hallway #
        if player_loc == "sci 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the science classroom #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    player_loc = "fourth hallway"  # went left to fourth hallway
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("machete")
                    pickUpItem("ammo")
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Science #2 after going left from fourth hallway #
        if player_loc == "sci 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the science classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "fourth hallway"  # went right to fourth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Science #3 after going right fourth hallway #
        if player_loc == "sci 3":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the science classroom #3. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    player_loc = "fourth hallway"  # went left to fourth hallway
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    print("There's nothing here.\n")
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Science #4 after going left from fourth hallway #
        if player_loc == "sci 4":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the science classroom #4. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "fourth hallway"  # went right to fourth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Canteen after going forward from fourth hallway,
        # or going backward from upper part of first hallway
        if player_loc == "canteen":
            canteenDirectionLeft = ["canteen wc", "back door 1"]
            canteenDirectionRight = ["main hall", "fifth hallway upper"]
            chooseCanteenDirection = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the canteen. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseCanteenDirection not in canteenDirectionLeft:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see two doors.\nDo you want to open them?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseCanteenDirection = int(input("\nWhich doors do you want to open?\n"))
                                if chooseCanteenDirection == 1:
                                    player_loc = "canteen wc"  # 1st room on left
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseCanteenDirection == 2:
                                    player_loc = "back door 1"  # next to canteen wc
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseCanteenDirection not in canteenDirectionRight:
                        if turn <= 0:
                            time.sleep(2)
                            break

                        time.sleep(2)
                        clear()

                        chooseCanteenDirection = int(
                            input("\nYou see two paths.\nWhich path do you want to go?\n1/2\n"))
                        if chooseCanteenDirection == 1:
                            player_loc = "main hallway"  # 1st path on right
                            time.sleep(2)

                            break
                        elif chooseCanteenDirection == 2:
                            player_loc = "fifth hallway upper"  # 2nd path on right
                            time.sleep(2)
                            break
                        else:
                            print("I don't understand.\n")
                            time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "seventh hallway"  # went forward to seventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "fourth hallway"  # went backward to fourth hallway
                    pickUpItem("ammo")
                    pickUpItem("grenade")
                    pickUpItem("grenade")
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Main hallway after going left from canteen
        if player_loc == "main hallway":
            mainHallOffice = ["nurses office", "attendance office"]
            chooseMainHallOffice = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the main hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "fifth hallway upper"  # went left to upper part of fifth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseMainHallOffice not in mainHallOffice:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see two doors.\nDo you want to open them?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseMainHallOffice = int(input("\nWhich door do you want to open? 1 or 2?\n"))
                                if chooseMainHallOffice == 1:
                                    player_loc = "nurses office"  # 1st room on the right
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseMainHallOffice == 2:
                                    player_loc = "attendance office"  # 2nd room on the right
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "main door"  # went forward to main door, which is winning condition
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "canteen"  # went backward to canteen
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Attendance office after going right from the main hallway #
        if player_loc == "attendance office":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the attendance office. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "main hallway"  # went left to main hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Nurses office after going right from the main hallway #
        if player_loc == "nurses office":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the nurses office. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "main hallway"  # went left to main hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("first aid kit")
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Upper part of fifth hallway after
        # going right from the canteen
        if player_loc == "fifth hallway upper":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the upper part of fifth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "gym"  # went left to gym
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "main hallway"  # went right to main hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "fifth hallway lower"  # went forward to lower part of fifth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "canteen"
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Lower of fifth hallway after
        # going forward from
        # upper part of fifth hallway
        if player_loc == "fifth hallway lower":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the lower part of fifth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1

                    player_loc = "sixth hallway"  # went left to sixth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "sixth hallway wc"  # went forward to sixth hallway wc
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "fifth hallway upper"  # went backward to lower part of fifth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Sixth hallway after going forward
        # from lower part of fifth hallway
        if player_loc == "sixth hallway":
            facultyOffice = ["counselor office", "v-p office", "principal office"]
            chooseFaculty = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the sixth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)

                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseFaculty not in facultyOffice:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three other open.\nDo you want to open them them?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSci = int(input("Which door do you want to open?\n"))
                                if chooseSci == 1:
                                    player_loc = "counselor office"  # 1st room on the right of sixth hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSci == 2:
                                    player_loc = "v-p office"  # 2nd room on the right of sixth hallway
                                    time.sleep(2)
                                    break
                                elif chooseSci == 3:
                                    player_loc = "principal office"  # 3rd room on the right of sixth hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "auditorium"  # went forward to auditorium
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "fifth hallway lower"  # went backward to lower part of fifth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Counselor office after going right from sixth hallway #
        if player_loc == "counselor office":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the counselor office. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "sixth hallway"  # went left to sixth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    pickUpItem("ammo")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("first aid kit")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Vice-principal office after going right from the sixth hallway #
        if player_loc == "v-p office":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the vice-principal office. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "sixth hallway"  # went left to sixth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("assault rifle")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Principal office after going right from sixth hallway.
        if player_loc == "principal office":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the principal office. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "sixth hallway"  # went left to sixth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Seventh hallway after going forward from sixth hallway
        if player_loc == "seventh hallway":
            seventhHallLeft = ["seventh hallway wc", "back door 2"]
            choose7thHallLeft = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the seventh hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while choose7thHallLeft not in seventhHallLeft:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see two doors.\nDo you want to open them?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                choose7thHallLeft = int(input("\nWhich door do you want to open?\n"))
                                if choose7thHallLeft == 1:
                                    player_loc = "seventh hallway wc"  # 1st room on the right of seventh hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif choose7thHallLeft == 2:
                                    player_loc = "back door 2"  # 2nd room on the right of seventh hallway
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "gym"
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "eighth hallway"  # went forward to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "canteen"  # went backward to canteen
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("You went upstairs")
                    turn += 1
                    player_loc = "tenth hallway"  # went upstairs to tenth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Gym after going left from upper part of fifth hallway,
        # or going left from sixth hallway, or going right
        # from seventh hallway.
        if player_loc == "gym":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the gym. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "seventh hallway"  # went left to seventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    player_loc = "sixth hallway"  # went right to sixth hallway
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    player_loc = "fifth hallway upper"  # went backward to lower part of fifth hallway
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Eighth hallway after going forward from seventh hallway
        if player_loc == "eighth hallway":
            engClass = ["eng 1", "eng 2", "eng 3", "eng 4"]
            chooseEng = ""
            socialClass = ["social 1", "social 2", "social 3"]
            chooseSocial = ""

            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the eighth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseEng not in engClass:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see four other rooms.\nDo you want to go in?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseEng = int(input("Which room do you want to go in?\n"))
                                if chooseEng == 1:
                                    player_loc = "eng 1"  # 1st room on the left of 8th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseEng == 2:
                                    player_loc = "eng 2"  # 2nd room on the left of 8th hallway
                                    time.sleep(2)
                                    break
                                elif chooseEng == 3:
                                    player_loc = "eng 3"  # 3rd room on the left of 8th hallway
                                    time.sleep(2)
                                    break
                                elif chooseEng == 4:
                                    player_loc = "eng 4"  # 4th room on the left of 8th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseSocial not in socialClass:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three other rooms.\nDo you want to go in?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSocial = int(input("Which room do you want to go in?\n"))
                                if chooseSocial == 1:
                                    player_loc = "social 1"  # 1st room on the right of 8th hallway
                                    time.sleep(2)
                                    break
                                elif chooseSocial == 2:
                                    player_loc = "social 2"  # 2nd room on the right of 8th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSocial == 3:
                                    player_loc = "social 3"  # 3rd room on the right of 8th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSocial == 4:
                                    player_loc = "eighth hallway wc"  # 4th room on the right of 8th hallway
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "auditorium"  # went forward to auditorium
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "seventh hallway"  # went backward to seventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Eighth hallway after going right from eighth hallway
        if player_loc == "eighth hallway wc":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the eighth hallway WC. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "eighth hallway"  # went left to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # English classroom #1 after going left
        # from the 8th hallway
        if player_loc == "eng 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the english classroom #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "eighth hallway"  # went right to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # English classroom #2 after going left
        # from the 8th hallway
        if player_loc == "eng 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the english classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "eighth hallway"  # went right to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # English classroom #3 after going left
        # from the 8th hallway
        if player_loc == "eng 3":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the english classroom #3. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "eighth hallway"  # went right to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # English classroom #4 after going left
        # from the 8th hallway
        if player_loc == "eng 4":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the english classroom #4. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "eighth hallway"  # went right to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Social studies classroom #1 after going right
        # from the 8th hallway
        if player_loc == "social 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the social studies classroom #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "eighth hallway"  # went left to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("sniper rifle")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Social studies classroom #2 after going right
        # from the 8th hallway
        if player_loc == "social 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the social studies classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "eighth hallway"  # went left to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Social studies classroom #3 after going right
        # from the 8th hallway
        if player_loc == "social 3":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the social studies classroom #3. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "eighth hallway"  # went left to eighth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("baseball bat")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Auditorium after going forward from sixth hallway
        if player_loc == "auditorium":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the auditorium. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "sixth hallway"  # went left back to sixth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    player_loc = "eighth hallway"  # went right back to eighth hallway
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("chainsaw")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # FIRST FLOOR

        # Ninth hallway after going upstairs from the fourth hallway
        if player_loc == "ninth hallway":
            fineArtsClass = ["fine arts 1", "fine arts 2", "fine arts 3"]
            chooseFineArts = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the ninth hallway on the first floor. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseFineArts not in fineArtsClass:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three other rooms.\nDo you want to go in?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseFineArts = int(input("\nWhich room do you want to go in?\n"))
                                if chooseFineArts == 1:
                                    player_loc = "fine arts 1"  # 1st room on the left of 9th hallway
                                    time.sleep(2)
                                    break
                                elif chooseFineArts == 2:
                                    player_loc = "fine arts 2"  # 2nd room on the left of 9th hallway
                                    time.sleep(2)
                                    break
                                elif chooseFineArts == 3:
                                    player_loc = "fine arts 3"  # 3rd room on the left of 9th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "tenth hallway"  # went forward to tenth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("You went downstairs.")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "fourth hallway"
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Fine arts classroom #1 after
        # going left from ninth hallway
        if player_loc == "fine arts 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the fine arts classroom #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)

                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "ninth hallway"  # went right back to ninth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Fine arts classroom #2 after
        # going left from ninth hallway
        if player_loc == "fine arts 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the fine arts classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "ninth hallway"  # went right back to ninth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Fine arts classroom #3 after
        # going left from ninth hallway
        if player_loc == "fine arts 3":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the fine arts classroom #3. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "ninth hallway"  # went right back to ninth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Eleventh hallway after going
        # upstairs from third hallway
        if player_loc == "eleventh hallway":
            facultyOffice = ["LOTE 1", "LOTE 2", "LOTE 3"]
            chooseFaculty = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the eleventh hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)

                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseFaculty not in facultyOffice:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three other rooms.\nDo you want to go in?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSci = int(input("Which room do you want to go in?\n"))
                                if chooseSci == 1:
                                    player_loc = "LOTE 1"  # 1st room on the right of 11th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSci == 2:
                                    player_loc = "LOTE 2"  # 2nd room on the right of 11th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSci == 3:
                                    player_loc = "LOTE 3"  # 3rd room on the right of 11th hallway
                                    time.sleep(2)
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "twelfth hallway"  # went forward to twelfth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("You went downstairs.")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "third hallway"
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Language other than English classroom #1
        # after going right from eleventh hallway
        if player_loc == "LOTE 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the foreign languages classroom #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "eleventh hallway"  # went left to eleventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Language other than English classroom #2
        # after going right from eleventh hallway
        if player_loc == "LOTE 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the foreign languages classroom #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "eleventh hallway"  # went left to eleventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("ammo")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Language other than English classroom #3
        # after going right from eleventh hallway
        if player_loc == "LOTE 3":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the foreign languages classroom #3. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "eleventh hallway"  # went left to eleventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("ammo")
                    pickUpItem("first aid kit")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Tenth hallway after going forward from ninth hallway
        # or from going upstairs from seventh hallway
        if player_loc == "tenth hallway":
            stemLab = ["STEM lab 1", "STEM lab 2"]
            chooseSTEM = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the tenth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    while chooseSTEM not in stemLab:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see two other rooms.\nDo you want to go in?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSTEM = int(input("\nWhich room do you want to go in?\n"))
                                if chooseSTEM == 1:
                                    player_loc = "STEM lab 1"  # 1st room on the left of tenth hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSTEM == 2:
                                    player_loc = "STEM lab 2"  # 2nd room on the left of tenth hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "library"  # went forward to library
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "ninth hallway"  # went backward to ninth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("You went downstairs.")
                    turn -= 1
                    player_loc = "seventh hallway"
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # STEM lab #1 after going left from tenth hallway
        if player_loc == "STEM lab 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the STEM lab #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "tenth hallway"  # went right to tenth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # STEM lab #2 after going left from tenth hallway
        if player_loc == "STEM lab 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the STEM lab #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "tenth hallway"  # went right to tenth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Twelfth hallway after going forward from eleventh hallway
        if player_loc == "twelfth hallway":
            computerLab = ["twelfth hallway wc", "computer lab 1", "computer lab 2"]
            chooseComputerLab = ""
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the twelfth hallway. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    while chooseComputerLab not in computerLab:
                        if turn <= 0:
                            time.sleep(2)
                            break
                        while response not in yes_no:
                            time.sleep(2)
                            response = input("\nYou see three other rooms.\nDo you want to go in?\n\nyes/no\n")
                            response = response.lower()
                            if response == "yes":
                                print("")

                                time.sleep(2)
                                clear()

                                chooseSci = int(input("\nWhich room do you want to go in?\n"))
                                if chooseSci == 1:
                                    player_loc = "twelfth hallway wc"  # 1st room on the right of 12th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                elif chooseSci == 2:
                                    player_loc = "computer lab 1"  # 2nd room on the right of 12th hallway
                                    time.sleep(2)
                                    break
                                elif chooseSci == 3:
                                    player_loc = "computer lab 2"  # 3rd room on the right of 12th hallway
                                    time.sleep(2)
                                    score = combat()
                                    print("Score: " + str(score))
                                    break
                                else:
                                    print("I don't understand.\n")
                                    time.sleep(2)
                            elif response == "no":
                                print("Maybe later then.\n")
                                time.sleep(2)
                                break
                            else:
                                # error message for bad responses
                                print("I don't understand.\n")
                                time.sleep(2)
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "library"  # went forward to library
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "eleventh hallway"  # went backward to eleventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Twelfth hallway WC after going
        # right from twelfth hallway
        if player_loc == "twelfth hallway wc":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the twelfth hallway WC. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "twelfth hallway"  # went left to twelfth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("sniper rifle")
                    pickUpItem("first aid kit")
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Computer lab #1 after going
        # right from twelfth hallway
        if player_loc == "computer lab 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the computer lab #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "twelfth hallway"  # went left to twelfth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Computer lab #2 after going
        # right from twelfth hallway
        if player_loc == "computer lab #2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the computer lab #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "twelfth hallway"  # went left to twelfth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    print("There's nothing here.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("grenade")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Library after going forward from tenth hallway
        # or going forward from twelfth hallway
        if player_loc == "library":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're in the library. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "tenth hallway"  # went left back to tenth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "twelfth hallway"  # went right back to twelfth hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("No stairs to go down.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        #  SPORTS FIELD

        # Back door #1 after going left from canteen
        # or going left from back door #2
        if player_loc == "back door 1":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're at back door #1. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "tennis court"  # went left to tennis court
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn += 1
                    player_loc = "back door 2"  # went right to back door 2
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "baseball field"  # went forward to baseball field
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "canteen"  # went backward to canteen
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Back door #2 after going left from seventh hallway
        # or going right from back door #1
        if player_loc == "back door 2":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're at back door #2. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn += 1
                    player_loc = "back door 1"  # went left to back door 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    pickUpItem("ammo")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn += 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "football field"  # went forward to football field
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "seventh hallway"  # went backward to seventh hallway
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the ground floor.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Baseball field after going forward
        # from back door #1, or going right
        # from tennis court, or going left from
        # football field
        if player_loc == "baseball field":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're at the baseball field. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n\n")
                    turn -= 1
                    player_loc = "tennis court"  # went left to tennis court
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "football field"  # went right to football field
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("shotgun")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    player_loc = "back door 1"  # went backward to back door 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the baseball field.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Tennis court after going left from back door #1,
        # or going left from baseball field
        if player_loc == "tennis court":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're at the tennis court. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    turn -= 1
                    player_loc = "baseball field"  # went right to baseball field
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    player_loc = "back door 1"  # went backward to back door 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the tennis court.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Football field after going right
        # from back door 2, or going right
        # from baseball field.
        if player_loc == "football field":
            response = ""
            while response not in direction:
                if turn <= 0:
                    time.sleep(2)
                    break
                time.sleep(2)
                response = input("\nYou're at football field. \nWhere would you like to "
                                 "go?\nleft/right/forward/backward\n")
                response = response.lower()
                if response == "left":
                    print("\nYou went left.\n")
                    turn -= 1
                    player_loc = "baseball field"  # went left to baseball field
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "right":
                    print("\nYou went right.\n")
                    time.sleep(2)
                    score = combat()
                    print("Score: " + str(score))
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "forward":
                    print("\nYou went forward.\n")
                    time.sleep(2)
                    pickUpItem("flashbang")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "backward":
                    print("\nYou went backward.\n")
                    turn -= 1
                    score = combat()
                    print("Score: " + str(score))
                    player_loc = "back door 2"  # went backward to back door 2
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "up":
                    print("\nYou went up.\n")
                    time.sleep(2)
                    print("There're no stairs to go up.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "down":
                    print("\nYou went down.\n")
                    time.sleep(2)
                    print("You're already on the fooball field.\n")
                    turn -= 1
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)
                elif response == "restart":
                    restartGame = input("\nDo you want to restart? yes/no\n").lower()
                    if restartGame == "yes":
                        time.sleep(2)
                        print("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")
                        time.sleep(2)
                        restart(True)
                    elif restartGame == "no":
                        time.sleep(2)
                        print("\nContinuing....\n")
                        time.sleep(2)
                        restart(False)
                    else:
                        print("I don't understand.\n")
                else:
                    print("I don't understand.\n")
                    turn -= 3
                    print("Score: " + str(score))
                    print("Turns left: " + str(turn) + "\n")
                    time.sleep(2)

        # Winning Condition
        if player_loc == "main door":
            print("\nYOU ESCAPED THE SCHOOL !!!\n")
            time.sleep(2)
            print("~~~~~~~~~~~~ YOU WIN. ~~~~~~~~~~~~\n")
            time.sleep(2)
            print("Final score: " + str(score) + "\n")

    # Lose
    print("\nYou ran out of turns.\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n")


# Restart the game
def restart(restartGame):
    if restartGame:
        print("\n************ NEW GAME ************\n")
        game()


# Game Start
game()
