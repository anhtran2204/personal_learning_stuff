/*  Header file for the base Animal class
    that will be inherited by the Cat
    and Dog class
*/

#ifndef ANIMAL_H    // if the header file not define
#define ANIMAL_H    // then define it

#include <iostream>
#include <string>

using namespace std;

class Animal {
    private:
        /* Main attributes of each animal */
        static int numOfAnimals;    // Total num of animals
        string animalType;
        string name;
        int age;
        int weight;
        string breed;
        string color;
        string health;
        string sound;   
        int myAnimalNum;            // Unique number of each animal

    public:
        /* Constructor */
        Animal();                   // Default
        Animal(string animalType, string name, int age, int weight, string breed, 
                string color, string health, string sound);     // Overloaded
        /* Destructor */
        ~Animal();

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
        const int getAnimalNum() const { return this->myAnimalNum; }

        /* Introduce the animal using the attributes */
        virtual void introduction();
};
#endif