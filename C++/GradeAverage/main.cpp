//
// Created by anhph on 11/15/2021.
// Lab 10 Part 2
//

#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;

const int MAX_COLUMNS = 5;

// read input file and populate the array
int readFile(double values[][MAX_COLUMNS], int maxRows, string inputFileName);

// for the array
double average(double values[][MAX_COLUMNS], int numberRows);

// for a specified column (column)
double columnAverage(double values[][MAX_COLUMNS], int column, int numberRows);

// get the smallest value in a row
double getSmallest(double values[][MAX_COLUMNS], int column, int numberRows);

// check if file is empty
int isEmpty(string inputFileName);

// display the results
void display(string fileName, double values[][MAX_COLUMNS], int column, int numberRows);


int main() {
    string inputFileName;
    const int MAX_ROWS = 30;
    double grades[MAX_ROWS][MAX_COLUMNS];

    cout << "Enter input file name" << endl;
    cin >> inputFileName;

    int actualRows = readFile(grades, MAX_ROWS, inputFileName);
    display(inputFileName, grades, MAX_COLUMNS, actualRows);

    return 0;
}

int readFile(double values[][MAX_COLUMNS], int maxRows, string inputFileName) {
    ifstream ifile;
    ifile.open("./inputFiles/" + inputFileName);
//    ifile.open(inputFileName);

    int actualRows = 0;
    if (!ifile) {
        cout << "File \"" << inputFileName << "\" could not be opened" << endl;
        ifile.close();
        return -1;
    }

    int rows = isEmpty(inputFileName);
    if (rows <= 1) {
        cout << "The input file \"" << inputFileName << "\" did not contain any data" << endl;
        cout << "Actual rows: " << rows << endl;
        ifile.close();
        return rows;
    } else {
        double value;
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                ifile >> value;
                if (!ifile) {
                    break;
                }
                values[i][j] = value;
            }

            actualRows++;
        }
        ifile.close();
    }
    return actualRows;
}

double average(double values[][MAX_COLUMNS], int numberRows) {
    double sum = 0;
    int count = 0;

    for (int i = 0; i < numberRows; i++) {
        for (int j = 0; j < MAX_COLUMNS; ++j) {
            sum += values[i][j];
            count++;
        }
    }
    return sum / count;
}

double columnAverage(double values[][MAX_COLUMNS], int column, int numberRows) {
    double sum = 0;
    int count = 0;

    for (int i = 0; i < numberRows; i++) {
        sum += values[i][column];
        count++;
    }
    return sum / count;
}

double getSmallest(double values[][MAX_COLUMNS], int column, int numberRows) {
    double min = values[numberRows][0];

    for (int i = 0; i < column; i++) {
        if (values[numberRows][i] < min) {
            min = values[numberRows][i];
        }
    }
    return min;
}

int isEmpty(string inputFileName) {
    ifstream ifile;
    ifile.open("../inputFiles/" + inputFileName);
//    ifile.open(inputFileName);

    int data = 0;
    double value = 0;
    while (ifile >> value) {
        data++;
    }
    ifile.close();
    if (data < 5) {
        return 0;
    }
    return data / MAX_COLUMNS;
}

void display(string fileName, double values[][MAX_COLUMNS], int column, int numberRows) {
    ifstream ifile;
    ifile.open("../inputFiles/" + fileName);
//    ifile.open(fileName);

    if (ifile && isEmpty(fileName) > 1) {
        cout << fixed << setprecision(2);
        cout << "Processing " << numberRows << " rows, and " << column << " columns" << endl;

        cout << "Average for all values is " << average(values, numberRows) << endl;

        for (int i = 0; i < column; i++) {
            cout << "Average for column " << i << " is " << columnAverage(values, i, numberRows) << endl;
        }

        for (int i = 0; i < numberRows; i++) {
            cout << "Smallest value for row " << i << " is " << getSmallest(values, column, i) << endl;
        }
        ifile.close();
    }
}