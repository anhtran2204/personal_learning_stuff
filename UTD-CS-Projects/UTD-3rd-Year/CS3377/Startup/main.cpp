#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main() {
    string input;
    ofstream outfile ("file1.txt");
    getline(cin, input);
    if (outfile.is_open()) {
        outfile << input;
        outfile.close();
    } else {
        cout << "Unable to open file!\n";
    }

    ifstream infile("file1.txt");
    string data;
    while (getline(infile, data)) {
        cout << data << endl;
    }

    return 0;
}
