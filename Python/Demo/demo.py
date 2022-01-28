from sandwiches import make_sandwich
import sys
sys.path.append(
    "C:/Users/anhph/OneDrive/Documents/GitHub/personal_learning_stuff/Python/Sandwiches")


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

pizza_and_prices.sort()  # or sorted_pizza_and_prices = sorted(pizza_and_prices)
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

hairstyles = ["bouffant", "pixie", "dreadlocks",
              "crew", "bowl", "bob", "mohawk", "flattop"]

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

cuts_under_30 = [hairstyles[i]
                 for i in range(len(new_prices) - 1) if new_prices[i] < 30]
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

highlighted_poems_details = [[detail for detail in details.split(
    ":")] for details in highlighted_poems_stripped]
print(highlighted_poems_details)
print("------------------------------------------")

titles, poets, dates = [details[0] for details in highlighted_poems_details], [
    details[1] for details in highlighted_poems_details], [details[2] for details in highlighted_poems_details]

print("Titles:\n", titles, "\n\nPoets:\n", poets, "\n\nDates:\n", dates)
print("------------------------------------------")

for i in range(len(titles)):
    print("The poem {title} was published by {poet} in {date}".format(
        title=titles[i], poet=poets[i], date=dates[i]))

# Strings and String methods cont.
daily_sales = \
    """Edith Mcbride   ;,;$1.21   ;,;   white ;,; 
09/15/17   ,Herbert Tran   ;,;   $7.29;,; 
white&blue;,;   09/15/17 ,Paul Clarke ;,;$12.52 
;,;   white&blue ;,; 09/15/17 ,Lucille Caldwell   
;,;   $5.13   ;,; white   ;,; 09/15/17,
Eduardo George   ;,;$20.39;,; white&yellow 
;,;09/15/17   ,   Danny Mclaughlin;,;$30.82;,;   
purple ;,;09/15/17 ,Stacy Vargas;,; $1.85   ;,; 
purple&yellow ;,;09/15/17,   Shaun Brock;,; 
$17.98;,;purple&yellow ;,; 09/15/17 , 
Erick Harper ;,;$17.41;,; blue ;,; 09/15/17, 
Michelle Howell ;,;$28.59;,; blue;,;   09/15/17   , 
Carroll Boyd;,; $14.51;,;   purple&blue   ;,;   
09/15/17   , Teresa Carter   ;,; $19.64 ;,; 
white;,;09/15/17   ,   Jacob Kennedy ;,; $11.40   
;,; white&red   ;,; 09/15/17, Craig Chambers;,; 
$8.79 ;,; white&blue&red   ;,;09/15/17   , Peggy Bell;,; $8.65 ;,;blue   ;,; 09/15/17,   Kenneth Cunningham ;,;   $10.53;,;   green&blue   ;,; 
09/15/17   ,   Marvin Morgan;,;   $16.49;,; 
green&blue&red   ;,;   09/15/17 ,Marjorie Russell 
;,; $6.55 ;,;   green&blue&red;,;   09/15/17 ,
Israel Cummings;,;   $11.86   ;,;black;,;  
09/15/17,   June Doyle   ;,;   $22.29 ;,;  
black&yellow ;,;09/15/17 , Jaime Buchanan   ;,;   
$8.35;,;   white&black&yellow   ;,;   09/15/17,   
Rhonda Farmer;,;$2.91 ;,;   white&black&yellow   
;,;09/15/17, Darren Mckenzie ;,;$22.94;,;green 
;,;09/15/17,Rufus Malone;,;$4.70   ;,; green&yellow 
;,; 09/15/17   ,Hubert Miles;,;   $3.59   
;,;green&yellow&blue;,;   09/15/17   , Joseph Bridges  ;,;$5.66   ;,; green&yellow&purple&blue 
;,;   09/15/17 , Sergio Murphy   ;,;$17.51   ;,;   
black   ;,;   09/15/17 , Audrey Ferguson ;,; 
$5.54;,;black&blue   ;,;09/15/17 ,Edna Williams ;,; 
$17.13;,; black&blue;,;   09/15/17,   Randy Fleming;,;   $21.13 ;,;black ;,;09/15/17 ,Elisa Hart;,; $0.35   ;,; black&purple;,;   09/15/17   ,
Ernesto Hunt ;,; $13.91   ;,;   black&purple ;,;   
09/15/17,   Shannon Chavez   ;,;$19.26   ;,; 
yellow;,; 09/15/17   , Sammy Cain;,; $5.45;,;   
yellow&red ;,;09/15/17 ,   Steven Reeves ;,;$5.50   
;,;   yellow;,;   09/15/17, Ruben Jones   ;,; 
$14.56 ;,;   yellow&blue;,;09/15/17 , Essie Hansen;,;   $7.33   ;,;   yellow&blue&red
;,; 09/15/17   ,   Rene Hardy   ;,; $20.22   ;,; 
black ;,;   09/15/17 ,   Lucy Snyder   ;,; $8.67   
;,;black&red  ;,; 09/15/17 ,Dallas Obrien ;,;   
$8.31;,;   black&red ;,;   09/15/17,   Stacey Payne 
;,;   $15.70   ;,;   white&black&red ;,;09/15/17   
,   Tanya Cox   ;,;   $6.74   ;,;yellow   ;,; 
09/15/17 , Melody Moran ;,;   $30.84   
;,;yellow&black;,;   09/15/17 , Louise Becker   ;,; 
$12.31 ;,; green&yellow&black;,;   09/15/17 ,
Ryan Webster;,;$2.94 ;,; yellow ;,; 09/15/17 
,Justin Blake ;,; $22.46   ;,;white&yellow ;,;   
09/15/17,   Beverly Baldwin ;,;   $6.60;,;   
white&yellow&black ;,;09/15/17   ,   Dale Brady   
;,;   $6.27 ;,; yellow   ;,;09/15/17 ,Guadalupe Potter ;,;$21.12   ;,; yellow;,; 09/15/17   , 
Desiree Butler ;,;$2.10   ;,;white;,; 09/15/17  
,Sonja Barnett ;,; $14.22 ;,;white&black;,;   
09/15/17, Angelica Garza;,;$11.60;,;white&black   
;,;   09/15/17   ,   Jamie Welch   ;,; $25.27   ;,; 
white&black&red ;,;09/15/17   ,   Rex Hudson   
;,;$8.26;,;   purple;,; 09/15/17 ,   Nadine Gibbs 
;,;   $30.80 ;,;   purple&yellow   ;,; 09/15/17   , 
Hannah Pratt;,;   $22.61   ;,;   purple&yellow   
;,;09/15/17,Gayle Richards;,;$22.19 ;,; 
green&purple&yellow ;,;09/15/17   ,Stanley Holland 
;,; $7.47   ;,; red ;,; 09/15/17 , Anna Dean;,;$5.49 ;,; yellow&red ;,;   09/15/17   ,
Terrance Saunders ;,;   $23.70  ;,;green&yellow&red 
;,; 09/15/17 ,   Brandi Zimmerman ;,; $26.66 ;,; 
red   ;,;09/15/17 ,Guadalupe Freeman ;,; $25.95;,; 
green&red ;,;   09/15/17   ,Irving Patterson 
;,;$19.55 ;,; green&white&red ;,;   09/15/17 ,Karl Ross;,;   $15.68;,;   white ;,;   09/15/17 , Brandy Cortez ;,;$23.57;,;   white&red   ;,;09/15/17, 
Mamie Riley   ;,;$29.32;,; purple;,;09/15/17 ,Mike Thornton   ;,; $26.44 ;,;   purple   ;,; 09/15/17, 
Jamie Vaughn   ;,; $17.24;,;green ;,; 09/15/17   , 
Noah Day ;,;   $8.49   ;,;green   ;,;09/15/17   
,Josephine Keller ;,;$13.10 ;,;green;,;   09/15/17 ,   Tracey Wolfe;,;$20.39 ;,; red   ;,; 09/15/17 ,
Ignacio Parks;,;$14.70   ;,; white&red ;,;09/15/17 
, Beatrice Newman ;,;$22.45   ;,;white&purple&red 
;,;   09/15/17, Andre Norris   ;,;   $28.46   ;,;   
red;,;   09/15/17 ,   Albert Lewis ;,; $23.89;,;   
black&red;,; 09/15/17,   Javier Bailey   ;,;   
$24.49   ;,; black&red ;,; 09/15/17   , Everett Lyons ;,;$1.81;,;   black&red ;,; 09/15/17 ,   
Abraham Maxwell;,; $6.81   ;,;green;,;   09/15/17   
,   Traci Craig ;,;$0.65;,; green&yellow;,; 
09/15/17 , Jeffrey Jenkins   ;,;$26.45;,; 
green&yellow&blue   ;,;   09/15/17,   Merle Wilson 
;,;   $7.69 ;,; purple;,; 09/15/17,Janis Franklin   
;,;$8.74   ;,; purple&black   ;,;09/15/17 ,  
Leonard Guerrero ;,;   $1.86   ;,;yellow  
;,;09/15/17,Lana Sanchez;,;$14.75   ;,; yellow;,;   
09/15/17   ,Donna Ball ;,; $28.10  ;,; 
yellow&blue;,;   09/15/17   , Terrell Barber   ;,; 
$9.91   ;,; green ;,;09/15/17   ,Jody Flores;,; 
$16.34 ;,; green ;,;   09/15/17,   Daryl Herrera 
;,;$27.57;,; white;,;   09/15/17   , Miguel Mcguire;,;$5.25;,; white&blue   ;,;   09/15/17 ,   
Rogelio Gonzalez;,; $9.51;,;   white&black&blue   
;,;   09/15/17   ,   Lora Hammond ;,;$20.56 ;,; 
green;,;   09/15/17,Owen Ward;,; $21.64   ;,;   
green&yellow;,;09/15/17,Malcolm Morales ;,;   
$24.99   ;,;   green&yellow&black;,; 09/15/17 ,   
Eric Mcdaniel ;,;$29.70;,; green ;,; 09/15/17 
,Madeline Estrada;,;   $15.52;,;green;,;   09/15/17 
, Leticia Manning;,;$15.70 ;,; green&purple;,; 
09/15/17 ,   Mario Wallace ;,; $12.36 ;,;green ;,; 
09/15/17,Lewis Glover;,;   $13.66   ;,;   
green&white;,;09/15/17,   Gail Phelps   ;,;$30.52   
;,; green&white&blue   ;,; 09/15/17 , Myrtle Morris 
;,;   $22.66   ;,; green&white&blue;,;09/15/17"""

# ------------------------------------------------
# Start coding below!
daily_sales_replaced = daily_sales.replace(";,;", ":")

daily_transactions = daily_sales_replaced.split(",")

daily_transactions_clean = [[detail.strip() for detail in details.split(
    ":")] for details in daily_transactions]
print("==================== Daily Transactions ==================\n",
      daily_transactions_clean)

customers, sales, thread_sold = [details[0] for details in daily_transactions_clean], [
    details[1] for details in daily_transactions_clean], [details[2] for details in daily_transactions_clean]
print("\n==================== Transactions Infos ===================\n")
print("# Customers:\n", customers, "\n\n# Sales:\n",
      sales, "\n\n# Threads Sold:\n", thread_sold)

total_sales = round(sum([float(sale[1:]) for sale in sales]), 2)
print("\n======================= Total Sales =======================\n")
print("Total: $" + str(total_sales))

thread_sold_split = [
    color for sale in thread_sold for color in sale.split("&")]
print(thread_sold_split)


def color_count(color):
    return thread_sold_split.count(color)


print(color_count("white"))

colors = ["red", "yellow", "green", "white", "black", "blue", "purple"]

for i in range(len(colors)):
    print("Thread Shed sold {sales} threads of \"{color}\" threads today.".format(
        color=colors[i], sales=color_count(colors[i])))

# Imports and using imported files
print(make_sandwich())

# Dictionaries and its methods

tarot = {
    1:	"The Magician", 2:	"The High Priestess", 3:	"The Empress",
    4:	"The Emperor", 5:	"The Hierophant", 6:	"The Lovers",
    7:	"The Chariot", 8:	"Strength", 9:	"The Hermit",
    10:	"Wheel of Fortune", 11:	"Justice", 12:	"The Hanged Man",
    13:	"Death", 14:	"Temperance", 15:	"The Devil",
    16:	"The Tower", 17:	"The Star", 18:	"The Moon",
    19:	"The Sun", 20:	"Judgement", 21:	"The World", 22: "The Fool"
}

spread = {}

spread["past"] = tarot.pop(13)
spread["present"] = tarot.pop(22)
spread["future"] = tarot.pop(10)

for timeline, card in spread.items():
    print("Your {timeline} is the {card} card.".format(timeline=timeline, card=card))
