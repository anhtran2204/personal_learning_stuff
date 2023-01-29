#include <iostream>

using namespace std;

int main() {
    // User input for number of seconds
    long long int seconds;

    long long int minutes;
    long long int hours;
    long long int days;

    cout << "Enter seconds" << endl;
    cin >> seconds;

    if (seconds <= 0) {
        // Outputting values
        cout << "Total seconds: " << seconds << endl << endl;
        cout << "Total seconds must be greater than zero" << endl;
    } else {
        // Outputting total seconds
        cout << "Total seconds: " << seconds << endl << endl;

        // Converting seconds to minutes, hours, and days
        minutes = seconds / 60;
        seconds = seconds % 60;

        hours = minutes / 60;
        minutes = minutes % 60;

        days = hours / 24;
        hours = hours % 24;

        // Outputting values
        if (days != 0) {
            cout << days << " day(s)" << endl;
        }
        if (hours != 0) {
            cout << hours << " hour(s)" << endl;
        }
        if (minutes != 0) {
            cout << minutes << " minute(s)" << endl;
        }
        if (seconds != 0) {
            cout << seconds << " second(s)" << endl;
        }
    }
    return 0;
}
