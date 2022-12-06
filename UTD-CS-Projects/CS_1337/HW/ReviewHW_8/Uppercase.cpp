// Review HW 8
// AXN210010 Andrew Nguyen

#include "Uppercase.h"

char Uppercase::transform(char ch) const {
    int charVal = (int)ch;
    
    // Check if character is a lowercase alphabet letter
    if (charVal >= 97 && charVal <= 122) {
        charVal -= 32; // Convert it to its uppercase version
        ch = (char)charVal;
    }
    
    return ch;
}

void Uppercase::doFilter(std::ifstream &in, std::ofstream &out) const {
    if (in.is_open() && out.is_open()) {
        char currentChar;
        while (in.get(currentChar)) {
            out << transform(currentChar);
        }
        in.close();
        out.close();
    }
}