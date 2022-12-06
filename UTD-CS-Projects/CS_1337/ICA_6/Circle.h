// Andrew Nguyen AXN210010
// Justin Lu JJL200014

#ifndef CIRCLE_H
#define CIRCLE_H

#include <math.h>
#include "BasicShape.h"

class Circle : public BasicShape {
    private:
        double centerX;
        double centerY;
        double radius;
        
        virtual void calcArea() {
            area = M_PI * pow(radius, 2);
        }
        virtual void calcPerimeter() {
            perimeter = 2 * M_PI * radius;  
        }
        
    public:
        Circle() {
            centerX = 1; centerY = 1; radius = 1;
            calcArea(); calcPerimeter();
        }
        Circle(double x, double y, double r) {
            centerX = x; centerY = y; radius = r;
            calcArea(); calcPerimeter();
        }
        
        void setCenterX(double x) { centerX = x; calcArea(); calcPerimeter();}
        void setCenterY(double y) { centerY = y; calcArea(); calcPerimeter();}
        void setRadius(double r)  { radius = r; calcArea(); calcPerimeter(); }
        
        double getCenterX() { return centerX; }
        double getCenterY() { return centerY; }
        double getRadius() { return radius; }
};

#endif