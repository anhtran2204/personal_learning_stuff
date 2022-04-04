#include <iostream>

using namespace std;

#define sp " "

struct animalNode {
    string question;
    string guess;
    animalNode* yesPtr;
    animalNode* noPtr;
};

animalNode* head;

animalNode* initializeRoot() {
    animalNode* root = new animalNode;
    root->question = "";
    root->guess = "lizard";
    root->yesPtr, root->noPtr = nullptr;
    return root;
}


animalNode* initializeNode() {
    animalNode* node = new animalNode;
    node->question = "";
    node->guess = "";
    node->yesPtr, node->noPtr = nullptr;
    return node;
}

void insertNode(animalNode* node) {
    if (!head) {
        head = initializeRoot();
    } else {
        
    }
}

bool restart() {
    cout << "Try again?" << endl;
    string flag;
    getline(cin, flag);

    while (true) {
        if (flag == ": y") {
            return true;
        } else if (flag == ": n") {
            return false;
        } else {
            cout << "Please enter valid response!" << endl;
        }
    }
}

void intro() {
    cout << "Let's play the \"Guess the Animal\" game.\n"
         << "Think of an animal and hit return when you're ready." << endl;
}

void start() {
    intro();

    string Q_and_A;
    if (!head) {
        head = initializeRoot();
        cout << "Is it a(n)" << sp << head->guess << "?" << endl;
        cin >> Q_and_A;

        if (Q_and_A == "Y" || Q_and_A == "y") {
            if (restart()) {
                start();
            }
        } else if (Q_and_A == "N" || Q_and_A == "n") {
            cout << "Bummer! What animal were you thinking of?" << endl;
            cin >> Q_and_A;
            cin.ignore();

            animalNode* newQuestion = initializeNode();
            animalNode* newGuess = initializeNode();
            newGuess->guess = Q_and_A;

            cout << "What is a yes/no question that I can use to tell a" 
                 << sp << head->guess << sp << "from a" << sp << newGuess->guess << endl;
            
            getline(cin, Q_and_A);
            newQuestion->question = Q_and_A;

            cout << "For a" << sp << newGuess->guess << ", is the answer yes or no?" << endl;
            cin >> Q_and_A;
            cin.ignore();

            if (Q_and_A == "Y" || Q_and_A == "y") {
                newQuestion->yesPtr = newGuess;
                newQuestion->noPtr = head;
            } else if (Q_and_A == "N" || Q_and_A == "n") {
                newQuestion->noPtr = newGuess;
                newQuestion->yesPtr = head;
            }

            if (restart()) {
                start();
            }
        }
    } else {
        animalNode* curNode = head;
        while (curNode->yesPtr != nullptr || curNode->noPtr != nullptr) {
            cout << curNode->question << endl;
            cin >> Q_and_A;
            cin.ignore();

            if (Q_and_A == "Y" || Q_and_A == "y") {
                curNode = curNode->yesPtr;
            } else if (Q_and_A == "N" || Q_and_A == "n") {
                curNode = curNode->noPtr;
            }
        }
        cout << "Is it a(n)" << sp << curNode->guess << endl;
        cin >> Q_and_A;
        cin.ignore();

        if (Q_and_A == "Y" || Q_and_A == "y") {
            if (restart()) {
                start();
            }
        } else if (Q_and_A == "N" || Q_and_A == "n") {
            cout << "Bummer! What animal were you thinking of?" << endl;
            cin >> Q_and_A;
            cin.ignore();

            animalNode* newQuestion = initializeNode();
            animalNode* newGuess = initializeNode();
            newGuess->guess = Q_and_A;

            cout << "What is a yes/no question that I can use to tell a" 
                 << sp << curNode->guess << sp << "from a" << sp << newGuess->guess << endl;
            
            getline(cin, Q_and_A);
            newQuestion->question = Q_and_A;

            cout << "For a" << sp << newGuess->guess << ", is the answer yes or no?" << endl;
            cin >> Q_and_A;
            cin.ignore();

            if (Q_and_A == "Y" || Q_and_A == "y") {
                newQuestion->yesPtr = newGuess;
                newQuestion->noPtr = curNode;
            } else if (Q_and_A == "N" || Q_and_A == "n") {
                newQuestion->noPtr = newGuess;
                newQuestion->yesPtr = curNode;
            }

            if (restart()) {
                start();
            }
        }
    }
}

int main() {
    start();
    return 0;
}