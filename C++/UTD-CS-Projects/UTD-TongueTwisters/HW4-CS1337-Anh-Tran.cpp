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
#define br "---------"

void openFile(fstream& file, string fileName) {
    cout << "Enter file name: ";
    cin >> fileName;

    file.open("./inputFiles/" + fileName);
}

void spliceSentence(vector<vector<string>>& words, string sentence) {
    stringstream ss(sentence);
    string word;

    cout << "Sentence to split:" << sp << sentence << endl;

    int line = 0;
    vector<string> lineWords;
    while (ss >> word) {
        lineWords.push_back(word);
    }
    words.push_back(lineWords);
}

void input(fstream& file, vector<string>& sentences, vector<vector<string>>& words) {
    string fileName;
    openFile(file, fileName);
    if (!file) {
        cout << "File doesn't exist!" << endl 
             << "Please try another name." << endl << endl;
        openFile(file, fileName);
    } else {
        cout << "Inputting data from file..." << endl;
        while (file.good()) {
            if (file.eof()) {
                break;
            }
            string sentence;
            getline(file, sentence);
            sentences.push_back(sentence);
            spliceSentence(words, sentence);
        }
    }
}

void display(vector<string> sentences) {
    cout << "Sentences:" << endl;
    for (string sentence : sentences) {
        cout << "-" << sp << sentence << endl;
    }
}

void display(vector<vector<string>> words) {
    cout << "Words:" << endl;
    for (vector<string> sentence : words) {
        cout << br << endl;
        for (string word : sentence) {
            cout << "-" << sp << word << endl;
        }
    }
}

int main() {
    fstream file;

    vector<string> sentences;
    vector<vector<string>> words;

    input(file, sentences, words);

    display(words);

    return 0;
}