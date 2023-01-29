#include <iostream>

using namespace std;

int main() {
    cout << "/* Program is used to print all of the " << endl
         << " * ASCII characters within a specific range" << endl
         << " * given by the user input." << endl
         << " */" << endl;
    unsigned int lowerValue;
    unsigned int upperValue;

    unsigned char outputChar;

    while (true) {
        cout << "\nEnter lower and upper values\n";

        cin >> lowerValue;
        cin >> upperValue;

        if ((lowerValue >= 32 && upperValue <= 126) && (lowerValue <= upperValue)) {
            cout << "Characters for ASCII values between " << lowerValue << " and " <<  upperValue << endl;
            cout << "----+----+----+----+\n";
            for (auto i = lowerValue; i <= upperValue; i++) {
                if((i - lowerValue + 1) % 20 != 0) {
                    outputChar = (char) i;
                    cout << outputChar;
                    continue;
                } else {
                    if (i == upperValue) {
                        outputChar = (char) i;
                        cout << outputChar;
                        break;
                    }
                    outputChar = (char) i;
                    cout << outputChar;
                    cout << endl;
                }
            }
            cout << endl;
            cout << "----+----+----+----+\n";
            break;
        } else {
            cout << "Values must be in range 32 to 126 inclusive\n";
            continue;
        }
    }

    return 0;
}
