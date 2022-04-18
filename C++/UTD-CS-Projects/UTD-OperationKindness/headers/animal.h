#include <iostream>
#include <string>

using namespace std;

class Animal {
    private:
        string name;
        int age;
        int weight;
        string breed;
        string color;
        string health;
        string sound;

    public:
        /* Constructor */
        Animal() {
            
        }

        /* Mutator Methods */
        void setName(string newName) { this->name = newName; }
        void setAge(int newAge) { this->age = newAge; }
        void setWeight(int newWeight) {  this->weight = newWeight; }
        void setBreed(string newBreed) { this->breed = newBreed; }
        void setColor(string newColor) { this->color = newColor; }
        void setHealth(string newHealth) { this->health = newHealth; }
        void setSound(string newSound) { this->sound = newSound; }

        /* Accessor Methods */
        string getName() { return this->name; }
        int getAge() { return this->age; }
        int getWeight() { return this->weight; }
        string getBreed() { return this->breed; }
        string getColor() { return this->color; }
        string getHealth() { return this->health; }
        string getSound() { return this->sound; }
};