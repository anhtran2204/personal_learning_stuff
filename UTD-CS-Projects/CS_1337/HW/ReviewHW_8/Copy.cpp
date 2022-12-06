// Review HW 8
// AXN210010 Andrew Nguyen

#include "Copy.h"

void Copy::doFilter(std::ifstream &in, std::ofstream &out) const {
    if (in.is_open() && out.is_open()) {
        char currentChar;
        while (in.get(currentChar)) {
            out << currentChar;
        }
        in.close();
        out.close();
    }
}