#ifndef CAT_H
#define CAT_H

#include <iostream>
#include "../headers/animal.h"

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
        ~Cat();
        
        const int getCatNum() const { return this->myCatNum; }

        void introduction();
};
#endif