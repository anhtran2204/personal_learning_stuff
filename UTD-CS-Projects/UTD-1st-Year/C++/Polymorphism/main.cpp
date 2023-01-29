#include <iostream>
#include <vector>

#include "person.h"
#include "student.h"
#include "person.cpp"
#include "student.cpp"

using namespace std;

vector<Person*> people;

int main() {
    Person* person1 = new Person("John", 15, "A normal student");

    Student* student1 = new Student("Drake", 17, "Just another student", "Student at SHS", "Playing football");

    people.push_back(person1);
    people.push_back(student1);

    for (auto person : people) {
        person->introduction();
    }
    return 0;
}