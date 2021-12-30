print('Hello World!')

# Control Flow
my_name = "Anh"
if my_name == "Anh":
    print("hello")
elif my_name == "Phan":
    print("Hello!")
else:
    print("Who are you?")

# Lists
toppings = [
  "pepperoni",
  "pineapple",
  "cheese",
  "sausage",
  "olives",
  "anchovies",
  "mushrooms"
  ]

prices = [
  2,
  6,
  1,
  3,
  2,
  7,
  2
]

num_two_dollar_slices = prices.count(2)
print(num_two_dollar_slices)

num_pizzas = len(toppings)

print("We sell", num_pizzas, "different kinds of pizza!")

pizza_and_prices = list(zip(prices, toppings))
print(pizza_and_prices)

pizza_and_prices.sort() # or sorted_pizza_and_prices = sorted(pizza_and_prices)
print(pizza_and_prices)

cheapest_pizza = pizza_and_prices[0]

priciest_pizza = pizza_and_prices[-1]

pizza_and_prices.pop(-1)
pizza_and_prices.insert(4, [2.5, "peppers"])
print(pizza_and_prices)

three_cheapest = pizza_and_prices[:3]
print(three_cheapest)

# Tuples
my_info = ("Anh", 19, "College Student")
name, age, occupation = my_info
print(name, age, occupation)

# Loops
