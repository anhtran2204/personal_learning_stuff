#include <iostream>
#include "student.h"

using namespace std;

inline Student::Student() : Person() {
    occupation = "Office Worker";
    hobby = "Golf";
}

inline Student::Student(string name, int age, string description, string newOccupation, string newHobby)
        : Person(name, age, description)
{
    occupation = newOccupation;
    hobby = newHobby;
}

inline void Student::introduction() {
    greetings();
    cout << "My name is " << getName() << "." << endl;
    cout << "I'm " << getAge() << " years old." << endl;
    cout << "I'm a " << getOccupation() << " and I like " << getHobby() << endl;  
    cout << getDescription() << endl;
}