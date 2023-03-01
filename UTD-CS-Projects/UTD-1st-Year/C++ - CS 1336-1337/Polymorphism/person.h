#ifndef PERSON_H
#define PERSON_H

#include <iostream>

using namespace std;

class Person {
public:
    string name;
    int age;
    string description;

    Person();

    Person(string newName, int newAge, string newDescription);

    void setName(string newName) {
        this->name = newName;
    }

    void setAge(int newAge) {
        this->age = newAge;
    }

    void setDescription(string newDescription) {
        this->description = newDescription;
    }

    const string getName() const {
        return this->name;
    }

    const int getAge() const {
        return this->age;
    }

    const string getDescription() const {
        return this->description;
    }

    void greetings() {
        cout << "Hello World!" << endl;
    }

    void introduction();
};
#endif