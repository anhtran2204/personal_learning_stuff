/*
    Name: Anh Tran, Jonathan Nguyen
    Program name: OperationKindess
    Date Created: 04/19/22
    Notes:
        -   be able to split the line input from the csv into 
            multiple variables for different attributes
        -   be able to find the specific cat or dog based on the name
        -   create the animal based on the animal type
    Changelog:
        -   added the splitString() to split input string line
            into multiple attributes for the animal
        -   
*/

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include "../headers/animal.h"
#include "../headers/cat.h"
#include "../headers/dog.h"
#include "../src/animal.cpp"
#include "../src/cat.cpp"
#include "../src/dog.cpp"

#define sp " "
#define br "------------------------------"

using namespace std;

vector<Animal*> animals;
vector<Cat*> cats;
vector<Dog*> dogs;
vector<Animal*> others;
vector<Animal*> adoptable;

void splitString(string& line, string& animalType, string& name, string& age, string& weight, 
                string& breed, string& color, string& health, string& sound) {
    stringstream ss(line);

    getline(ss, animalType, ',');
    getline(ss, name, ',');
    getline(ss, age, ',');
    getline(ss, weight, ',');
    getline(ss, breed, ',');
    getline(ss, color, ',');
    getline(ss, health, ',');
    getline(ss, sound);
}

void createAnimalType(string animalType, string name, int age, int weight, 
                string breed, string color, string health, string sound) {
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
    
        splitString(line, animalType, name, ageTemp, weightTemp, breed, color, health, sound);

        int age = (ageTemp != "") ? stoi(ageTemp) : 0;
        int weight = (weightTemp != "") ? stoi(weightTemp) : 0;

        createAnimalType(animalType, name, age, weight, breed, color, health, sound);
    }
}

void input(fstream& file) {
    string fileName;
    cout << "Enter the file name:" << sp << endl;
    getline(cin, fileName);

    file.open("../inputFile/" + fileName);
    // file.open(fileName);

    if (!file) {
        cout << "File doesn't exist!" << endl;
        cout << "Try again with another name." << endl;
        input(file);
    } else {
        read(file);
    }
}

Cat* findCat(string name) {
    Cat* catToFind = new Cat;
    for (auto cat : cats) {
        if (cat->getName() == name) {
            catToFind = cat;
            return catToFind;
        }
    }
    return catToFind;
}

Dog* findDog(string name) {
    Dog* dogToFind = new Dog;
    for (auto dog : dogs) {
        if (dog->getName() == name) {
            dogToFind = dog;
            return dogToFind;
        }
    }
    return dogToFind;
}

void reportAnimal() {
    cout << br << endl;
    cout << "Number of animals:" << sp << animals.size() << endl
         << "Number of cats:" << sp << cats.size() << endl
         << "Number of dogs:" << sp << dogs.size() << endl
         << "Number of the other types:" << others.size() << endl;
    for(auto animal : animals) {
        cout << br << endl;
        animal->introduction();
    }
}

void reportCat() {
    for (auto cat : cats) {
        cout << br << endl;
        cat->introduction();
    }
}

void reportDog() {
    for (auto dog : dogs) {
        cout << br << endl;
        dog->introduction();
    }
}

void reportOther() {
    for (auto animal : animals) {
        if (animal->getAnimalType() != "cat" && animal->getAnimalType() != "dog") {
            others.push_back(animal);
        }
    }

    for (auto animal : others) {
        cout << br << endl;
        animal->introduction();
    }
}

void reportAdoptable() {
    for (auto animal : animals) {
        if (animal->getHealth() == "good") {
            adoptable.push_back(animal);
        }
    }
    cout << "Number of adoptable animals:" << sp << adoptable.size() << endl;
    for (auto animal : adoptable) {
        cout << br << endl;
        cout << "Animal Type:" << sp << animal->getAnimalType() << endl
             << "Name:" << sp << animal->getName() << endl
             << "Age:" << sp << animal->getAge() << endl
             << "Weight:" << sp << animal->getWeight() << endl
             << "Breed:" << sp << animal->getBreed() << endl
             << "Color:" << sp << animal->getColor() << endl
             << "Health:" << sp << animal->getHealth() << endl;
    }
}

void report() {
    cout << "=========== ANIMAL ===========" << endl;
    reportAnimal();
    cout << "============ CAT =============" << endl;
    reportCat();
    cout << "============ DOG =============" << endl;
    reportDog();
    cout << "=========== OTHER ============" << endl;
    reportOther();
    cout << "========= ADOPTABLE ==========" << endl;
    reportAdoptable();
}

int main() {
    fstream file;
    input(file);
    report();

    // Cat* cat = new Cat("Cat", "Bob", 1, 20, "Munchkin", "Grey", "Good", "Meow");

    // cat->introduction();

    // for (int i = 0; i < animals.size(); i++)
    // {
    //     cout << br << endl;
    //     cout << "Animal #" << i+1 << ": " << endl;
    //     cout << animals.at(i)->getAnimalNum() << endl;
    //     cout << animals.at(i)->getAnimalType() << endl;
    //     if (animals.at(i)->getAnimalType() == "cat") {
    //         Cat* cat = findCat(animals.at(i)->getName());
    //         cout << cat->getCatNum() << endl;
    //     } else if (animals.at(i)->getAnimalType() == "dog") {
    //         Dog* dog = findDog(animals.at(i)->getName());
    //         cout << dog->getDogNum() << endl;
    //     } 
    // }

    return 0;
}