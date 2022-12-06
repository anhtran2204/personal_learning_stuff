// Review HW 8
// AXN210010 Andrew Nguyen

#ifndef UPPERCASE_H
#define UPPERCASE_H

#include <iostream>
#include <fstream>
#include "FileFilter.h"

class Uppercase : public FileFilter {
    public:
        char transform(char) const;
        void doFilter(std::ifstream&, std::ofstream&) const;
};

#endif