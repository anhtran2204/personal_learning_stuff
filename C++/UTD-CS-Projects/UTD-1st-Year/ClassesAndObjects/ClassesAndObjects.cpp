#include <iostream>
#include <iomanip>

using namespace std;

void printHelloWorld()
{
    cout << "Hello World from another method!" << endl;
}

int calculateAge(int year)
{
    int age = 2021 - year;
    return age;
}

int main()
{
    printHelloWorld();
    int yearOfBirth;
    cout << "Enter year of birth: ";
    cin >> yearOfBirth;
    cout << calculateAge(yearOfBirth) << endl;
}
