#include <iostream>
#include <iomanip>
#include <math.h>

using namespace std;

int main()
{
    int people;
    int numPizzas;
    double cost;

    cout << "Enter number of people: ";
    cin >> people;
    
    numPizzas = ceil((static_cast<double>(people) * 2) / 12);
    cost = numPizzas * 19.65;
    
    cout << "Pizzas: " << numPizzas << endl;
    cout << "Cost: " << fixed << setprecision(2) << cost << endl;
}