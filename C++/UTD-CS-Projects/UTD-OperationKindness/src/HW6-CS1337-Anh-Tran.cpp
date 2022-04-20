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

        getline(file, animalType, ',');
        getline(file, name, ',');
        getline(file, age, ',');
        getline(file, weight, ',');
        getline(file, breed, ',');
        getline(file, color, ',');
        getline(file, health, ',');
        getline(file, sound);
    }
}

void report() {

}

int main() {
    fstream file;

    string line = "cat,Mittens,1,1,Calico,brown and white,good,Meow";

    string animalType;
    string name;
    string age;
    string weight;
    string breed;
    string color;
    string health;
    string sound; 

    stringstream ss(line);

    getline(ss, animalType, ',');
    getline(ss, name, ',');
    getline(ss, age, ',');
    getline(ss, weight, ',');
    getline(ss, breed, ',');
    getline(ss, color, ',');
    getline(ss, health, ',');
    getline(ss, sound);

    cout << line << endl;
    cout << animalType << sp
    << name << sp
    << age << sp
    << weight << sp
    << breed << sp
    << color << sp
    << health << sp
    << sound;

    return 0;
}