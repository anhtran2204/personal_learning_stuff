#include <iostream>
#include "../headers/cat.h"

using namespace std;

int Cat::numOfCats = 0;

inline Cat::Cat() : Animal() {
    Cat::numOfCats++;
    if (getSound() == "") {
        setSound("Meow!");
    }
    this->myCatNum = Cat::numOfCats;
}

inline Cat::Cat(string animalType, string name, int age, int weight, 
         string breed, string color, string health, string sound) :
        Animal(animalType, name, age, weight, breed, color, health, sound) {
    Cat::numOfCats++;
    if (sound == "") {
        setSound("Meow!");
    }
    this->myCatNum = Cat::numOfCats;
}

inline Cat::~Cat() {
    cout << "This cat is being sent away." << endl;
}

inline void Cat::introduction() {
    cout << getSound() << "!" << endl;
    cout << "I'm just a " << getAnimalType() << "." << endl;
    cout << "My name is " << getName() << "!" << endl;
    cout << "I am " << getAge() << " year(s) old." << endl;
    cout << "I weigh " << getWeight() << " pounds." << endl;
    cout << "I'm a " << getBreed() << " breed, with the color " << getColor() << "." << endl;
    cout << "My health condition right now is " << getHealth() << "." << endl;
    cout << "I am animal number " << this->getAnimalNum() << endl;
    cout << "I am " << getAnimalType() << " number " << this->myCatNum << "." << endl;
}