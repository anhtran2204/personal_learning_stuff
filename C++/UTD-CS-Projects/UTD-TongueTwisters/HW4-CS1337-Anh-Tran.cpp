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

void input(fstream& file, string fileName, vector<string>& sentences, vector<vector<string>>& words) {
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

        spliceSentence(words, row, sentence);
    }
}

void spliceSentence(vector<vector<string>>& words, int line, string sentence) {
    stringstream ss(sentence);
    string word;

    while (ss) {
        if (ss.eof()) {
            break;
        }
        ss >> word;
        words[line].push_back(word);
    }
}

void display(vector<string> sentences) {
    cout << "Sentences:" << endl;
    for (string sentence : sentences) {
        cout << "\t-" << sp << sentence << endl;
    }
}

void display(vector<vector<string>> words) {
    cout << "Words:" << endl;
    for (vector<string> sentence : words) {
        for (string word : sentence) {
            cout << "\t-" << sp << word << endl;
        }
    }
}

int main() {
    fstream file;
    string fileName;

    vector<string> sentences;
    vector<vector<string>> words;

    input(file, fileName, sentences, words);


    return 0;
}