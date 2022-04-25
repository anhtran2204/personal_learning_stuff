#ifndef DOG_H
#define DOG_H

#include <iostream>
#include "../headers/animal.h"

using namespace std;

class Dog : public Animal {
    private:
        static int numOfDogs;
        int myDogNum;

    public:
        /* Constructor */
        Dog();
        Dog(string animalType, string name, int age, int weight, 
            string breed, string color, string health, string sound);
        ~Dog();
        void introduction() {};
};
#endif