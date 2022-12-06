// Project 1
// Andrew Nguyen AXN210010

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

long int printFile(fstream &file) {
    // Save pointer position and close output file
    long int currentPointerPos = file.tellp();
    file.close();
    
    // Open the paint file as an input stream
    ifstream paintFile;
    paintFile.open("paint.txt");
    
    // Read each line and output it into console
    string line;
    while (getline(paintFile, line)) {
        cout << line << endl;
    }
    
    // Close input file
    cout << endl << endl;
    paintFile.close();
    
    // Reopen file and return last saved position
    file.open("paint.txt", ios::binary | ios::in | ios::out | ios::ate);
    return currentPointerPos;
}

void draw(fstream &file, int pen_status, int distance, char direction, bool isBold) {
    long int charPerRow = 51; // 50 characters per row plus 1 for '\n'
    long int maxSize = (charPerRow * 50); // Max size = (rows x columns) minus 1 for last line
    
    long int moveDistance = 1; // For West and East, move one column
    if (direction == 'N' || direction == 'S')
        moveDistance = charPerRow; // For North and South, move one row
    if (direction == 'N' || direction == 'W')
        moveDistance *= -1; // Negate direction if going North or West
    
    long int distanceSpan = distance * moveDistance; // Get total amount of characters to be moved
    long int futurePosition = file.tellp() + distanceSpan; // Get hypothetical position of the pointer after the move
    long int numUntilNextRow = file.tellp() % charPerRow; // Get remainder of characters left in a row
    
    // Check if final position will be out of bounds for rows
    bool notOutOfRow = true;
    if (direction == 'W' || direction == 'E') {
      long int futureRowPosition = numUntilNextRow + distanceSpan;
      // Checks if the future row position will be between 0 and 50
      notOutOfRow = (futureRowPosition >= 0) && (futureRowPosition <= (charPerRow - 1));
    }
    
    moveDistance--; // To account for extra character when outputting
    
    // Boundary check
    if (futurePosition >= 0 && futurePosition < maxSize && notOutOfRow) {
        for (int i = 1; i <= distance; i++) {
            // Set position for next character
            file.seekp(moveDistance, ios::cur);
            
            // Peek at the character that is after the current pointer position
            char peekChar = (char)file.peek();
            
            // Pen down/up check
            if (pen_status == 1) {
                file.seekp(1, ios::cur); // Move one space without changing anything since pen is up
            } else if (pen_status == 2 && peekChar != '\n') {
                // Bold precedence check
                if (isBold == true) {
                    file.put('#');
                } else {
                    if (peekChar != '#')
                        file.put('*');
                    else
                        file.seekp(1, ios::cur); // Skip the character one space due to bold precedence
                }
            }
        }
    }
}

void readFile(ifstream &commandsFile, fstream &paintFile) {
    // Track variable being read
    char currentChar;
    int currentReadPosition = 1;
    
    // Initialize variables for drawing
    int pen_status = -1;
    string distance = "";
    char direction = 'X';
    bool isBold = false, doPrint = false, isInvalid = false;
    
    while (true) {
        // Get the next character in the commands file
        commandsFile.get(currentChar);
        
        // Add one to read position when a comma or newline is encountered
        if (currentChar == ',' || currentChar == '\n')
            currentReadPosition++;
        
        // Apply the character being read into their respective variables
        switch(currentReadPosition) {
            case 1:
                if (currentChar == '1' || currentChar == '2')
                    pen_status = (int)currentChar - '0';
                break;
            case 2:
                if (currentChar == 'N' || currentChar == 'S' || currentChar == 'W' || currentChar == 'E')
                    direction = currentChar;
                break;
            case 3:
                // Check to remove any duplicates at EOF and unnecessary characters
                if (!commandsFile.eof() && currentChar != ',' && currentChar != '\n') {
                    // Since distance can be longer than single character, it is stored in a string
                    distance.push_back(currentChar);
                }
                break;
            case 4:
                // fall through
            case 5:
                if (currentChar == 'B' || currentChar == 'P') {
                    // Only check bold command for position 4
                    if (currentReadPosition == 4)
                        isBold = (currentChar == 'B');
                    
                    // Set print command for read positions 4 and 5
                    doPrint = (currentChar == 'P');
                } else if (currentChar != ',' && currentChar != '\n') {
                    isInvalid = true; // Set any other character as invalid
                }
                break;
        }
        
        // Reset after line is being finished read
        if (currentChar == '\n' || commandsFile.eof()) {
            // Input validation before drawing
            // Checks if the distance string only contains digits
            bool distanceDigitsOnly = (distance.find_first_not_of("1234567890") == string::npos);
            if (pen_status != -1 && direction != 'X' && distanceDigitsOnly && !isInvalid)
                draw(paintFile, pen_status, stoi(distance), direction, isBold);
            
            // Print file if the command line asks for it
            if (doPrint) {
                long int currentPointerPos = printFile(paintFile);
                paintFile.seekp(currentPointerPos);
            }
            
            // Reset variables after finishing reading a line
            currentReadPosition = 1;
            pen_status = -1;
            distance = "";
            direction = 'X';
            isBold = false;
            doPrint = false;
            isInvalid = false;
        }
        
        // Break loop at end of file
        if (commandsFile.eof())
            break;
    }
}

int main() {
   // Copy paint_base.txt to paint.txt
   ifstream infile("paint_base.txt");
   ofstream outfile("paint.txt", ios::binary);
   string c;
   if (infile)
      while (getline(infile, c))
         outfile << c << "\n";
        
   infile.close();
   outfile.close();
   
   // Ask for commands file
   string commandsFileName;
   cout << "Enter commands file name" << endl;
   cin >> commandsFileName;
   
   // Initialize commands and paint files
   ifstream commandsFile;
   fstream paintFile;
   
   commandsFile.open(commandsFileName, ios::binary);
   paintFile.open("paint.txt", ios::binary | ios::in | ios::out | ios::ate);
   
   // Check if files can be opened
   if (commandsFile.is_open() && paintFile.is_open()) {
      // Seek to beginning of the file before reading and drawing
      paintFile.seekp(1);
      
      // Read and draw onto paint.txt
      readFile(commandsFile, paintFile);
   } else {
      cout << "Error opening file(s)!" << endl;  
   }
   
   // Close the files and print the final result
   commandsFile.close();
   paintFile.close();
}