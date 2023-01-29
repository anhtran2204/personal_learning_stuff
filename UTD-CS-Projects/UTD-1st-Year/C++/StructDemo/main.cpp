#include <iostream>

using namespace std;

struct People {
    string firstName;
    string lastName;
    int age;
    string occupation;
};

int main() {
    People person;

    cout << "What's your first name? ";
    cin >> person.firstName;

    cout << "What's your last name? ";
    cin >> person.lastName;

    cout << "What's your age? ";
    cin >> person.age;

    cout << "What's your occupation? ";
    cin >> person.occupation;

    cout << person.firstName << " " << person.lastName 
         << ": " << person.age << ", " 
         << person.occupation << endl;
    return 0;
}