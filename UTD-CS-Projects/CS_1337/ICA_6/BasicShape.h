// Andrew Nguyen AXN210010
// Justin Lu JJL200014

#ifndef BASICSHAPE_H
#define BASICSHAPE_H

class BasicShape {
    protected:
        double area;
        double perimeter;
        
    public:
        double getArea() { return area; }
        double getPerimeter() { return perimeter; }
        
        virtual void calcArea() = 0;
        virtual void calcPerimeter() = 0;
};

#endif