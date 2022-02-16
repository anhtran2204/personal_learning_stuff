// OpenForReading - demonstrates a friendly routine for opening
// a file for reading. It also demonstratess the use of the
// peek() function for checking for comment lines.
// Doug DeGroot
//
#include <iostream>
#include <string>
#include <fstream>
using namespace std;

bool openForReading(ifstream &infile,string fileName) {
	infile.open(fileName);
	if (infile.good()) //then the file opened just fine
		return true;
	else {
		perror("Can't open the specified input file");
		cout << "The file name used was: " << fileName << endl;
		cout << "Enter another file name to use (or type 'quit'): ";
		getline(cin,fileName);
		if (fileName != "quit") { //maybe check for QUIT too
			cout << "--- The new file name is: " << fileName << endl;
			//note the use of recursion below
			bool wasItOpened = openForReading(infile,fileName);
			return wasItOpened;
		} else {
			cout << "Quitting at user's request." << endl;
			return false;
		}
	}
} //openForReading

void showTheFile(ifstream &inputFile) {
	string oneLine;
	int line = 1;
	while (inputFile.good()) {
		if (inputFile.peek() == '#') {
			cout << "  -- here comes a comment on line " << line << endl;
		}
		if (inputFile.eof()) return;
		getline(inputFile,oneLine);
		cout << oneLine << endl;
		line++;
	}
} //showTheFile


int main() {
    ifstream infile;
    string name;
    cout << "Enter file name: ";
    cin >> name;
    if (openForReading(infile, name)) {
        cout << "We opened the file just fine.\n";
        showTheFile(infile);
    }
    infile.close();
} //main
