// Andrew Nguyen AXN210010
// Justin Lu JJL200014

#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "BasicShape.h"

class Rectangle : public BasicShape {
    private:
        double width;
        double length;
        
        virtual void calcArea() {
            area = width * length;
        }
        virtual void calcPerimeter() {
            perimeter = 2 * (width + length);  
        }
        
    public:
        Rectangle() { width = 1; length = 1; calcArea(); calcPerimeter(); }
        Rectangle(double x, double y) { width = x; length = y; calcArea(); calcPerimeter(); }
        
        void setWidth(double x)  { width = x; calcArea(); calcPerimeter(); }
        void setLength(double y) { length = y; calcArea(); calcPerimeter(); }

        double getWidth()  { return width; }
        double getLength() { return length; }
};

#endif