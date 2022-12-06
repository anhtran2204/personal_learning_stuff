// Review HW 8
// AXN210010 Andrew Nguyen

#ifndef ENCRYPTION_H
#define ENCRYPTION_H

#include <iostream>
#include <fstream>
#include "FileFilter.h"

class Encryption : public FileFilter {
    private:
        int key;
    
    public:
        // Constructors
        Encryption() { key = 5; }
        Encryption(int n) { key = n; }
        
        // Mutator
        void setKey(int n) { key = n; }
        
        // Filter
        void doFilter(std::ifstream&, std::ofstream&) const;
};

#endif