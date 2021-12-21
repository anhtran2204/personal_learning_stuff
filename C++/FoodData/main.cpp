#include <string>
#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

// read in the content of the input file
void read(string& file, vector<string>& foods,
          string& category, string& name,
          string& description, string& availability);

// display the available foods
void display(vector<string>& foods);


int main() {
    string file;
    string category;
    string name;
    string description;
    string availability;

    vector<string> foods;


    cout << "Enter input file name" << endl;
    cin >> file;

    read(file, foods, category, name, description, availability);
    display(foods);

    return 0;
}

void read(string& file, vector<string>& foods,
          string& category, string& name,
          string& description, string& availability) {
    ifstream ifile;
    ifile.open("../FoodData/inputFiles/" + file);

    if (!ifile) {
        cout << "File \"" << file << "\" could not be opened" << endl;
        return;
    }

    while (ifile) {
        getline(ifile, category, '\t');
        getline(ifile, name, '\t');
        getline(ifile, description, '\t');
        getline(ifile, availability);

        if (ifile.eof()) {
            break;
        }

        if (availability == "Available") {
            foods.push_back(name);
            foods.push_back(category);
            foods.push_back(description);
        }
    }
}

void display(vector<string>& foods) {
    for (int i = 0; i < foods.size(); i += 3) {
        cout << foods.at(i) << " (" << foods.at(i + 1) << ") -- " << foods.at(i + 2) << endl;
    }
}
