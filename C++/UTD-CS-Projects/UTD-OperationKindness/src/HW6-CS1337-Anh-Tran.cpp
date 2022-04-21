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

using namespace std;

vector<Animal> animals;
vector<Cat> cats;
vector<Dog> dogs;

void input(fstream& file) {
    string fileName;
    cout << "Enter the file name:" << sp << endl;
    cin >> fileName;

    file.open(fileName);

    bool first = true;
    if (!file) {
        cout << "File don't exist!" << endl;
        cout << "Try again with another name." << endl;
        input(file);
    } else {
        string animalType;
        string name;
        string age;
        string weight;
        string breed;
        string color;
        string health;
        string sound; 

        string line;
        while (file >> line) {
            if (first) {
                continue;
            }

            if (file.eof()) {
                break;
            }

            stringstream ss(line);

            getline(ss, animalType, ',');
            getline(ss, name, ',');
            getline(ss, age, ',');
            getline(ss, weight, ',');
            getline(ss, breed, ',');
            getline(ss, color, ',');
            getline(ss, health, ',');
            getline(ss, sound);

            if  (animalType == "cat") {
                Cat cat(animalType, name, stoi(age), stoi(weight), breed, color, health, sound);
                cats.push_back(cat);
            } else if(animalType == "dog") {
                Dog dog(animalType, name, stoi(age), stoi(weight), breed, color, health, sound);
                dogs.push_back(dog);
            } else {
                Animal animal(animalType, name, stoi(age), stoi(weight), breed, color, health, sound);
                animals.push_back(animal);
            }
        }
    }
}

void report() {

}

int main() {
    fstream file;

    return 0;
}