/*  Header file for the derived Cat class
    that inherited the Animal class
*/

#ifndef CAT_H
#define CAT_H

#include <iostream>
#include "../headers/animal.h"      // include the base animal class

using namespace std;

class Cat : public Animal {
    private:
        static int numOfCats;
        int myCatNum;

    public:
        /* Constructor */
        Cat();
        Cat(string animalType, string name, int age, int weight, 
            string breed, string color, string health, string sound);
        /* Destructor */
        ~Cat();
        
        // returns the unique num of each cat
        const int getCatNum() const { return this->myCatNum; }

        // overridden function for the introduction
        void introduction();
};
#endif