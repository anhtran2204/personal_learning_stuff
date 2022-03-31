#include <iostream>

using namespace std;

#define sp " "

struct animalNode {
    string question;
    string guess;
    animalNode* yesPtr;
    animalNode* noPtr;
};

animalNode initializeNode() {
    animalNode* root = new animalNode;
    root->question = "";
    root->guess = "lizard";
    root->yesPtr, root->noPtr = nullptr;
    return *root;
}

void restart() {
    main();
}

void start(animalNode node, char userAns) {
    cout << "Is it a(n)" << sp << node.guess << endl << "?";
    if (userAns == tolower('Y')) {
        cout << "Try again?" << endl;
        restart();
    } else if (userAns == tolower('N')) {

    }
}

int main() {

    return 0;
}