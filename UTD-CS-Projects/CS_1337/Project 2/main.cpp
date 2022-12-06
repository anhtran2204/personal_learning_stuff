// Project 2 Final Submission
// Andrew Nguyen AXN210010

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <algorithm>

using namespace std;

double* readFile(string fileName, int &arraySize) {
    ifstream matrixFile;
    matrixFile.open(fileName);
    
	 // Initalize variables for tracking the current row and column
    int currentRow = 0, currentColumn = 0;
    
	 // Create pointers for dynamic arrays
	 double *matrixPointer, *resultPointer;
	 matrixPointer = new double[16];
    
    if (matrixFile.is_open()) {
        string line, selectedTerm;
        while (getline(matrixFile, line)) {
            while (line.length() > 0) {
                // Find the locations of 'x', 'y', 'z', and '='
                size_t xIndex = line.find('x');
                size_t yIndex = line.find('y');
                size_t zIndex = line.find('z');
                size_t equalIndex = line.find('=');
                
                // Find the first instance out of those four characters
                size_t firstIndex = min(xIndex, min(yIndex, min(zIndex, equalIndex)));
                
                // Split the first term it finds and the rest of the equation
                if ((int)firstIndex != -1) {
                    selectedTerm = line.substr(0, firstIndex + 1);
                    line = line.substr(firstIndex + 1);    
                } else {
                    selectedTerm = line;
                    line = "";
                }
                
                // Get the terms with the coefficients and variables only
                if (selectedTerm != "=") {
                    // Remove the alphabetical characters at the back of the string
                    if (isalpha(selectedTerm.back())) {
                        if (selectedTerm.length() > 1)
                            selectedTerm.pop_back();
                        else
                            selectedTerm = "1"; // Account for terms with no numbers
                    }
                    
                    // Account for missing numbers again
                    if (selectedTerm == "-" || selectedTerm == "+")
                        selectedTerm.push_back('1');
                    
                    // Determine which column it belongs in
                    if ((int)xIndex != -1 && firstIndex == xIndex)
                        currentColumn = 0;
                    else if ((int)yIndex != -1 && firstIndex == yIndex)
                        currentColumn = 1;
                    else if ((int)zIndex != -1 && firstIndex == zIndex)
                        currentColumn = 2;
                    else
                        currentColumn = 3;
                    
                    // Calculate how many steps it needs to take to go to the correct row and column
                    int calculatedPosition = (currentRow * 4) + currentColumn;
                    // Move the pointer to that position and set the value there to the selected value
                    matrixPointer += calculatedPosition;
                    *matrixPointer = stod(selectedTerm);
                    // Set the pointer back to the starting position
                    matrixPointer -= calculatedPosition;
                }
            }
            currentRow++; // Add for the next row
        }
		
		// Calculate the correct size of the new arraySize
		arraySize = 4 * currentRow;
		// Copy over from the old array to the new array
		resultPointer = new double[arraySize];
		for (int i = 0; i < arraySize; i++) {
			*resultPointer = *matrixPointer;
			resultPointer++;
			matrixPointer++;
		}
		// Delete unused array
		matrixPointer -= arraySize;
		delete [] matrixPointer;
    }
    
    return resultPointer - arraySize; // Set the pointer to the beginning of the array and return it
}

double* getRow(double *matrixArray, int arraySize, int targetRow) {
    double *rowArray = new double[4]; // Create a dynamically array for the row
    int currentRow = 1; // Keep track of the current row
    for (int i = 0; i < arraySize; i++) {
        if (targetRow == currentRow) { // Wait until it reaches the target row
            *rowArray = *matrixArray; // Save the row to the array
            rowArray++;
        }
        matrixArray++; // Move the pointer to the next address
        if ((i + 1) % 4 == 0) {
            currentRow++;
        }
    }
    return rowArray - 4; // Return the row
}

void displayMatrix(double *matrixArray, int arraySize) {
    for (int i = 0; i < arraySize; i++) {
        cout << setw(6) << *matrixArray; // Print each value in the matrix
        matrixArray++;
        if ((i + 1) % 4 == 0) {
            cout << endl; // Make a newline at the end of each row
        } else {
            cout << " "; // Add a space between the numbers
        }
    }
}

void switchRow(double *matrixArray, int arraySize, int firstRow, int secondRow) {
    // Get first and second rows
    double *firstRowArray = getRow(matrixArray, arraySize, firstRow);
    double *secondRowArray = getRow(matrixArray, arraySize, secondRow);
    
    int currentRow = 1; // Keep track of the current row
    for (int i = 0; i < arraySize; i++) {
        if (firstRow == currentRow) { // Wait until it reaches the first row
            *matrixArray = *secondRowArray; // Replace it with the second row
            secondRowArray++;
        }
        if (secondRow == currentRow) { // Do the same thing for the second row
            *matrixArray = *firstRowArray;
            firstRowArray++;
        }
        if (*matrixArray == 0)
               *matrixArray = 0; // Remove negative sign on any zeroes
        matrixArray++; // Move the pointer to every value
        if ((i + 1) % 4 == 0) { // Keep track of the curent row it is on
            currentRow++;
        }
    }
    
    // Delete arrays after using them
    firstRowArray -= 4;
    secondRowArray -= 4;
    delete [] firstRowArray;
    delete [] secondRowArray;
}

void multiplyRow(double *matrixArray, int arraySize, int targetRow, double multiplier) {
    int currentRow = 1; // Keep track of the current row
    for (int i = 0; i < arraySize; i++) {
        if (targetRow == currentRow) { // Wait until it reaches the target row
            *matrixArray *= multiplier;
            if (*matrixArray == 0)
               *matrixArray = 0; // Remove negative sign on any zeroes
        }
        matrixArray++; // Move the pointer to every value
        if ((i + 1) % 4 == 0) {
            currentRow++; // Keep track of the curent row it is on
        }
    }
}

void addRowToRow(double *matrixArray, int arraySize, int multipliedRow, int targetRow, double multiplier) {
    int currentRow = 1; // Keep track of the current row
    double *multipliedRowArray = getRow(matrixArray, arraySize, multipliedRow); // Get the row that is to be multiplied
    for (int i = 0; i < arraySize; i++) {
        if (targetRow == currentRow) { // Wait until it reaches the target row
            *matrixArray += *multipliedRowArray * multiplier; // Add the multiplied row to the matrix
            multipliedRowArray++;
            if (*matrixArray == 0)
               *matrixArray = 0; // Remove negative sign on any zeroes
        }
        matrixArray++; // Move the pointer to every value
        if ((i + 1) % 4 == 0) {
            currentRow++; // Keep track of the curent row it is on
        }
    }
    // Delete used arrays
    multipliedRowArray -= 4;
    delete [] multipliedRowArray;
}

bool checkRREF(double *matrixArray, int arraySize) {
    bool isRREF = true;
    for (int i = 0; i < arraySize; i++) {
        // Ignore if the value is at the end of the row
        if (isRREF == true && (i + 1) % 4 != 0) {
           if (i == 0 || i == 5 || i == 10) {
               // Check if certain positions equal to 1 or 0 so it matches the identity matrix
               isRREF = (*matrixArray == 1 || *matrixArray == 0);
           } else {
               isRREF = (*matrixArray == 0); // Check if other positions equal to zero
           }
        }
        matrixArray++; // Move the pointer to the next value
    }
    return isRREF;
}

int main() {
    // Ask for the file name containing the matrix
    string fileName;
    cout << "Enter file name containing a matrix" << endl;
    cin >> fileName;
    
    // Read the file and get the matrix as an array and calculate the size
    int arraySize = 0;
	double *matrixArray = readFile(fileName, arraySize);
	int totalRows = arraySize / 4; // Calculate total rows after getting array size
    
    // Set precision of numbers to two decimal places
    cout << fixed << setprecision(2);
    
    // Menu loop
    while (true) {
        cout << endl;
        displayMatrix(matrixArray, arraySize); // Display the matrix every loop
        
        // Check for reduced row echelon form
        if (checkRREF(matrixArray, arraySize)) {
            // Get the x, y, and z values
            double xValue, yValue, zValue;
            matrixArray += 3;
            xValue = *matrixArray;
            matrixArray += 4;
            yValue = *matrixArray;
            matrixArray += 4;
            zValue = *matrixArray;
            matrixArray -= 11; // Move the pointer back
            
            // Display the values and exit the program
            cout << "x = " << xValue << endl;
            if (totalRows >= 2) // Check for total number of rows before displaying
                cout << "y = " << yValue << endl;
            if (totalRows >= 3)
                cout << "z = " << zValue << endl;
            break;
        }
        
        // Prompt choices for user input
        cout << "1 - Switch two rows" << endl;
        cout << "2 - Multiply row by non-zero number" << endl;
        cout << "3 - Add scalar of one row to another row" << endl;
        cout << "4 - Quit" << endl;
        
        int userChoice;
        cin >> userChoice;
        if (userChoice == 1) {
            // Switch two rows
            int firstRow = 0, secondRow = 0;
            while (firstRow <= 0 || firstRow > totalRows) {
                cout << "What is the first row you want to switch?" << endl;
                cin >> firstRow;
            }
            while (secondRow <= 0 || secondRow > totalRows) {
                cout << "What is the second row you want to switch?" << endl;
                cin >> secondRow;
            }
            switchRow(matrixArray, arraySize, firstRow, secondRow);
        } else if (userChoice == 2) {
            // Multiply row by non-zero number
            int targetRow = 0;
            double multiplier = 0;
            while (targetRow <= 0 || targetRow > totalRows) {
                cout << "Which row do you want to multiply?" << endl;
                cin >> targetRow;   
            }
            while (multiplier == 0) {
                cout << "Which number do you want to multiply that row by?" << endl;
                cin >> multiplier;
            }
            multiplyRow(matrixArray, arraySize, targetRow, multiplier);
        } else if (userChoice == 3) {
            // Add scalar of one row to another row
            int multipliedRow = 0, targetRow = 0;
            double multiplier = 0;
            while (multipliedRow <= 0 || multipliedRow > totalRows) {
                cout << "Which row do you want to be used for multiplication?" << endl;
                cin >> multipliedRow;
            }
            while (multiplier == 0) {
                cout << "Which number do you want to multiply that row by?" << endl;
                cin >> multiplier;
            }
            while (targetRow <= 0 || targetRow > totalRows) {
                cout << "Which row do you want to be modified?" << endl;
                cin >> targetRow;
            }
            addRowToRow(matrixArray, arraySize, multipliedRow, targetRow, multiplier);
        } else if (userChoice == 4) {
            // Quit and end the program
            break;
        } else {
            // Warn for invalid input
            cout << "Invalid input, please try again" << endl;
        }
    }
    
    delete [] matrixArray; // Delete no longer used dynamically allocated memory
    
    return 0;
}