#include <iostream>

#include "person.h"
#include "student.h"
#include "person.cpp"
#include "student.cpp"

using namespace std;

int main() {
    Person person1 = Person("John", 15, "A normal student");

    person1.introduction();

    Student student1 = Student("Drake", 17, "Just another student", "Student at SHS", "Playing football");

    student1.introduction();

    return 0;
}