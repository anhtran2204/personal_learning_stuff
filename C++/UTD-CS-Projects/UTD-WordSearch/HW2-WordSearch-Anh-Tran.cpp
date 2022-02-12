/*
    Name: Anh Tran
    Program name: WordSearch
    Date Created: 02/09//22
    Notes:

    Changelog:
        
*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

void readFile(fstream& file, string& name) {
    cout << "Enter file name: ";
    cin >> name;

    file.open(name);
    if (!file) {
        cout << "Oops, can't open the specified input file: No such file or directory\n
                 The file name used was: {name}\n
                 Enter another file name to use (or quit): ".format(name=name) << endl;
        
        cin >> name;
        cout << "--- The new file name is: {name}".format(name=name) << endl;
    }
}

void setup(fstream& file, char grid[][], int& row, int& col) {
    
}

bool search2D(char grid[][], int row, int col, string word) {
    
}

bool patternSearch(string pattern) {

    return false;
}

int main () {

    return 0;
}