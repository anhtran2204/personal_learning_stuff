#include <iostream>
#include <iomanip>

using namespace std;

void read(int& spoolsOrder, int& spoolsInStock, double& specialShippingHandlingCharge);
void display(int& spoolsOrder, int& spoolsInStock, double& specialShippingHandlingCharge, const double cost = 104);

int main() {
    int spoolsOrder;
    int spoolsInStock;
    double specialShippingHandlingCharge;

    read(spoolsOrder, spoolsInStock, specialShippingHandlingCharge);
    display(spoolsOrder, spoolsInStock, specialShippingHandlingCharge);

    return 0;
}

void read(int& spoolsOrder, int& spoolsInStock, double& specialShippingHandlingCharge) {
    while (true) {
        cout << "Spools to be ordered" << endl;
        cin >> spoolsOrder;
        if (spoolsOrder < 1) {
            cout << "Spools order must be 1 or more" << endl;
        } else {
            break;
        }
    }

    while (true) {
        cout << "Spools in stock" << endl;
        cin >> spoolsInStock;
        if (spoolsInStock < 0) {
            cout << "Spools in stock must be 0 or more" << endl;
        } else {
            break;
        }
    }

    string s;
    while (true) {
        cout << "Special shipping and handling (y or n)" << endl;
        cin >> s;
        if (s == "n") {
            specialShippingHandlingCharge = 12.99;
            break;
        } else if (s == "y") {
            while (true) {
                cout << "Shipping and handling amount" << endl;
                cin >> specialShippingHandlingCharge;
                if (specialShippingHandlingCharge < 0.0000) {
                    cout << "The spool shipping and handling charge must be 0.0 or more" << endl;
                } else {
                    break;
                }
            }
            break;
        }
    }
}

void display(int& spoolsOrder, int& spoolsInStock, double& specialShippingHandlingCharge, const double cost) {
    if (spoolsOrder <= spoolsInStock) {
        int onBackOrder = 0;
        double subtotal = spoolsOrder * cost;
        double totalShipping = spoolsInStock * specialShippingHandlingCharge;
        double totalCost = subtotal + totalShipping;

        cout << "Spools ready to ship: " << spoolsOrder << endl
             << "Spools on back-order: " << onBackOrder << endl
             << fixed << setprecision(2)
             << "Subtotal ready to ship: $"
             << right << setw(10) << subtotal << endl
             << "Shipping and handling:  $"
             << right << setw(10) << totalShipping << endl
             << "Total shipping charges: $"
             << right << setw(10) << totalCost << endl;
    } else {
        int onBackOrder = spoolsOrder - spoolsInStock;
        int readyOrder = spoolsOrder - onBackOrder;
        double subtotal = spoolsInStock * cost;
        double totalShipping = spoolsInStock * specialShippingHandlingCharge;
        double totalCost = subtotal + totalShipping;

        cout << "Spools ready to ship: " << readyOrder << endl
             << "Spools on back-order: " << onBackOrder << endl
             << fixed << setprecision(2)
             << "Subtotal ready to ship: $"
             << right << setw(10) << subtotal << endl
             << "Shipping and handling:  $"
             << right << setw(10) << totalShipping << endl
             << "Total shipping charges: $"
             << right << setw(10) << totalCost << endl;
    }
}