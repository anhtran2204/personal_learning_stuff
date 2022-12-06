// Review Homework 3

#include <iostream>

using namespace std;

// Sums every element in the odd subscript of an integer array
int OddSum(int array[], int arraySize) {
    int sum = 0;
    
    if (arraySize > 0) {
        // Subtract by one to account for indexing the array
        arraySize--;
        
        // Check if current subscript is odd
        if ((arraySize) % 2 != 0) {
            sum += array[arraySize];
        }
        
        // Get the number from the other odd subscripts and decrease the size by one
        sum += OddSum(array, arraySize);
    }
    
    return sum;
}

// Reverses a string
string Backwards(string text) {
    string result;
    
    if (text.length() > 0) {
        // Get the last character of the string and print it
        char lastChar = text.back();
        cout << lastChar;
        
        // Remove the last character of the string since it is already stored
        // This would put the next character up in line to be printed
        text.pop_back();
        
        // Move the last character in the front of the string and repeat
        result = lastChar + Backwards(text);
    }
    
    return result;
}

int main() {
    // Tests an array with five elements
    int testArray[] = {1, 600, 3, 1024, 6};
    cout << OddSum(testArray, 5) << endl;
    
    // Tests the backwards function with a sample sentence
    Backwards("The quick brown fox jumps over the lazy dog");

    return 0;
}