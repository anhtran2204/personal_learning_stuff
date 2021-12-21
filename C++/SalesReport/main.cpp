#include <iostream>
#include <iomanip>
#include <fstream>

using namespace std;

string printBarChart(long long int salesData);
void display(ofstream &os, long long int sales, unsigned int store);
bool read(ifstream &is, long long int &sales, unsigned int &store);

int main() {
    ifstream inputFile;
    ofstream outputFile;
    string inputFileName;

    cout << "Enter input file name" << endl;
    cin >> inputFileName;
    inputFile.open("../part1inputFiles/" + inputFileName);
    outputFile.open("saleschart.txt");

    bool first = true;
    unsigned int storeNum;
    long long int salesData;

    while(read(inputFile, salesData, storeNum)) {
        if(first) { //print header for first
            outputFile << "SALES BAR CHART\n"
                       << "(Each X equals 1,000 dollars)\n";
            first = false;
        }
        display(outputFile, salesData, storeNum);
    }
    //close both files
    inputFile.close();
    outputFile.close();

//    if (inputFile)
//    {
//        if (outputFile) {
//            // The input file and output file opened successfully
//
////            // Print to console
////            cout << "SALES BAR CHART" << endl;
////            cout << "(Each * equals 5,000 dollars)" << endl;
//
//            /* Write to file */
//            outputFile << "SALES BAR CHART" << endl;
//            outputFile << "(Each * equals 5,000 dollars)" << endl;
//            while (inputFile >> storeNum >> salesData)
//            {
//                if (storeNum >= 1 && storeNum <= 99) {
//                    if (salesData > 0) {
//                        // Process the storeNum value and salesData
////                        cout << "Store " << right << setw(2) << storeNum << ": " << printBarChart(salesData) << endl;
//                        outputFile << "Store " << right << setw(2) << storeNum << ": " << printBarChart(salesData) << endl;
//                    }
//                    else {
//                        cout << "The sales value for store " << storeNum << " is negative" << endl;
//                    }
//                }
//                else {
//                    cout << "The store number " << storeNum << " is not valid" << endl;
//                }
//            }
//            // Program ran successfully and close both files
//            inputFile.close();
////            cout << "Input file closed successfully" << endl;
//            outputFile.close();
////            cout << "Output file closed successfully" << endl;
//        }
//            // Output file didn't open
//        else {
//            cout << "File \"saleschart.txt\" could not be opened" << endl;
//            inputFile.close();
//        }
//    }
//    // Input file didn't open
//    else
//    {
//        cout << "File \"" << inputFileName << "\" could not be opened" << endl;
//    }
    return 0;
}

bool read(ifstream &is, long long int &sales, unsigned int &store) {
    int tmpstore; // to ensure negative values can be read for store as well
    is >> tmpstore >> sales; // read from file
    while(is) { // continue till valid data is present, i.e. not EOF
        if(tmpstore < 1 || tmpstore > 99) {
            cout << "The store number " << tmpstore << " is not valid\n";
        } else if(sales < 0) {
            cout << "The sales value for store " << tmpstore << " is negative\n";
        } else { // valid data
            store = tmpstore;
            return true; // valid data, end loop as well as function
        }

        is >> tmpstore >> sales; // read next data
    }
    return false; // reached here implies end of file
}

void display(ofstream &os, long long int sales, unsigned int store) {
    os << "Store " << setw(2) << store << ": ";
    for(int i = 0; i < sales/5000; i++)
        os << "*";
    os << "\n";
}

string printBarChart(long long int salesData) {
    string bar;
    long long int barLength = salesData / 5000;
    for (auto i = 0; i < barLength; i++) {
        bar += "*";
    }
    return bar;
}