// This program extracts vowels from a file and puts them in another file

#include <iostream>
#include <fstream>

using namespace std;

int main() {
    // Ask for file name
    cout << "Enter file name" << endl;
    
    // Create names for input and output files
    string inputFileName, outputFileName;
    cin >> inputFileName;
    outputFileName = "vowels_" + inputFileName;
    
    // Initailize variables for reading and outputting files
    // Also for tracking the current get/put positions and EOF flag
    fstream file;
    long int currentGetPos = 0, currentPutPos = 0;
    bool isEOF = false;
    
    // Loops through analyzing each line until end of file
    while (true) {
        // Open input file for getting a line and seek to previous position
        file.open(inputFileName, ios::in | ios::binary);
        file.seekg(currentGetPos, ios::beg);
        // Gets a line by going through each character until it reaches a new line
        char currentChar;
        string currentLine;
        while (true) {
            file.get(currentChar);
            currentGetPos = file.tellg();
            currentLine.push_back(currentChar);
            
            // Keep track if the end of file has been reached and if a new line has been reached
            isEOF = file.eof();
            if (isEOF || currentChar == '\n') {
                break;
            }
        }
        file.close();
        
        // Open output file for writing vowels only and seek to previous position
        file.open(outputFileName, ios::app | ios::binary);
        file.seekp(currentPutPos, ios::beg);
        // Extract vowels from the current line
        for (int i = 0; i < (int)currentLine.length(); i++) {
            char letter = currentLine.at(i);
            if (isEOF && i == 0 && letter == '\n') {
                break; // Don't create a newline at the end of the file
            }
            if (letter == 'a' || letter == 'i' || letter == 'u' || letter == 'e' || letter == 'o' ||
				letter == 'A' || letter == 'I' || letter == 'U' || letter == 'E' || letter == 'O' || letter == '\n') {
                file.put(letter);
                currentPutPos = file.tellp();
            }
        }
        file.close();
        
        // Break out of loop when it reaches the end of the file
        if (isEOF) {
            break;
        }
    }

    return 0;
}