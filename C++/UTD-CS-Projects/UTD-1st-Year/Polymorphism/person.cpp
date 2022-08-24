#include <iostream>
#include "person.h"

using namespace std;

inline Person::Person(){
    name = "John Smith";
    age = 30;
    description = "Just a normal man";
}

inline Person::Person(string newName, int newAge, string newDescription) {
    this->name = newName;
    this->age = newAge;
    this->description = newDescription;
}

inline void Person::introduction() {
    greetings();
    cout << "My name is " << name << "." << endl;
    cout << "I'm " << age << " years old." << endl;
    cout << description << endl;
}