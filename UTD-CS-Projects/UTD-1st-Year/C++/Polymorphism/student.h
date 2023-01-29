#ifndef STUDENT_H
#define STUDENT_H

#include <iostream>
#include "person.h"

using namespace std;

class Student : public Person {
    private:
        string occupation;
        string hobby;

    public:
        Student();

        Student(string name, int age, string description, string newOccupation, string newHobby);

        void setOccupation(string newOccupation) {
            this->occupation = newOccupation;
        }

        void setHobby(string newHobby) {
            this->hobby = newHobby;
        }

        const string getOccupation() const {
            return this->occupation;
        }

        const string getHobby() const {
            return this->hobby;
        }

        void introduction();
};
#endif