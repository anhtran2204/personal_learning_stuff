import random

def count_vowels(input_string):
    vowels = "aeiouAEIOU"
    count = 0
    for char in input_string:
        if char in vowels:
            count += 1
    return count


def generate_input():
    valid_input = random.choice(["Hello, World!", "12345", "AEIOU", ""])
    return valid_input


# Fuzz the program with generated inputs
for _ in range(5):
    generated_input = generate_input()
    result = count_vowels(generated_input)
    print("Generated Input:", generated_input)
    print("Number of vowels:", result)
    print()
