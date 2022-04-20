#ifndef CAT_H
#define CAT_H

#include <iostream>
#include "../headers/animal.h"

using namespace std;

class Cat : Animal {
    private:
        static int numOfCats;
        int myCatNum;

    public:
        /* Constructor */
        inline Cat() : Animal() {};
        inline Cat(string animalType, string name, int age, int weight, 
            string breed, string color, string health, string sound) : 
            Animal(animalType, name, age, weight, breed, color, health, sound) {};

        virtual void introduction() {};
};
#endif