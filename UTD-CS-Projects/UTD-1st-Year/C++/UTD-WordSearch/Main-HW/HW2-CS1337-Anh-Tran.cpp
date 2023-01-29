/*
    Name: Anh Tran
    Program name: WordSearch
    Date Created: 02/09//22
    Notes:
        -   be able to read in input file and report any errors when open
            and to give the option to quit or type in new file name
        -   be able to skip comments that are in the file
        -   be able to differentiate different types of data reading in
        -   be able to detect the direction when finding a word
        -   a display function that outputs all the patterns found

    Changelog:
        -   02/13/22 - v1: 
                -   added global variables for setting up the board,
                    setting up the search direction, and for reading
                    in the input file.
                -   added in input() for reading in the file:
                        -   tell the user when a file can't be open
                            and type in a new file name
                        -   or be able to quit 
        -   02/15/22 - v2:
                -   added in the search2D() and patternSearch() functions that does
                    the logic for traversing and finding the pattern based on 
                    finding a starting char and look in 8 directions to find the next char
                    in the pattern
        -   02/16/22 - v3:
                -   added in skipComments(), a function that allow skipping comments 
                    when reading in data from file, as well as 
                    differentiating what types of data we are reading in
                -   added in hasSpace(), a function that detects whether an string input line
                    has a whitespace character in it
                -   added in toUpper(), a function that turns string into uppercase version
                -   added in patternDirection(), a function that takes in the 
                    row and column offset when traversing the 2D vectors and detect
                    what the direction is

*/

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

/* ------------- Global variables for setup ------------- */

/*  An enum for the basic offset 
    that uses the combination offset
    to determine the direction
*/
enum directions {
    W = -1,
    S = 1,
    N = -1,
    E = 1
};

/*  A constant 2D vector for the directional 
    offset combination for the search2D() to use
*/
const vector<vector<int>> dirOffsets = {
    {-1, -1},
    {-1, 0},
    {-1, 1},
    {0, -1},
    {0, 1},
    {1, -1},
    {1, 0},
    {1, 1}
};

ifstream file;
string fileName;

int rowLimit, colLimit;         
vector<vector<char>> puzzle;                    // The matrix 
vector<string> comedyMovies;                    // The list of movies to search
vector<string> movieNotFound;                   // List of movies that are not found

const int rowOffset = 0, colOffset = 1;       // Constant directional offset axis
const int dimension = 2;
vector<int> searchDir(dimension);               // The search direction

/* ------------------------------------------------------------------ */

bool input(ifstream &file, string &name) {
    cout << "Enter file name: ";
    getline(cin, name);

    file.open(name);
    if (file.good()) { //then the file opened just fine
        return true;
    }
    else {
        perror("Can't open the specified input file");
        cout << "The file name used was: " << name << endl;
        cout << "Enter another file name to use (or type 'quit'): ";
        getline(cin, name);
        if (name != "quit") { //maybe check for QUIT too
            cout << "--- The new file name is: " << name << endl;
            //note the use of recursion below
            bool wasItOpened = input(file, name);
            return wasItOpened;
        }
        else {
            cout << ".....Quitting at user's request." << endl;
            file.close();
            return false;
        }
    }
} // input

bool skipComments(ifstream &file, char &ch) {
    ch = file.peek();               // Peek at the next char in line
    if (ch == '#' || ch == '\n') {  // If it's a comment symbol or new line then skip
        return true;
    }
    return false;
} // skipComments

bool hasSpace(string text) {
    for (int i = 0; i < text.length(); i++) {
        if (iswspace(text[i])) {    // return true if whitespace or any variants of it
            return true;
        }
    }
    return false;
} // hasSpace

void setup(ifstream &file, vector<vector<char>> &grid, vector<string> &movies, int &rowLimit, int &colLimit) {
    char temp;          // a temp char to "peek" at the next char to skip comments
    char puzzlePiece;   // the char that we will read into the matrix
    string text;        // the whole text line from the line for extracting individual chars
    int row = 0, col = 0;

    while (file.good()) {
        if (skipComments(file, temp)) {
            getline(file, text); 
        } else {
            if (isdigit(temp)) {    // If it's digits then it's the row and col limit for the matrix
                file >> rowLimit >> colLimit;
                file.ignore();      // Ignore the new line symbol
            }
            else {
                // Get a new line if previous there was a comment line
                // or blank line that was already inputted
                getline(file, text);    
                
                if (file.eof()) { return; } // return when reach end of file

                // if the string text line has no space and the length
                // is the same as the row limit then it's the matrix data
                if (!hasSpace(text) && text.length() == rowLimit) {
                    vector<char> tempRow(colLimit);             // initialize a 1D vector to add in each char
                    tempRow.assign(text.begin(), text.end());   // extract the chars in the textline and add into the vector
                    grid.push_back(tempRow);                    // add the 1D vector into the 2D vector to increase the row of matrix
                }
                else {
                    movies.push_back(text);                     // if text line has space then it's the list of movies
                }
            }
        }

    }
    file.close();
}

string patternDirection() {
    int xDir = searchDir[colOffset];   // colOffset will show us the x-directional movement
    int yDir = searchDir[rowOffset];   // rowOffset will show us the y-directional movement

    string direction = "";              // initialize the direction
    if (yDir == N) {
        direction += "N";
    } else if (yDir == S) {
        direction += "S";
    } else if (yDir == 0) {
        /* do nothing because not moving in y-dir */
    }

    if (xDir == W) {
        direction += "W";
    } else if (xDir == E) {
        direction += "E";
    } else if (xDir == 0) {
        /* do nothing because not moving in x-dir */
    }
    return direction;
} // patternDirection

string toUpper(string word) {
    string wordWithoutSpace = "";   // initialize new string
    for (char ch : word) {
        if (ch != ' ') {            // if not whitespace then change to uppercase
            wordWithoutSpace += toupper(ch);    
        }
    }
    return wordWithoutSpace;        // return new uppercase string
} // toUpper

bool search2D(vector<vector<char>> &grid, int row, int col, string word) {
    int tempDir[2];
    bool firstFound = false;
    int count = 1;
    // If first character of word doesn't match with
    // given starting point in grid.
    
    if (grid[row][col] != word[0]) {
        return false;
    }

    word = toUpper(word);
    int wordLen = word.length();

    // Search word in all 8 searchDirs starting from (row,col)
    for (int dir = 0; dir < 8; dir++) {
        // Initialize starting point for current searchDir
        int k, rowDir = row + dirOffsets[dir][0], colDir = col + dirOffsets[dir][1];

        // First character is already checked, match remaining characters
        for (k = 1; k < wordLen; k++) {
            if (k == 2) {
                firstFound = true;
                tempDir[rowOffset] = dirOffsets[dir][0];
                tempDir[colOffset] = dirOffsets[dir][1];
            }

            // If out of bound break
            if (rowDir >= grid.size() || rowDir < 0 || colDir >= grid[k].size() || colDir < 0) {
                firstFound = false;
                count = 1;
                break;
            }

            // If not matched, break
            if (grid[rowDir][colDir] != word[k]) { 
                firstFound = false;
                count = 1;
                break; 
            }

            //  Moving in particular searchDir
            rowDir += dirOffsets[dir][0], colDir += dirOffsets[dir][1];
            count++;
        }

        // If all character matched, then value of k must
        // be equal to length of word
        if (k == wordLen && firstFound && count == wordLen) {
            searchDir[rowOffset] = tempDir[rowOffset];
            searchDir[colOffset] = tempDir[colOffset];
            return true;
        }
    }
    return false;
} // search2D

bool patternSearch(vector<vector<char>> &grid, vector<string> &missedWords, string pattern)
{
    // Consider every point as starting point and search
    // given word
    for (int row = 0; row < grid.size(); row++) {
        for (int col = 0; col < grid[row].size(); col++) {
            if (search2D(grid, row, col, pattern)) {
                cout << pattern << " found at position " << row + 1 << ", "
                     << col + 1 << ": (direction = " << patternDirection() << ")" <<  endl;
                return true;
            }
        }
    }
    missedWords.push_back(pattern); // Didn't found a match
    return false;
} // patternSearch

void display(vector<vector<char>> grid, int& row = rowLimit, int& col = colLimit) {
    cout << "\nNbr Rows: " << row 
         << "; Nbr Cols: " << col << endl << endl;

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            cout << grid[i][j];
        }
        cout << endl;
    }
    cout << endl;

    for (int i = 0; i < comedyMovies.size(); i++) {
        patternSearch(grid, movieNotFound, comedyMovies[i]);
    }

    cout << "\nCouldn't find these movies:" << endl;
    for (int i = 0; i < movieNotFound.size(); i++) {
        cout << movieNotFound[i] << endl;
    }
} // display

/* main */
int main() {
    if (input(file, fileName)) {
        setup(file, puzzle, comedyMovies, rowLimit, colLimit);
        display(puzzle);
    }
    return 0;
} // main 