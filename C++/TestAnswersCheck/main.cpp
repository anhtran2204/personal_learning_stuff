#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;

int read(ifstream& ifile, char studentAnswers[], int& size);
void display(const char studentAnswers[], const char answerKeys[], int& studentEntries, int& correctEntries);

int main() {
    ifstream studentAnswersFile;
    ifstream answerKeysFile;

    const int size = 30;
    char studentAnswers[size];
    char answerKeys[size];

    string studentAnswersFileName;
    cout << "Enter student answers file name" << endl;
    cin >> studentAnswersFileName;


//    studentAnswersFile.open("../inputFiles/" + studentAnswersFileName);
    studentAnswersFile.open(studentAnswersFileName);
    if (!studentAnswersFile) {
        cout << "File \"" << studentAnswersFileName << "\" could not be opened" << endl;
        studentAnswersFile.close();
    } else {
        string answerKeysFileName;
        cout << "Enter correct answer file name" << endl;
        cin >> answerKeysFileName;

//        answerKeysFile.open("../inputFiles/" + answerKeysFileName);
        answerKeysFile.open(answerKeysFileName);

        if (!answerKeysFile) {
            cout << "File \"" << answerKeysFileName << "\" could not be opened" << endl;
            studentAnswersFile.close();
            answerKeysFile.close();
        } else {
            int studentEntries = 0;
            int correctEntries = 0;

            read(studentAnswersFile, studentAnswers, studentEntries);
            read(answerKeysFile, answerKeys, correctEntries);

            display(studentAnswers, answerKeys, studentEntries, correctEntries);
            studentAnswersFile.close();
            answerKeysFile.close();
        }
    }

    return 0;
}

int read(ifstream& ifile, char studentAnswers[], int& size) {
    char inputValue;

    if (!ifile) {
        return -1;
    } else {
        while (true) {
            ifile >> inputValue;
            if (ifile.eof()) {
                break;
            }

            if (size >= 30) {
                return 30;
            }
            studentAnswers[size] = inputValue;
            size++;
        }
    }
    return size;
}

void display(const char studentAnswers[], const char answerKeys[], int& studentEntries, int& correctEntries) {
    if (studentEntries != correctEntries) {
        cout << "The student answers file has " << studentEntries
             << " entries and the correct answers file has " << correctEntries
             << " entries\nGrading cannot be done if they are not the same\n";
    } else if (studentEntries == 0 && correctEntries == 0) {
        cout << "The number of student answers and correct answers are both 0\n"
                "No grade can be calculated\n";
    } else {
        int incorrect = 0;
        for (int i = 0; i < studentEntries; i++) {
            if (studentAnswers[i] != answerKeys[i]) {
                cout << "Question " << i + 1 << " has incorrect answer \'" << studentAnswers[i] << "\', the correct answer is \'" << answerKeys[i] << "\'\n";
                incorrect++;
            }
        }

        double pcnt = ((double) (correctEntries - incorrect) / correctEntries) * 100.0;
        cout << fixed << setprecision(1)
             << incorrect << " questions were missed out of "
             << correctEntries << endl
             << "The student grade is "  << pcnt << "%\n";
        if (pcnt < 70.00) {
            cout << "The student failed\n";
        } else {
            cout << "The student passed\n";
        }
    }
}



