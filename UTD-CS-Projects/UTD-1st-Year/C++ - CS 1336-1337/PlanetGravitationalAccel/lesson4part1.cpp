#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    const double GRAVITY_ACCEL_EARTH = 9.81;
    const double GRAVITY_ACCEL_MOON = 1.62;
    const double GRAVITY_ACCEL_VENUS = 8.87;

    // In kilograms (kg)
    double mass;
    // In Newtons (N)
    double weightOnEarth;
    double weightOnMoon;
    double weightOnVenus;

    // User input for mass
    cout << "Enter the mass in kg" << endl;
    cin >> mass;

    if (mass <= 0.0000) {
        cout << "The mass is " << fixed << setprecision(4) <<
                mass  << " kg" << endl;
        cout << "The mass must be greater than zero" << endl;
    } else {
        // Conversion of mass to weight
        weightOnEarth = mass * GRAVITY_ACCEL_EARTH;
        weightOnMoon = mass * GRAVITY_ACCEL_MOON;
        weightOnVenus = mass * GRAVITY_ACCEL_VENUS;

        // Outputting the weight values
        cout << "The mass is " << fixed << setprecision(4) << mass << " kg" << endl;
        cout << left << setw(8) << "Location" <<
             right << setw(14) << "Weight (N)" << endl;
        cout << left << setw(8) << "Earth" <<
             right << setw(14) <<
             fixed << setprecision(4) << weightOnEarth << endl;
        cout << left << setw(8) << "Moon" <<
             right << setw(14) <<
             fixed << setprecision(4) << weightOnMoon << endl;
        cout << left << setw(8) << "Venus" <<
             right << setw(14) <<
             fixed << setprecision(4) << weightOnVenus << endl;

        // Condition for weight
        if (weightOnEarth >= 1500.0000) {
            cout << "The object is heavy" << endl;
        } else if (weightOnEarth <= 5.0000) {
            cout << "The object is light" << endl;
        }
    }

    return 0;
}
