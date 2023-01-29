#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

double readSeconds();
double calculateEarthDistance(double seconds);
double calculateMoonDistance(double seconds);
void displayResults(double seconds, double earthDistance, double moonDistance);

int main() {
    double seconds = readSeconds();
    while (seconds != 0) {
        displayResults(
                seconds,
                calculateEarthDistance(seconds),
                calculateMoonDistance(seconds)
        );
        seconds = readSeconds();
    }

    return 0;
}

double readSeconds() {
    double seconds;
    while (true) {
        cout << "Enter the time (in seconds)" << endl;
        cin >> seconds;
        if (seconds < 0) {
            cout << "The time must be zero or more" << endl;
            continue;
        } else if (seconds == 0) {
            return 0;
        }
        break;
    }
    return seconds;
}

double calculateEarthDistance(double seconds) {
    const double EARTH_GRAVITATIONAL_ACCEL = 9.8;
    return 0.5 * EARTH_GRAVITATIONAL_ACCEL * pow(seconds, 2);
}

double calculateMoonDistance(double seconds) {
    const double MOON_GRAVITATIONAL_ACCEL = 1.6;
    return 0.5 * MOON_GRAVITATIONAL_ACCEL * pow(seconds, 2);
}

void displayResults(double seconds, double earthDistance, double moonDistance) {
    cout << fixed << setprecision(4)
         << "The object traveled " << earthDistance
         << fixed << setprecision(2)
         << " meters in " << seconds << " seconds on Earth" << endl
         << fixed << setprecision(4)
         << "The object traveled " << moonDistance
         << fixed << setprecision(2)
         << " meters in " << seconds << " seconds on the Moon" << endl;
}