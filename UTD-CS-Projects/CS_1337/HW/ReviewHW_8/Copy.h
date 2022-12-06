// Review HW 8
// AXN210010 Andrew Nguyen

#ifndef COPY_H
#define COPY_H

#include <iostream>
#include <fstream>
#include "FileFilter.h"

class Copy : public FileFilter {
    public:
        void doFilter(std::ifstream&, std::ofstream&) const;
};

#endif