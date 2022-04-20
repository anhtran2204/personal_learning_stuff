#ifndef DOG_H
#define DOG_H

#include <iostream>
#include "../headers/animal.h"

using namespace std;

class Dog : Animal {
    private:
        static int numOfDogs;
        int myDogNum;

    public:
        /* Constructor */
        inline Dog() : Animal() {}
        inline Dog(string animalType, string name, int age, int weight, 
            string breed, string color, string health, string sound) : 
            Animal(animalType, name, age, weight, breed, color, health, sound) {}

        virtual void introduction() {};
};
#endif