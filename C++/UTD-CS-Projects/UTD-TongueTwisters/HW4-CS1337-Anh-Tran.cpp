/*
    Name: Anh Tran
    Program name: TongueTwisters
    Date Created: 01/24/22
    Notes:
        
    Changelog:

*/

#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

#define sp " "

vector<string> sentences;
vector<vector<string>> words;

void input(fstream file, string fileName) {
    cout << "Enter file name: ";
    cin >> fileName;

    file.open(fileName);

    int row = 0;
    while (file.good()) {
        if (file.eof()) {
            break;
        }
        string sentence;
        getline(file, sentence);
        sentences.push_back(sentence);

        stringstream ss(sentence);
        for (int i = 0; i < sentence.size(); i++) {
            string word;
            ss >> word;
            words[row].push_back(word);
        }
        row++;
    }
}

int main() {
    fstream file;
    string fileName;

    for (int i = 0; i < words.size(); i++) {
        for (int j = 0; j < words[i].size(); j++) {
            cout << "Line" << sp << i + 1 << ": " << words
        }
    }

    return 0;
}