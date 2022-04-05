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

void display(animalNode* node) {
    cout << node->question << endl;
    cout << node->guess << endl;
    cout << node->yesPtr << endl;
    cout << node->noPtr << endl;
}

void start() {
    intro();

    string Q_and_A;
    if (!head) {
        head = initializeRoot();
        cout << "Is it a(n)" << sp << head->guess << "?" << endl;
        cin >> Q_and_A;

        if (Q_and_A == "Y" || Q_and_A == "y") {
            cout << "Good! I guessed your animal." << endl;
            if (restart()) {
                start();
            }
        } else if (Q_and_A == "N" || Q_and_A == "n") {
            animalNode* yesNode = initializeNode();
            animalNode* noNode = initializeNode();

            animalNode* newQuestion = initializeNode();
            animalNode* temp = initializeNode();

            cout << "Bummer! What animal were you thinking of?" << endl;
            cin >> Q_and_A;
            cin.ignore();

            temp->guess = Q_and_A;

            cout << "What is a yes/no question that I can use to tell a " << head->guess
                 << " from a " << temp->guess << endl;
            getline(cin, Q_and_A);

            temp->question = Q_and_A;

            cout << "For a " << temp->guess << ", is the answer yes or no?" << endl;
            cin >> Q_and_A;
            cin.ignore();

            if (Q_and_A == "Y" || Q_and_A == "y") {
                head->question = temp->question;
                yesNode->guess = temp->guess;
                noNode->guess = head->guess;
                head->guess = "";
            } else if (Q_and_A == "N" || Q_and_A == "n") {
                head->question = temp->question;
                yesNode->guess = head->guess;
                noNode->guess = temp->guess;
                head->guess = "";
            }
        }
    } else {
        animalNode* yesNode = initializeNode();
        animalNode* noNode = initializeNode();

        animalNode* currNode = head;
        
        while (currNode->yesPtr != nullptr && currNode->noPtr != nullptr) {
            cout << currNode->question << endl;
            cin >> Q_and_A;
            cin.ignore();

            if (Q_and_A == "Y" || Q_and_A == "y")
            {
                currNode = currNode->yesPtr;
            }
            else if (Q_and_A == "N" || Q_and_A == "n")
            {
                currNode = currNode->noPtr;
            }
        }
    }
}

int main() {
    start();
    return 0;
}