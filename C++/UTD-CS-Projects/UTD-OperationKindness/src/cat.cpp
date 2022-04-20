#include "../headers/cat.h"

using namespace std;

Cat::Cat() {
    numOfCats++;
    myCatNum = numOfCats;
}

Cat::Cat(string animalType, string name, int age, int weight, 
         string breed, string color, string health, string sound) {
    numOfCats++;
    myCatNum = numOfCats;
}

void Cat::introduction() {
    cout << getSound() << "!" << endl;
    cout << "I'm just a " << getAnimalType() << "." << endl;
    cout << "My name is " << getName() << endl;
    cout << "I am " << getAge() << " years old." << endl;
    cout << " I weigh " << getWeight() << " pounds." << endl;
    cout << "I'm a " << getBreed() << " breed, with the color " << getColor() << "." << endl;
    cout << "My health condition right now is " << getHealth() << "." << endl;
    cout << "I am " << getAnimalType() << " number " << myCatNum << "." << endl;
}