#include <iostream>

using namespace std;

void demoFunction(int);

int main() {
    int value = 10;
    bool test = true;
    demoFunction(5);

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

void demoFunction(int someData)
{
    int value = 0;
    value += someData;
}