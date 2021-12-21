#include <string>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <vector>

using namespace std;

void read(ifstream& ifile, vector<double>& scores,
          vector<string>& names, string& firstName,
          string& lastName, double& midterm1Score,
          double& midterm2Score, double& finalScore);

void calculate(vector<double>& scores, double& avgMidterm1Score,
               double& avgMidterm2Score, double& avgFinalScore);

vector<char> assignLetterGrade(vector<double>& scores);

void display(ofstream& ofile,
             vector<string>& names, vector<double>& scores,
             const vector<char>& letterGrades,
             double& avgMidterm1Score, double& avgMidterm2Score, double& avgFinalScore);

int main() {
    ifstream ifile;
    ofstream ofile;
    string fileName;

    string firstName;
    string lastName;
    double midterm1Score;
    double midterm2Score;
    double finalExamScore;
    double classMidterm1AvgScore;
    double classMidterm2AvgScore;
    double classFinalAvgScore;

    vector<double> scores;
    vector<string> names;


    cout << "Enter input file name" << endl;
    cin >> fileName;

    ifile.open("../inputFiles/" + fileName);
    if (!ifile) {
        cout << "File \"" << fileName << "\" could not be opened" << endl;
        ifile.close();
    } else {
        ofile.open("report.txt");
        if (!ofile) {
            cout << "File \"report.txt\" could not be opened" << endl;
            ofile.close();
            ifile.close();
        } else {
            read(ifile, scores, names, firstName, lastName, midterm1Score, midterm2Score, finalExamScore);
            calculate(scores, classMidterm1AvgScore, classMidterm2AvgScore, classFinalAvgScore);
            display(ofile, names, scores, assignLetterGrade(scores), classMidterm1AvgScore, classMidterm2AvgScore, classFinalAvgScore);
        }
    }
    ofile.close();
    ifile.close();
    return 0;
}

void read(ifstream& ifile,
          vector<double>& scores, vector<string>& names,
          string& firstName, string& lastName,
          double& midterm1Score, double& midterm2Score, double& finalScore) {

    while (ifile) {
        ifile >> firstName >> lastName >> midterm1Score >> midterm2Score >> finalScore;
        names.push_back(firstName);
        names.push_back(lastName);
        scores.push_back(midterm1Score);
        scores.push_back(midterm2Score);
        scores.push_back(finalScore);
    }
}

void calculate(vector<double>& scores,
               double& avgMidterm1Score, double& avgMidterm2Score, double& avgFinalScore) {
    // Declare variables to calculate
    double midterm1Sum = 0;
    double midterm2Sum = 0;
    double finalSum = 0;

    int count = 0;
    for (int i = 0; i < scores.size() - 3; i += 3) {
        midterm1Sum += scores.at(i);
        midterm2Sum += scores.at(i + 1);
        finalSum += scores.at(i + 2);
        count++;
    }

    avgMidterm1Score = midterm1Sum / count;
    avgMidterm2Score = midterm2Sum / count;
    avgFinalScore = finalSum / count;
}

vector<char> assignLetterGrade(vector<double>& scores) {
    vector<char> letterGrades;
    double avgScore;

    for (int i = 0; i < scores.size() - 3; i += 3) {
        avgScore = (scores.at(i) + scores.at(i + 1) + scores.at(i + 2)) / 3;

        if (avgScore >= 90) {
            letterGrades.push_back('A');
        } else if (avgScore >= 80 && avgScore < 90) {
            letterGrades.push_back('B');
        } else if (avgScore >= 70 && avgScore < 80) {
            letterGrades.push_back('C');
        } else if (avgScore >= 60 && avgScore < 70) {
            letterGrades.push_back('D');
        } else {
            letterGrades.push_back('F');
        }
    }
    return letterGrades;
}

void display(ofstream& ofile,
             vector<string>& names, vector<double>& scores, const vector<char>& letterGrades,
             double& avgMidterm1Score, double& avgMidterm2Score, double& avgFinalScore) {
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < names.size() - 2 && j < scores.size() - 3 && k < letterGrades.size()) {
        ofile << names.at(i) << "\t" << names.at(i+1) << "\t"
             << scores.at(j) << "\t" << scores.at(j + 1) << "\t" << scores.at(j + 2) << "\t"
             << letterGrades.at(k) << endl;
        i += 2;
        j += 3;
        k++;
    }
    ofile << fixed << setprecision(2)
         << "\nAverages: midterm1 " << avgMidterm1Score
         << ", midterm2 " << avgMidterm2Score
         << ", final " << avgFinalScore << endl;
}