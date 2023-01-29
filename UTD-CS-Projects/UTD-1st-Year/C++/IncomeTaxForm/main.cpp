#include <iostream>
#include <cmath>

using namespace std;

int main() {

   /* Type your code here. */
   int wages;
   int taxInterest;
   int unemployComp;
   int status;
   int taxes;

   cin >> wages;
   cin >> taxInterest;
   cin >> unemployComp;
   cin >> status;
   cin >> taxes;

   int agi = wages + taxInterest + unemployComp;

   if (agi <= 120000) {
      cout << "AGI: $" << agi << endl;
      switch (status) {
         int deduction;
         int taxIncome;
         case 1:
            deduction = 12000;
            taxIncome = agi - deduction;
            if (taxIncome >= 0) {
               cout << "Deduction: $" << deduction << endl;
               cout << "Taxable income: $" << taxIncome << endl;
            } else {
               taxIncome = 0;
               cout << "Deduction: $" << deduction << endl;
               cout << "Taxable income: $" << taxIncome << endl;
            }
            break;

         case 2:
            deduction = 24000;
            taxIncome = agi - deduction;
            if (taxIncome >= 0) {
               cout << "Deduction: $" << deduction << endl;
               cout << "Taxable income: $" << taxIncome << endl;
            } else {
               taxIncome = 0;
               cout << "Deduction: $" << deduction << endl;
               cout << "Taxable income: $" << taxIncome << endl;
            }
            break;

         default:
            deduction = 12000;
            taxIncome = agi - deduction;
            if (taxIncome >= 0) {
               cout << "Deduction: $" << deduction << endl;
               cout << "Taxable income: $" << taxIncome << endl;
            } else {
               taxIncome = 0;
               cout << "Deduction: $" << deduction << endl;
               cout << "Taxable income: $" << taxIncome << endl;
            }
            break;
      }
   } else {
      cout << "AGI: $" << agi << endl;
      cout << "Error: Income too high to use this form" << endl;
   }
   return 0;
}
