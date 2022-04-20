#include "../headers/animal.h"

using namespace std;

Animal::Animal() {
    numOfAnimals++;
    this->animalType = "";
    this->name = ""; 
    this->age = 0;
    this->weight = 0; 
    this->breed = ""; 
    this->color = ""; 
    this->health = ""; 
    this->sound = ""; 
    this->myAnimalNum = numOfAnimals;
}

Animal::Animal(string animalType, string name, int age, int weight, 
                string breed, string color, string health, string sound) {
    numOfAnimals++;
    this->animalType = animalType;
    this->name = name; 
    this->age = age;
    this->weight = weight; 
    this->breed = breed; 
    this->color = color; 
    this->health = health; 
    this->sound = sound; 
    this->myAnimalNum = numOfAnimals;
}

void Animal::introduction() {
    cout << getSound() << "!" << endl;
    cout << "I'm just a " << getAnimalType() << "." << endl;
    cout << "My name is " << getName() << endl;
    cout << "I am " << getAge() << " years old." << endl;
    cout << " I weigh " << getWeight() << " pounds." << endl;
    cout << "I'm a " << getBreed() << " breed, with the color " << getColor() << "." << endl;
    cout << "My health condition right now is " << getHealth() << "." << endl;
    cout << "I am " << getAnimalType() << " number " << myAnimalNum << "." << endl;
}