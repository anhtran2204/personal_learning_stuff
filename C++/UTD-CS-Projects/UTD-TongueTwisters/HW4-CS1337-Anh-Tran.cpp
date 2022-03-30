/*
    Name: Anh Tran
    Program name: TongueTwisters
    Date Created: 01/24/22
    Notes:
        -   be able to process each sentence at a time, split the words, 
            and then report the statistics of it
            -   show the number of characters in the sentence
            -   show the number of words in the sentence
            -   show the number of vowels, consonants, punctuations, and other
                characters in the senctence
            -   change the case of each sentence in 4 ways: title case, sentence
                case, toggle case, and mocking case
    Changelog:
        -   03/24/22 - v1: 
            -   added openFile() to open file
            -   added input() to process the data in the file into a vector
            -   added display()
        -   03/26/22 - v2:
            -   added spliceSentence() to split the words in a sentence
                into a 2d vector
            -   added numOfChar() to count the number of characters
        -   03/28/22 - v3:
            -   added the cases methods for different cases for 
                the sentences 
            -   added isvowel() to check if char is a vowel or consonant
            -   added functionality to check the longest word in each 
                sentence in the spliceSentence()
            -   added functionality in numOfChar() to also check for vowels, 
                consonants, punctuation symbols, and spaces, as well as 
                showing the number of words in a sentence
*/

#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

#define sp " "
#define br "---------------------------------"

vector<string> properNouns = {
    "Amy", "Spain", "Suzy", "Becky", "Billy",
    "Dan", "Fred", "Fritos", "Friday's", "Rudolph",
    "Hertford", "Hereford", "Hampshire", "Henry", "I"
    "Higgins", "Liza", "Rhine", "Cockney", "My Fair Lady"
};

void openFile(fstream& file, string fileName) {
    cout << "Enter file name: ";
    cin >> fileName;

    file.open("./inputFiles/" + fileName);
}

bool isvowel(char ch) {
    string vowels = "aeiou";
    return vowels.find(tolower(ch)) != -1;
}

void numOfChar(string sentence) {
    int numOfVowels = 0;
    int numOfConsonants = 0;
    int numOfPunctuation = 0;
    int numOfSpaces = 0;
    for (auto ch : sentence) {
        if (!isspace(ch)) {
            if (ispunct(ch)) {
                numOfPunctuation++;
            } else {
                if (isvowel(ch)) {
                    numOfVowels++;
                } else {
                    numOfConsonants++;
                }
            }
        } else {
            numOfSpaces++;
        }
    }
    cout << "Number of characters in the sentence:" << sp << sentence.length() << endl;
    cout << "Number of vowels in the sentence:" << sp << numOfVowels << endl;
    cout << "Number of consonants in the sentence:" << sp << numOfConsonants << endl;
    cout << "Number of punctuations in the sentence:" << sp << numOfPunctuation << endl;
    cout << "Number of spaces in the sentence:" << sp << numOfSpaces << endl;
}

void titleCase(string sentence) {
    string convertedStr = "";
    for (int i = 0; i < sentence.size(); i++) {
        char ch = sentence[i];
        if (i == 0) {
            ch = toupper(ch);
            convertedStr += ch;
        } else if (isspace(sentence[i - 1])) {
            ch = toupper(ch);
            convertedStr += ch;
        } else {
            convertedStr += ch;
        }
    }
    cout << "+ Title Case:" << sp << "\'" + convertedStr + "\'"<< endl << endl;
}

bool checkProperNouns(string wordToFind) {
    for (string word : properNouns) {
        if (word == wordToFind) {
            return true;
        }
    }
    return false;
}

void sentenceCase(string sentence) {
    string convertedStr = "";
    int spaceIndex = sentence.find(" ");
    bool firstWord = true;
    bool lastWord = false;
    while (spaceIndex > 0) {
        if (firstWord) {
            string word = sentence.substr(0, spaceIndex);
            word[0] = toupper(word[0]);
            sentence = sentence.substr(spaceIndex + 1);
            convertedStr += word + sp;
            firstWord = false;
        } else {
            string word = sentence.substr(0, spaceIndex);
            if (checkProperNouns(word)) {
                sentence = sentence.substr(spaceIndex + 1);
                convertedStr += word + sp;
            } else {
                word[0] = tolower(word[0]);
                sentence = sentence.substr(spaceIndex + 1);
                convertedStr += word + sp;
            }
        }
        spaceIndex = sentence.find(" ");
        if (spaceIndex < 0) {
            sentence[0] = tolower(sentence[0]);
            convertedStr += sentence;
        }
    }
    cout << "+ Sentence Case:" << sp << "\'" + convertedStr + "\'" << endl << endl;
}

void toggleCase(string sentence) {
    string convertedStr = "";
    for (int i = 0; i < sentence.size(); i++) {
        char ch = sentence[i];
        if (i == 0 || isspace(sentence[i - 1])) {
            ch = tolower(ch);
            convertedStr += ch;
        } else {
            ch = toupper(ch);
            convertedStr += ch;
        }
    }
    cout << "+ Toggle Case:" << sp << "\'" + convertedStr + "\'" << endl << endl;
}

void mockingCase(string sentence) {
    srand(time(0));

    string convertedStr = "";
    for (char ch : sentence) {
        if (rand() % 2 == 0) {
            ch = toupper(ch);
            convertedStr += ch;
        } else {
            ch = tolower(ch);
            convertedStr += ch;
        }
    }
    cout << "+ Mocking Case:" << sp << "\'" + convertedStr + "\'" << endl;
}

void display(string sentence, int numOfWords, string longestWord) {
    cout << br << "\n\nThe current sentence is:" << sp << "\'" + sentence + "\'" << endl;
    cout << "Number of words in the sentence:" << sp << numOfWords << endl;
    cout << "The longest word in the sentence:" << sp << longestWord << endl << endl;
    numOfChar(sentence);
    cout << endl;
    titleCase(sentence);
    sentenceCase(sentence);
    toggleCase(sentence);
    mockingCase(sentence);
    cout << endl;
}

void spliceSentence(vector<vector<string>>& words, string sentence) {
    stringstream ss(sentence);
    string word;

    int line = 0;
    int numOfWords = 0;
    int max = 0;
    string longestWord = "";
    vector<string> lineWords;
    while (ss >> word) {
        int temp = word.length();
        if (temp > max) {
            max = temp;
            longestWord = word;
        }
        numOfWords++;
        lineWords.push_back(word);
    }
    words.push_back(lineWords);

    display(sentence, numOfWords, longestWord);
}

void input(fstream& file, vector<string>& sentences, vector<vector<string>>& words) {
    string fileName;
    openFile(file, fileName);
    if (!file) {
        cout << "File doesn't exist!" << endl 
             << "Please try another name." << endl << endl;
        file.close();
        input(file, sentences, words);
    } else {
        cout << endl << "Inputting data from file..." << endl << endl;
        while (file.good()) {
            if (file.eof()) {
                break;
            }
            string sentence;
            getline(file, sentence);
            sentences.push_back(sentence);
            spliceSentence(words, sentence);
        }
    }
    file.close();
}

int main() {
    fstream file;

    vector<string> sentences;
    vector<vector<string>> words;

    input(file, sentences, words);
    return 0;
}