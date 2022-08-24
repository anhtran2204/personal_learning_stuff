//
// Created by anhph on 10/26/2021.
//
#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

bool readAndWrite(ifstream& ifile,
                  ofstream& ofile,
                  double& sum,
                  double& num,
                  int& valid,
                  int& invalid);
double average(double sum, int valid);
void display(int total, int valid, int invalid, double average);

int main() {
    ifstream inputFile;
    ofstream outputFile;
    string inputFileName;

    cout << "Enter input file name" << endl;
    cin >> inputFileName;
    inputFile.open("./inputFiles/" + inputFileName);
//    inputFile.open(inputFileName);

    if (!inputFile) {
        cout << "File \"" << inputFileName << "\" could not be opened" << endl;
        inputFile.close();
        return -1;
    }

    outputFile.open("invalid-values.txt");
    if (!outputFile) {
        cout << "File \"invalid-values.txt\" could not be opened" << endl;
        outputFile.close();
        inputFile.close();
        return -1;
    }

    double num;
    double sum = 0;
    int valid = 0;
    int invalid = 0;
    int total = 0;

    bool last = true;
    while (last) {
        last = readAndWrite(inputFile, outputFile, sum, num, valid, invalid);
    }
    total = valid + invalid;

    cout << "Reading from file \"" << inputFileName << "\"" << endl;
    cout << "Total values: " << total << endl
         << "Invalid values: " << invalid << endl
         << "Valid values: " << valid << endl;
    display(total, valid, invalid, average(sum, valid));

    outputFile.close();
    inputFile.close();

    return 0;
}

bool readAndWrite(ifstream& ifile, ofstream& ofile, double& sum, double& num, int& valid, int& invalid) {
    ifile >> num;
    while (ifile) {
        if (num < 0 || num > 105) {
            ofile << fixed << setprecision(5) << num << endl;
            invalid++;
        } else {
            sum += num;
            valid++;
            return true;
        }
        ifile >> num;
    }
    return false;
}

double average(double sum, int valid) {
    return sum / valid;
}

void display(int total, int valid, int invalid, double average) {
    if (valid > 0) {
        cout << "Average of valid values: " << fixed << setprecision(4) << average << endl;
    } else {
        cout << "An average cannot be calculated" << endl;
    }
}