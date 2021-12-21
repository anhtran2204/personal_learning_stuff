#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>

using namespace std;

const int MAX_SIZE = 21;

// validate the square based on the vertical, horizontal, and diagonal sum
bool validateSquare(const int square[MAX_SIZE][MAX_SIZE], int size);

// validate the numbers in the square are each unique
bool validateNumbers(const int square[MAX_SIZE][MAX_SIZE], int size);

// validate the square based on the vertical sum
bool validateVertical(const int square[MAX_SIZE][MAX_SIZE], int size);

// validate the square based on the horizontal sum
bool validateHorizontal(const int square[MAX_SIZE][MAX_SIZE], int size);

// validate the square based on the diagonal sum
bool validateDiagonal(const int square[MAX_SIZE][MAX_SIZE], int size);

// read in content of the file to the 2D-array
int readSquare(int square[MAX_SIZE][MAX_SIZE], string inputFileName);

// display the square and whether it is a valid magic square
void display(string inputFileName, const int square[MAX_SIZE][MAX_SIZE], int size);

int main() {
    int square[MAX_SIZE][MAX_SIZE];

    string fileName;
    cout << "Enter input file name" << endl;
    cin >> fileName;

    int actualSize = readSquare(square, fileName);
    display(fileName, square, actualSize);
    
    return 0;
}

int readSquare(int square[MAX_SIZE][MAX_SIZE], string inputFileName) {
    ifstream ifile;
    ifile.open("../LoShuMagicSquare/inputFiles/" + inputFileName);
    // ifile.open(inputFileName);

    /*
     * return 0 if file not exist
     * or cannot be opened
     * */
    if (!ifile) {
        cout << "File \"" << inputFileName << "\" could not be opened" << endl;
        ifile.close();
        return 0;
    }

    /* variables for the 2d-array */
    int i = 0;      // row index
    int j = 0;      // column index

    /* variables for the input file */
    string input;   // input line to read in
    int size;       // input to read in the size (S*S) of array
    int value;      // value to read in each input

    bool first = true; // a flag to read in the size of the array
    while (ifile) {
        if (first) {
            ifile >> size;
            getline(ifile, input); // to read in the rest of the line for the next input
            first = false;
        } else {
            getline(ifile, input); // get the whole line

            istringstream str(input); // turn the line into a separate input stream to read in

            while (str >> value) {
                square[i][j] = value;
                j++;
            }
            j = 0;
            i++;
        }
    }
    ifile.close();
    return size;
}

bool validateSquare(const int square[MAX_SIZE][MAX_SIZE], int size) {
    // return true iff all three validate methods are true
    return validateNumbers(square, size) &&
           validateVertical(square, size) &&
           validateHorizontal(square, size) &&
           validateDiagonal(square, size);
}

bool validateNumbers(const int square[MAX_SIZE][MAX_SIZE], int size) {
    int LIMIT = size * size;    // the numbers limit we need to have for each grid
    int check = 1;              // number used to check each grid, increment after checking all
    int count = 0;              // number of occurrences of each number used to check

    while (check <= LIMIT) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (square[i][j] == check) { // check occurrences of each number
                    count++;
                }
            }
        }

        if (count > 1) {    // if one number occurs more than once, return false
            return false;
        } else {
            count = 0;
        }
        check++;
    }
    return true;
}

bool validateVertical(const int square[MAX_SIZE][MAX_SIZE], int size) {
    int LIMIT = size * (size * size + 1) / 2; 	// the sum limit that we need to check
    int sum = 0;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            sum += square[i][j];		// adding the index to the sum
        }

        if (sum != LIMIT) {			// if the sum not equal to
            return false;			// the sum limit then return false
        }
        sum = 0;
    }
    return true;
}

bool validateHorizontal(const int square[MAX_SIZE][MAX_SIZE], int size) {
    int LIMIT = size * (size * size + 1) / 2; 	// the sum limit that we need to check
    int sum = 0;

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            sum += square[j][i];		// adding the index to the sum
        }

        if (sum != LIMIT) {			// if the sum not equal to	
            return false;			// the sum limit then return false	
        }
        sum = 0;
    }
    return true;
}

bool validateDiagonal(const int square[MAX_SIZE][MAX_SIZE], int size) {
    int LIMIT = size * (size * size + 1) / 2; // the sum limit that we need to check
    int leftSum = 0;
    int rightSum = 0;

    for (int i = 0; i < size; i++) {
        leftSum += square[i][i];
    }
    for (int i = 0; i < size; i++) {
        rightSum += square[i][size-i-1];
    }

    if (leftSum != LIMIT && rightSum != LIMIT) {
        return false;
    }
    return true;
}

void display(string inputFileName, const int square[MAX_SIZE][MAX_SIZE], int size) {
    ifstream ifile;
    ifile.open("../LoShuMagicSquare/inputFiles/" + inputFileName);
    // ifile.open(inputFileName);

    if (!ifile) {
        ifile.close();
        return;
    } else {
        cout << "Magic square" << endl;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cout << square[i][j] << " ";
            }
            cout << endl;
        }
        cout << endl;

        if (validateSquare(square, size)) {
            cout << "Valid ";
        } else {
            cout << "Invalid ";
        }
        cout << " magic square" << endl;
    }
    ifile.close();
}
