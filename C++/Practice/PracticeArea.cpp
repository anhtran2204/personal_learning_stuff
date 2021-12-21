#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
#include <math.h>

using namespace std;

class Person
{   
    public:
        string name;
        int age;
        string description;
        Person()
        {
            name = "John Doe";
            age = 30;
            description = "An average person";
        }

        Person(string name, int age, string description)
        {
            name = name;
            age = age;
            description = description;
        }
};

void print(string s)
{
    cout << s << endl;
}

int main()
{
    // Person person;

    // cout << "Enter your name: ";
    // cin >> person.name;
    // cout << "Enter your age: ";
    // cin >> person.age;
    // cout << "Enter the description: ";
    // cin >> person.description;

    int row = 12;
    int col = 12;

    for (int i = 0; i < row; i ++) {
        for (int j = 0; j < col; col++) {
            if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                cout << "@";
            }
        }
        cout << endl;
    }

}