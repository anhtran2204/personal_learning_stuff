#include "../headers/dog.h"

using namespace std;

Dog::Dog() {
    numOfDogs++;
    myDogNum = numOfDogs;
}

Dog::Dog(string animalType, string name, int age, int weight, 
         string breed, string color, string health, string sound) {
    numOfDogs++;
    myDogNum = numOfDogs;
}

void Dog::introduction() {
    cout << getSound() << "!" << endl;
    cout << "I'm just a " << getAnimalType() << "." << endl;
    cout << "My name is " << getName() << endl;
    cout << "I am " << getAge() << " years old." << endl;
    cout << " I weigh " << getWeight() << " pounds." << endl;
    cout << "I'm a " << getBreed() << " breed, with the color " << getColor() << "." << endl;
    cout << "My health condition right now is " << getHealth() << "." << endl;
    cout << "I am " << getAnimalType() << " number " << myDogNum << "." << endl;
}