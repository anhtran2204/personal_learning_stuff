#include "../headers/animal.h"

using namespace std;

int Animal::numOfAnimals = 0;

inline Animal::Animal() {
    Animal::numOfAnimals++;
    this->animalType = "unknown";
    this->name = "unknown"; 
    this->age = 0;
    this->weight = 0; 
    this->breed = "unknown"; 
    this->color = "unknown"; 
    this->health = "unknown"; 
    this->sound = "\'slight breathing sound...\'"; 
    this->myAnimalNum = Animal::numOfAnimals;
}

inline Animal::Animal(string animalType, string name, int age, int weight, 
                string breed, string color, string health, string sound) {
    Animal::numOfAnimals++;
    this->animalType = (animalType == "") ? "unknown" : animalType;
    this->name = (name == "") ? "unknown" : name; 
    this->age = age;
    this->weight = weight; 
    this->breed = (breed == "") ? "unknown" : breed; 
    this->color = (color == "") ? "unknown" : color; 
    this->health = (health == "") ? "unknown" : health; 
    this->sound = (sound == "") ? "\'slight breathing sound...\'" : sound; 
    this->myAnimalNum = Animal::numOfAnimals;
}

inline Animal::~Animal() {
    cout << "This animal is being sent away." << endl;
}

inline void Animal::introduction() {
    cout << getSound() << "!" << endl;
    cout << "I'm just a " << getAnimalType() << "." << endl;
    cout << "My name is " << getName() << endl;
    cout << "I am " << getAge() << " year(s) old." << endl;
    cout << "I weigh " << getWeight() << " pounds." << endl;
    cout << "I'm a " << getBreed() << " breed, with the color " << getColor() << "." << endl;
    cout << "My health condition right now is " << getHealth() << "." << endl;
    cout << "I am animal number " << this->myAnimalNum << "." << endl;
}