def introduction():
  return "This is a sandwich!"

def make_sandwich():
  new_sandwich = [[]]
  add_bun(new_sandwich)
  add_topping(new_sandwich)
  add_patty(new_sandwich)
  return new_sandwich

def add_bun(order):
  bun = int(input("What kind of bun would you like?\n\t1. Regular\n\t2. Sesame\n\t3. Hot Dog\n\t4. Burger\n\t5. Kaiser"))
  while(True):
    match bun:
      case 1:
        order[0].append("Regular")
        break
      case 2:
        order[0].append("Sesame")
        break
      case 3:
        order[0].append("Hot Dog")
        break
      case 4:
        order[0].append("Burger")
        break
      case 5:
        order[0].append("Kaiser")
        break
      case _:
        print("Please choose a bun!\n")

def add_topping(order):
  topping = int(input("What kinds of topping would you like?\n\t1. Lettuce\n\t2. Tomato\n\t3. Onion\n\t4. Cheese\n\t5. Pickle\n\t6.Pepperoni\n\t7. Sauces"))
  cont = True
  while(cont):
      if (topping == 1):
        order[1].append("Lettuce")
      elif (topping == 2):
        order[1].append("Tomato")
      elif (topping == 3):
        order[1].append("Onion")
      elif (topping == 4):
        order[1].append("Cheese")
      elif (topping == 5):
        order[1].append("Pickle")
      elif (topping == 6):
        order[1].append("Pepperoni")
      elif (topping == 7):
        order[1].append("Sauces")
      else:
       choice = input("Do you want to choose another kind of topping? Y/n")
       if (choice == "N" or choice == "n"):
         cont = False

def add_patty(order):
  patty = int(input("What kind of bun would you like?\n\t1. Beef\n\t2. Chicken\n\t3. Pork\n\t4. Sausage\n\t5. Tofu\n\t6. Combo"))
  while(True):
    match patty:
      case 1:
        order[2].append("Beef")
        break
      case 2:
        order[2].append("Chicken")
        break
      case 3:
        order[2].append("Pork")
        break
      case 4:
        order[2].append("Sausage")
        break
      case 5:
        order[2].append("Tofu")
        break
      case 6:
        order[2].append("Combo")
        break
      case _:
        print("Please choose a patty!\n")