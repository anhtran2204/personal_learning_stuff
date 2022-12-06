// Andrew Nguyen AXN210010
// Justin Lu JJL200014

#include <iostream>

#include "BasicShape.h"
#include "Circle.h"
#include "Rectangle.h"

using namespace std;

void displayInfo(BasicShape *shape) {
    cout << "Area: " << shape->getArea() << endl;
    cout << "Perimeter: " << shape->getPerimeter() << endl; 
}

int main() {
    BasicShape *circle = new Circle(2, 3, 7);
    BasicShape *rectangle = new Rectangle(12, 2);
    
    displayInfo(circle);
    displayInfo(rectangle);
    
    return 0;
}
