#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    const int AIR = 1100;
    const int WATER = 4900;
    const int STEEL = 16400;

    double distance;
    double seconds;

    cout << "Select the medium that sound is traveling through:\n"
            "1 Air\n"
            "2 Water\n"
            "3 Steel\n";

    unsigned int choice;
    cin >> choice;

    switch (choice) {
        case 1:
            cout << "Enter distance (in feet)" << endl;
            cin >> distance;
            if (distance > 0) {
                seconds = distance / AIR;

                cout << "Air: " << fixed  <<  setprecision(4) << distance << " ft" << endl;
                cout << "Traveled for " << fixed <<  setprecision(4) << seconds << " seconds" << endl;
            } else {
                cout << "The distance must be greater than zero" << endl;
            }
            break;

        case 2:
            cout << "Enter distance (in feet)" << endl;
            cin >> distance;
            if (distance > 0) {
                seconds = distance / WATER;

                cout << "Water: " << fixed <<  setprecision(4) << distance << " ft" << endl;
                cout << "Traveled for " << fixed <<  setprecision(4) << seconds << " seconds" << endl;
            } else {
                cout << "The distance must be greater than zero" << endl;
            }
            break;

        case 3:
            cout << "Enter distance (in feet)" << endl;
            cin >> distance;
            if (distance > 0) {
                seconds = distance / STEEL;

                cout << "Steel: " << fixed << setprecision(4) << distance << " ft" << endl;
                cout <<  "Traveled for " << fixed << setprecision(4) << seconds << " seconds" << endl;
            } else {
                cout << "The distance must be greater than zero" << endl;
            }
            break;

        default:
            cout << "The menu value is invalid. Please run the program again." << endl;
            break;
    }

    return 0;
}
