/*
    Name: Anh Tran, Danny Lee, Jonathan Nguyen
    Program name: TongueTwisters
    Date Created: 01/24/22
    Notes:
    Changelog:
*/

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include "../headers/animal.h"
#include "../headers/cat.h"
#include "../headers/dog.h"

#define sp " "
#define br "------------------------------"

using namespace std;

vector<Animal*> animals;
vector<Cat*> cats;
vector<Dog*> dogs;

void read(fstream& file) {
    string animalType;
    string name;
    string ageTemp;
    string weightTemp;
    string breed;
    string color;
    string health;
    string sound; 

    string line;
    bool first = true;
    while (getline(file, line)) {
        if (first) {
            first = false;
            continue;
        }

        if (file.eof()) {
            break;
        }

        stringstream ss(line);

        getline(ss, animalType, ',');
        getline(ss, name, ',');
        getline(ss, ageTemp, ',');
        getline(ss, weightTemp, ',');
        getline(ss, breed, ',');
        getline(ss, color, ',');
        getline(ss, health, ',');
        getline(ss, sound);

        int age = (ageTemp != "") ? stoi(ageTemp) : 0;
        int weight = (weightTemp != "") ? stoi(weightTemp) : 0;

        if  (animalType == "cat") { 
            Cat* cat = new Cat(animalType, name, age, weight, breed, color, health, sound);
            cats.push_back(cat);
            animals.push_back(cat);
        } else if(animalType == "dog") {
            Dog* dog = new Dog(animalType, name, age, weight, breed, color, health, sound);
            dogs.push_back(dog);
            animals.push_back(dog);
        } else {
            Animal* animal = new Animal(animalType, name, age, weight, breed, color, health, sound);
            animals.push_back(animal);
        }
    }
}

void input(fstream& file) {
    string fileName;
    cout << "Enter the file name:" << sp << endl;
    getline(cin, fileName);

    file.open("../inputFile/" + fileName);

    if (!file) {
        cout << "File don't exist!" << endl;
        cout << "Try again with another name." << endl;
        input(file);
    } else {
        read(file);
    }
}

void report() {
    
}

int main() {
    fstream file;
    // input(file);

    Cat cat = Cat("Cat", "Bob", 1, 20, "Munchkin", "Grey", "Good", "Meow");

    cat.introduction();

    // for (int i = 0; i < animals.size(); i++)
    // {
    //     cout << br << endl;
    //     cout << "Animal #" << i+1 << ": " << endl;
    //     cout << animals.at(i)->getAnimalType();
    // }

    return 0;
}