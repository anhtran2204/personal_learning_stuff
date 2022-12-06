// Review HW 8
// AXN210010 Andrew Nguyen

#include <iostream>
#include <fstream>

#include "Uppercase.h"
#include "Encryption.h"
#include "Copy.h"
#include "FileFilter.h"

using namespace std;

int main() {
    // Get input file
    string fileName;
    cin >> fileName;
    ifstream inputFile;
    
    // Encryption with default key
    inputFile.open(fileName);
    Encryption encrypt_1;
    ofstream encryptFile_1("EncryptionDefault.txt");
    encrypt_1.doFilter(inputFile, encryptFile_1);

    // Encryption with key of 12
    inputFile.open(fileName);
    Encryption encrypt_2 = Encryption(12);
    ofstream encryptFile_2("Encryption12.txt");
    encrypt_2.doFilter(inputFile, encryptFile_2);

    // Encryption with key of -4
    inputFile.open(fileName);
    Encryption encrypt_3 = Encryption(-4);
    ofstream encryptFile_3("Encryption-4.txt");
    encrypt_3.doFilter(inputFile, encryptFile_3);

    // Uppercase
    inputFile.open(fileName);
    Uppercase upper;
    ofstream upperFile("Uppercase.txt");
    upper.doFilter(inputFile, upperFile);

    // Copy
    inputFile.open(fileName);
    Copy copy;
    ofstream copyFile("Copy.txt");
    copy.doFilter(inputFile, copyFile);
    
    return 0;
}
