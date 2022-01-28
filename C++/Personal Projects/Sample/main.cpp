#include <iostream>

using namespace std;

void function(int data);

int main() {
    int value = 10;
    bool test = true;
    function(5);

    if (test)
    {
        int value = 20;
        value += 30;
    }
    else
    {
        int value = 11;
        value += 12;
    }

    cout << "The value is " << value << endl;
}

void function(int someData)
{
    int value = 0;
    value += someData;
}