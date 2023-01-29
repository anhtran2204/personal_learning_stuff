/*
    Name: Anh Tran
    Program name: TongueTwisters
    Date Created: 01/24/22
    Notes:
        -   should be able to create a head node with data when detected null
        -   traverse the linked list to reach the desired node either in the 
            yes direction or the no direction
        -   be able to add a new question node with a yesPtr and noPtr direciton
            as well as be able to add a new guess node at the end of the path
        -   be able to restart the routine after guessing the animal or adding
            a new animal to the linked list
    Changelog:
        -   04/02/22 - v1:
            -   added a struct called animalNode that defines the
                data types an animalNode should have
            -   added a head node for the linked list
            -   added an intializeNode() to create a new node and return it
        -   04/04/22 - v2:
            -   added a traverse() and insert() for traversing the linked list and 
                adding new nodes to it based on the user input
            -   added an intro() to show the user initial info
        -   04/05/22 - v3:
            -   added restart() to restart the game when it finished guessing the 
                animal or adding a new animal from user input
        -   04/07/22 - v4:
            -   added ask(), guess() to ask the user the new animal to be added
                and guess the animal after traversing throug the linked list
            -   added a routine() to combine all the separate functions into a routine
                for reusability
            -   added a start() function to structure a layout of the program
*/

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

void traverse(animalNode*& currNode, string& Q_and_A);
void insert(animalNode*& currNode, animalNode* temp, string Q_and_A);
void ask(animalNode*& currNode, animalNode* temp, string& Q_and_A);
void guess(animalNode* currNode, string& Q_and_A);
bool restart();
void intro();
void routine(animalNode*& node, string& Q_and_A);
void start();

animalNode* initializeRoot() {
    animalNode* root = new animalNode;
    root->question = "";
    root->guess = "lizard";
    root->yesPtr =nullptr;
    root->noPtr = nullptr;
    return root;
}

animalNode* initializeNode() {
    animalNode* node = new animalNode;
    node->question = "";
    node->guess = "";
    node->yesPtr =nullptr;
    node->noPtr = nullptr;
    return node;
}

void traverse(animalNode*& currNode, string& Q_and_A) {
    currNode = head;
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

void insert(animalNode*& currNode, animalNode* temp, string Q_and_A) {
    animalNode* yesNode = initializeNode();
    animalNode* noNode = initializeNode();

    if (Q_and_A == "Y" || Q_and_A == "y") {
        currNode->question = temp->question;
        yesNode->guess = temp->guess;
        noNode->guess = currNode->guess;
        currNode->guess = "";
        currNode->yesPtr = yesNode;
        currNode->noPtr = noNode;
    } else if (Q_and_A == "N" || Q_and_A == "n") {
        currNode->question = temp->question;
        yesNode->guess = currNode->guess;
        noNode->guess = temp->guess;
        currNode->guess = "";
        currNode->yesPtr = yesNode;
        currNode->noPtr = noNode;
    }
}

void ask(animalNode*& currNode, animalNode* temp, string& Q_and_A) {
    cout << "Bummer! What animal were you thinking of?" << endl;
    cin >> Q_and_A;
    cin.ignore();

    temp->guess = Q_and_A;

    cout << "What is a yes/no question that I can use to tell a " << currNode->guess
            << " from a " << temp->guess << endl;
    getline(cin, Q_and_A);

    temp->question = Q_and_A;

    cout << "For a " << temp->guess << ", is the answer yes or no? (Y/N)" << endl;
    cin >> Q_and_A;
    cin.ignore();
}

void guess(animalNode* currNode, string& Q_and_A) {
    cout << "Is it a(n)" << sp << currNode->guess << "? (Y/N)" << endl;
    cin >> Q_and_A;
    cin.ignore();
}

bool restart() {
    cout << "Try again? (Y/N)" << endl;
    string flag;

    while (true) {
        getline(cin, flag);
        if (flag == "Y" || flag == "y") {
            cout << endl;
            return true;
        } else if (flag == "N" || flag == "n") {
            cout << endl;
            cout << "Thanks for playing!" << endl;
            return false;
        } else {
            cout << "Please enter valid response!" << endl;
        }
    }
}

void intro() {
    cout << "Let's play the \"Guess the Animal\" game.\n"
         << "Think of an animal and hit return when you're ready.\n" << endl;
}

void routine(animalNode*& node, string& Q_and_A) {
    guess(node, Q_and_A);

    if (Q_and_A == "Y" || Q_and_A == "y") {
        cout << "\nGood! I guessed your animal." << endl;
        if (restart()) {
            start();
        }
    } else if (Q_and_A == "N" || Q_and_A == "n") {

        animalNode* temp = initializeNode();

        ask(node, temp, Q_and_A);

        insert(node, temp, Q_and_A);

        if (restart()) {
            start();
        }
    }
}

void start() {
    intro();

    string Q_and_A;
    if (!head) {
        head = initializeRoot();
        
        routine(head, Q_and_A);
    } else {
        animalNode* currNode;

        traverse(currNode, Q_and_A);

        routine(currNode, Q_and_A);
    }
}

int main() {
    start();
    return 0;
}