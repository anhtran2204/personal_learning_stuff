#include <iostream>
#include <string>

using namespace std;

int main()
{
	cout << "Hello World!" << endl;
	
	string name;
	int age;
	
	cout << "What is your name?" << endl;
	getline(cin, name);

	cout << "What is your age?" << endl;
	cin >> age;

	cin.ignore();

	cout << "Name: " << name << endl
	     << "Age: " << age << endl;
}
