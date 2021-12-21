#include <iostream>

using namespace std;

int main()
{
    int number;
    // Get the number here
    int reversed;
    cin >> number;

    while (number > 0) {
        
        // Output a digit and divide to get rid of that number
        reversed *= 10;
        reversed += number % 10;
        number /= 10; 
    }
    cout << "Reversed: " << reversed << endl;

    return 0;
}