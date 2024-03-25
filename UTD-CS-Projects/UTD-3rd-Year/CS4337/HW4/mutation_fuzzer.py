import random

def count_vowels(input_string):
    vowels = "aeiouAEIOU"
    count = 0
    for char in input_string:
        if char in vowels:
            count += 1
    return count

def mutate_input(input_string):
    mutation = list(input_string)
    index = random.randint(0, len(mutation) - 1)
    
    if random.random() < 0.3:
        # Insert a random character
        mutation.insert(index, random.choice("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"))

    elif random.random() < 0.6:
        # Delete a character
        del mutation[index]

    else:
        # Change a character
        mutation[index] = random.choice("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890")

    return ''.join(mutation)

# Define a sample user input
user_input = "This is a sample user input."

# Fuzz the program with mutated inputs
for _ in range(5):
    mutated_input = mutate_input(user_input)
    result = count_vowels(mutated_input)
    print("Mutated Input:", mutated_input)
    print("Number of vowels:", result)
    print()