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

const int xDir[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
const int yDir[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

vector<vector<char>> puzzleBoard;
vector<string> patternNotFound;
fstream file;
string fileName;

bool multiple;

void input(fstream& file, string& name) {
    cout << "Enter file name: ";
    cin >> name;

    file.open(name);
    if (!file) {
        cout << "Oops, can't open the specified input file: No such file or directory\n"
             << "The file name used was: " << name << "\n"
             << "Enter another file name to use (or quit): " << endl;
        
        cin >> name;
        cout << "--- The new file name is: " << name << endl;
    }
}

void setup(fstream& file, vector<vector<char>> grid, int& row, int& col) {
    char temp;

    while (file) {
        getline()
    }
}

bool search2D(vector<vector<char>> grid, int row, int col, string word) {
    // If first character of word doesn't match with
    // given starting point in grid.
    if (grid[row][col] != word[0]) {
      return false;
    }

    int wordLen = word.length();

    // Search word in all 8 directions starting from (row,col)
    for (int dir = 0; dir < 8; dir++) {
        // Initialize starting point for current direction
        int k, rowDir = row + xDir[dir], colDir = col + yDir[dir];

        // First character is already checked, match remaining
        // characters
        for (k = 1; k < wordLen; k++) {
            // If out of bound break
            if (rowDir >= grid.size() || rowDir < 0 || colDir >= grid[k].size() || colDir < 0) {
                break;
            }

            // If not matched,  break
            if (grid[rowDir][colDir] != word[k]) {
                break;
            }

            //  Moving in particular direction
            rowDir += xDir[dir], colDir += yDir[dir];
        }

        // If all character matched, then value of must
        // be equal to length of word
        if (k == wordLen) {
            return true;
        }
    }
    return false;
}

void patternSearch(vector<vector<char>> grid, vector<string> missedWords, string pattern) {
    // Consider every point as starting point and search
    // given word
    for (int row = 0; row < grid.size(); row++) {
        for (int col = 0; col < grid[row].size(); col++) {
            if (search2D(grid, row, col, pattern)) {
                cout << "Pattern found at " << row << ", "
                     << col << endl;
            } else {
                missedWords.push_back(pattern);
            } 
       }
    }
}

// main
int main () {
    input(file, fileName);

    return 0;
}