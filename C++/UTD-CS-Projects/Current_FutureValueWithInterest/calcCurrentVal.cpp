//
// Created by Anh Phan Tran on 11/1/21.
//
#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

double presentValue(double futureValue,
                    double interestRate,
                    int numberYears);
double readFutureVal();
double readAnnualInterestRate();
int readNumOfYears();
void display(double presentValue, double futureValue, double rate, int years);


int main() {
    double futureVal = readFutureVal();
    double annualRatePct = readAnnualInterestRate();
    double convertedRate = annualRatePct / 100;
    int years = readNumOfYears();
    double presentVal = presentValue(futureVal, convertedRate, years);
    display(presentVal, futureVal, annualRatePct, years);

    return 0;
}

double presentValue(double futureValue,
                    double interestRate,
                    int numberYears) {
    return (futureValue / (pow( (1 + (interestRate)), numberYears)));
}

double readFutureVal() {
    double value;
    while (true) {
        cout << "Enter future value" << endl;
        cin >> value;
        if (value <= 0) {
            cout << "The future value must be greater than zero" << endl;
        } else {
            break;
        }
    }
    return value;
}

double readAnnualInterestRate() {
    double rate;
    while (true) {
        cout << "Enter annual interest rate" << endl;
        cin >> rate;
        if (rate <= 0) {
            cout << "The annual interest rate must be greater than zero" << endl;
        } else {
            break;
        }
    }
    return rate;
}

int readNumOfYears() {
    int years;
    while (true) {
        cout << "Enter number of years" << endl;
        cin >> years;
        if (years <= 0) {
            cout << "The number of years must be greater than zero" << endl;
        } else {
            break;
        }
    }
    return years;
}

void display(double presentValue, double futureValue, double rate, int years) {
    cout << fixed << setprecision(2)
         << "Present value: $" <<  presentValue << endl
         << "Future value: $" << futureValue << endl
         << fixed << setprecision(3)
         << "Annual interest rate: " << rate << "%" << endl
         << "Years: " << years << endl;
}