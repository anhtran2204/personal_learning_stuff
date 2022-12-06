// Review HW 8
// AXN210010 Andrew Nguyen

#ifndef FILEFILTER_H
#define FILEFILTER_H

#include <iostream>
#include <fstream>

class FileFilter {
    public:
        virtual void doFilter(std::ifstream &in, std::ofstream &out) const = 0;
};

#endif