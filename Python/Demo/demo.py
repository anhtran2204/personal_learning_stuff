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

combined_list = toppings + prices
print("Combined List:", combined_list)

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
single_digits = range(10)
squares = []

for digit in single_digits:
  squares.append(digit ** 2)
  print(digit)

count = 0
length = len(single_digits)
while count < length:
  print("Hello")
  count += 1

print(squares)

cubes = [digit ** 3 for digit in single_digits]
print(cubes)

# Loops cont.

hairstyles = ["bouffant", "pixie", "dreadlocks", "crew", "bowl", "bob", "mohawk", "flattop"]

prices = [30, 25, 40, 20, 20, 35, 50, 35]

last_week = [2, 3, 5, 8, 4, 4, 6, 2]

total_price = 0

for price in prices: 
  total_price += price

average_price = total_price / len(prices)
print("Average Haircut Price:", average_price)

new_prices = [price - 5 for price in prices]
print(new_prices)

total_revenue = 0

for i in range(len(hairstyles)):
  total_revenue += prices[i] * last_week[i]

print("Total Revenue:", total_revenue)

average_daily_revenue = total_revenue / 7

cuts_under_30 = [hairstyles[i] for i in range(len(new_prices) - 1) if new_prices[i] < 30]
print(cuts_under_30)

