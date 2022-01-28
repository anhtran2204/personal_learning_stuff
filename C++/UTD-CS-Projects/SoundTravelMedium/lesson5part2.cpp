//
// Created by anhph on 10/23/2021.
//

#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    const double CO2 = 258.0;
    const double AIR = 331.5;
    const double HELIUM = 972.0;
    const double HYDROGEN = 1270.0;

    double time;
    double distance;

    cout << "Select the medium that sound is traveling through:\n"
            "1 Carbon Dioxide\n"
            "2 Air\n"
            "3 Helium\n"
            "4 Hydrogen\n";

    unsigned int choice;
    cin >> choice;

    if (choice == 1) {
        cout << "Enter time (in seconds)" << endl;
        cin >> time;
        bool timeCheck = (time >= 0.000 && time <= 30.000);

        if (timeCheck) {
            distance = time * CO2;

            cout << "Carbon Dioxide: " << fixed << setprecision(3) << time << " seconds" << endl;
            cout << "Traveled " << fixed << setprecision(4) << distance << " meters" << endl;
        } else {
            cout << "The time must be between 0.000 and 30.000 (inclusive)" << endl;
        }
    } else if (choice == 2) {
        cout << "Enter time (in seconds)" << endl;
        cin >> time;
        bool timeCheck = (time >= 0.000 && time <= 30.000);

        if (timeCheck) {
            distance = time * AIR;

            cout << "Air: " << fixed << setprecision(3) << time << " seconds" << endl;
            cout << "Traveled " << fixed << setprecision(4) << distance << " meters" << endl;
        } else {
            cout << "The time must be between 0.000 and 30.000 (inclusive)" << endl;
        }
    } else if (choice == 3) {
        cout << "Enter time (in seconds)" << endl;
        cin >> time;
        bool timeCheck = (time >= 0.000 && time <= 30.000);

        if (timeCheck) {
            distance = time * HELIUM;

            cout << "Helium: " << fixed << setprecision(3) << time << " seconds" << endl;
            cout << "Traveled " << fixed << setprecision(4) << distance << " meters" << endl;
        } else {
            cout << "The time must be between 0.000 and 30.000 (inclusive)" << endl;
        }
    } else if (choice == 4) {
        cout << "Enter time (in seconds)" << endl;
        cin >> time;
        bool timeCheck = (time >= 0.000 && time <= 30.000);

        if (timeCheck) {
            distance = time * HYDROGEN;

            cout << "Hydrogen: " << fixed << setprecision(3) << time << " seconds" << endl;
            cout << "Traveled " << fixed << setprecision(4) << distance << " meters" << endl;
        } else {
            cout << "The time must be between 0.000 and 30.000 (inclusive)" << endl;
        }
    } else {
        cout << "The menu value is invalid. Please run the program again." << endl;
    }

    return 0;
}
