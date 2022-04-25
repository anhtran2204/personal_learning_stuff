#include <iostream>
#include "../headers/cat.h"

using namespace std;

inline Cat::Cat() : Animal() {
    numOfCats++;
    myCatNum = numOfCats;
}

inline Cat::Cat(string animalType, string name, int age, int weight, 
         string breed, string color, string health, string sound) :
        Animal(animalType, name, age, weight, breed, color, health, sound) {
    numOfCats++;
    myCatNum = numOfCats;
}

inline Cat::~Cat() {
    cout << "This cat is being sent away." << endl;
}

inline void Cat::introduction() {
    cout << getSound() << "!" << endl;
    cout << "I'm just a " << getAnimalType() << "." << endl;
    cout << "My name is " << getName() << endl;
    cout << "I am " << getAge() << " years old." << endl;
    cout << " I weigh " << getWeight() << " pounds." << endl;
    cout << "I'm a " << getBreed() << " breed, with the color " << getColor() << "." << endl;
    cout << "My health condition right now is " << getHealth() << "." << endl;
    cout << "I am " << getAnimalType() << " number " << myCatNum << "." << endl;
}