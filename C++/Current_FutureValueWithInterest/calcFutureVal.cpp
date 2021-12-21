//
// Created by Anh Phan Tran on 11/8/21.
//

#include <iostream>
#include <iomanip>
#include <fstream>
#include <cmath>

using namespace std;

double futureValue(double presentValue, double interestRate, int months);
unsigned int read(ifstream& ifile, double& presentVal, double& monthlyRate, int &months);
void display(ofstream& ofile, double& futureVal, double& presentVal, double& monthlyRate, int months);

int main() {
    ifstream ifile;
    ofstream ofile;

    string fileName;
    cout << "Enter input file name" << endl;
    cin >> fileName;

    double presentVal;
    double interestRate;
    int months;

//    ifile.open("../inputFiles/" + fileName);
    ifile.open(fileName);
    ofile.open("output.xls");

    if (!ifile) {
        cout << "File \"" << fileName << "\" could not be opened" << endl;
        ifile.close();
    }

    if (!ofile) {
        cout << "File \"output.xls\" could not be opened" << endl;
        ofile.close();
        ifile.close();
    }

    double futureVal;
    ofile << "Future Value\tPresent Value\tMonthly Interest\tMonths" << endl;
    while (read(ifile, presentVal, interestRate, months) != 0) {
        double convertedRate = interestRate / 100;
        futureVal = futureValue(presentVal, convertedRate, months);
        display(ofile, futureVal, presentVal, interestRate, months);
    }

    return 0;
}

double futureValue(double presentValue, double interestRate, int months) {
    return presentValue * (pow((1 + interestRate), months));
}

unsigned int read(ifstream& ifile, double& presentVal, double& monthlyRate, int& months) {
    ifile >> presentVal >> monthlyRate >> months;
    while (ifile) {
        if (presentVal <= 0.00 || monthlyRate <= 0.000 || months <= 0) {
            cout << fixed << setprecision(2)
                 << presentVal << " "
                 << fixed << setprecision(3)
                 << monthlyRate << " "
                 << months << endl;
            cout << "One or more of the above values are not greater than zero" << endl;
            return 2;
        } else {
            return 1;
        }
    }
    return 0;
}

void display(ofstream& ofile, double& futureVal, double& presentVal, double& monthlyRate, int months) {
    ofile << fixed << setprecision(2)
          << futureVal << "\t"
          << presentVal << "\t"
          << fixed << setprecision(3)
          << monthlyRate << "\t"
          << months << endl;
}
