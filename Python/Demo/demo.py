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

# Advanced Loops w/ Functions
destinations = [
    "Paris, France",
    "Shanghai, China",
    "Los Angeles, USA",
    "São Paulo, Brazil",
    "Cairo, Egypt"]

test_traveler = ['Erin Wilkes', 'Shanghai, China', ['historical site', 'art']]

attractions = [
    [],
    [],
    [],
    [],
    []
]


def get_destination_index(destination):
    return destinations.index(destination)


def get_traveler_location(traveler):
    traveler_location = traveler[1]
    return get_destination_index(traveler_location)


def add_attraction(destination, attraction):
    destination_index = get_destination_index(destination)
    attractions_for_destination = attractions[destination_index]
    attractions_for_destination.append(attraction)


def find_attractions(destination, interests):
    destination_index = get_destination_index(destination)
    attractions_in_city = attractions[destination_index]
    attractions_with_interest = []
    for possible_attraction in attractions_in_city:
        attractions_tags = possible_attraction[1]
        for interest in interests:
            if interest in attractions_tags:
                attractions_with_interest.append(possible_attraction[0])
    return attractions_with_interest


def get_attractions_for_traveler(traveler):
    traveler_destination = traveler[1]
    traveler_interests = traveler[2]
    traveler_attractions = find_attractions(
        traveler_destination, traveler_interests)
    interests_string = "Hi " + \
        traveler[0] + ", we think you'll like these places around " + \
        traveler_destination + ": "
    last_index = False
    for attraction in range(len(traveler_attractions)):
        if attraction == len(traveler_attractions) - 1:
            interests_string += (traveler_attractions[attraction] + ".")
        else:
            interests_string += (traveler_attractions[attraction] + ", ")
    return interests_string


print(get_destination_index("Los Angeles, USA"))
print(get_destination_index("Paris, France"))

test_destination_index = get_traveler_location(test_traveler)
print(test_destination_index)

print(attractions)

add_attraction("Los Angeles, USA", ["Venice Beach", ["beach"]])
print(attractions)

add_attraction("Paris, France", ["the Louvre", ["art", "museum"]])
add_attraction("Paris, France", ["Arc de Triomphe", [
               "historical site", "monument"]])
add_attraction("Shanghai, China", ["Yu Garden", [
               "garden", "historcical site"]])
add_attraction("Shanghai, China", ["Yuz Museum", ["art", "museum"]])
add_attraction("Shanghai, China", ["Oriental Pearl Tower", [
               "skyscraper", "viewing deck"]])
add_attraction("Los Angeles, USA", ["LACMA", ["art", "museum"]])
add_attraction("São Paulo, Brazil", ["São Paulo Zoo", ["zoo"]])
add_attraction("São Paulo, Brazil", ["Pátio do Colégio", ["historical site"]])
add_attraction("Cairo, Egypt", ["Pyramids of Giza", [
               "monument", "historical site"]])
add_attraction("Cairo, Egypt", ["Egyptian Museum", ["museum"]])
print(attractions)

la_arts = find_attractions("Los Angeles, USA", ["art"])
print(la_arts)

smills_france = get_attractions_for_traveler(
    ['Dereck Smill', 'Paris, France', ['monument']])
print(smills_france)

# Strings and String methods
highlighted_poems = "Afterimages:Audre Lorde:1997,  The Shadow:William Carlos Williams:1915, Ecstasy:Gabriela Mistral:1925,   Georgia Dusk:Jean Toomer:1923,   Parting Before Daybreak:An Qi:2014, The Untold Want:Walt Whitman:1871, Mr. Grumpledump's Song:Shel Silverstein:2004, Angel Sound Mexico City:Carmen Boullosa:2013, In Love:Kamala Suraiyya:1965, Dream Variations:Langston Hughes:1994, Dreamwood:Adrienne Rich:1987"

print(highlighted_poems)
print("------------------------------------------")

highlighted_poems_list = highlighted_poems.split(",")
print(highlighted_poems_list)
print("------------------------------------------")

highlighted_poems_stripped = [poem.strip() for poem in highlighted_poems_list]
print(highlighted_poems_stripped)
print("------------------------------------------")

highlighted_poems_details = [[detail for detail in details.split(":")] for details in highlighted_poems_stripped]
print(highlighted_poems_details)
print("------------------------------------------")

titles, poets, dates = [details[0] for details in highlighted_poems_details], [details[1] for details in highlighted_poems_details], [details[2] for details in highlighted_poems_details]

print("Titles:\n", titles, "\n\nPoets:\n", poets, "\n\nDates:\n",dates)
print("------------------------------------------")

for i in range(len(titles)):
  print("The poem {title} was published by {poet} in {date}".format(title=titles[i], poet=poets[i], date=dates[i]))
