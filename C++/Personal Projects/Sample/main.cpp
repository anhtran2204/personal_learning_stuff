#include <iostream>
#include <memory>

using namespace std;

int main() {
    int x = 10;
    int *ptr = nullptr;

    ptr = &x;
    
    cout << *ptr << endl;

    unique_ptr<int> smrtPtr(new int);

    *smrtPtr = x;

    cout << *smrtPtr << endl;

    return 0;
}