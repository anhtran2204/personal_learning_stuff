// Review HW 8
// AXN210010 Andrew Nguyen

#include "Encryption.h"

void Encryption::doFilter(std::ifstream &in, std::ofstream &out) const {
    if (in.is_open() && out.is_open()) {
        char currentChar, moddedChar;
        int charVal;
        
        while (in.get(currentChar)) {
            // Check for newline in the file
            if (currentChar != '\n') {
                charVal = (int)currentChar;
                charVal += key;
                
                // Check if out of the range
                if (charVal > 126)
                    charVal = 32 + (charVal % (126 + 1));
                if (charVal < 32)
                    charVal = (126 + 1) - (32 % charVal);
                
                moddedChar = (char)charVal;
            } else {
                moddedChar = '\n';
            }
            out << moddedChar;
        }
        
        in.close();
        out.close();
    }
}