/*  Header file for the derived Dog class
    that inherited the Animal class
*/

#ifndef DOG_H           // If header file not define
#define DOG_H           // then define it

#include <iostream>
#include "../headers/animal.h"      // include the base animal header file

using namespace std;

class Dog : public Animal {
    private:
        static int numOfDogs;       // total num of dogs
        int myDogNum;

    public:
        /* Constructor */
        Dog();
        Dog(string animalType, string name, int age, int weight, 
            string breed, string color, string health, string sound);
        /* Destructor */
        ~Dog();

        // returns the unique dog number
        const int getDogNum() const { return this->myDogNum; }

        // overridden function for the introduction
        void introduction();
};
#endif