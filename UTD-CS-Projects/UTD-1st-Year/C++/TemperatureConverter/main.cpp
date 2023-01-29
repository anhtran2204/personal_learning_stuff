//
// Created by Anh Phan Tran on 10/25/21.
//
#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    double startingFahrenheit;
    double endingFahrenheit;
    double increment;

    double celsius;
    double kelvin;

    cout << fixed << setprecision(4);
    while (true) {
        cin >> startingFahrenheit;
        cin >> endingFahrenheit;
        cin >> increment;

        if ( (startingFahrenheit <= endingFahrenheit) && (increment > 0.0) ) {
            cout << right
                << setw(18) << "Fahrenheit"
                << setw(18) << "Celsius"
                << setw(18) << "Kelvin"
                << endl;

            while (startingFahrenheit <= endingFahrenheit) {
                celsius = (startingFahrenheit - 32) / 1.8;
                kelvin = celsius + 273.15;
                cout << right
                    << setw(18) << startingFahrenheit
                    << setw(18) << celsius
                    << setw(18) << kelvin
                    << endl;
                startingFahrenheit += increment;
            }
            break;
        } else {
            cout << "Starting temperature must be <= ending temperature and increment must be > 0.0" << endl;
            continue;
        }
    }

}


