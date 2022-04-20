#ifndef ANIMAL_H
#define ANIMAL_H

#include <iostream>
#include <string>

using namespace std;

class Animal {
    private:
        static int numOfAnimals;
        string animalType;
        string name;
        int age;
        int weight;
        string breed;
        string color;
        string health;
        string sound;
        int myAnimalNum;

    public:
        /* Constructor */
        inline Animal() {};
        inline Animal(string animalType, string name, int age, int weight, string breed, 
                string color, string health, string sound) {};

        /* Mutator Methods */
        void setAnimalType(string newAnimalType) { this->animalType = newAnimalType; }
        void setName(string newName) { this->name = newName; }
        void setAge(int newAge) { this->age = newAge; }
        void setWeight(int newWeight) {  this->weight = newWeight; }
        void setBreed(string newBreed) { this->breed = newBreed; }
        void setColor(string newColor) { this->color = newColor; }
        void setHealth(string newHealth) { this->health = newHealth; }
        void setSound(string newSound) { this->sound = newSound; }

        /* Accessor Methods */
        const string getAnimalType() const { return this->animalType; }
        const string getName() const { return this->name; }
        const int getAge() const { return this->age; }
        const int getWeight() const { return this->weight; }
        const string getBreed() const { return this->breed; }
        const string getColor() const { return this->color; }
        const string getHealth() const { return this->health; }
        const string getSound() const { return this->sound; }

        virtual void introduction() {};
};
#endif