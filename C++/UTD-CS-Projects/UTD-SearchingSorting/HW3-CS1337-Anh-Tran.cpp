// UTD-SearchingSorting.cpp : This file contains the 'main' function. Program
// execution begins and ends there.
//

/*
	Name: Anh Tran
	Program name: WordSearch
	Date Created: 02/09//22
	Notes:

	Changelog:

*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <random>

using namespace std;

vector<int> randomNums;
vector<int> sortedNums;

void randomGenerator(vector<int>& nums, int size, int limit) {
	srand(time(0));

	for (int i = 0; i < size; i++) {
		nums.push_back(rand() % limit + 1);
	}
}

void input() {
    int totalNums;
    int valueLimit;

	cout << "Welcome to the random number generator!" << endl
		 << "How many numbers would you like to generate?" << endl;
	cin >> totalNums;

	cout << "What number range should the numbers be in? (1 - 20)" << endl;
	cin >> valueLimit;


	randomGenerator(randomNums, totalNums, valueLimit);
}

void showVectors(vector<int> nums, string vectorName) {
	cout << endl << vectorName << ":\n"
		 << "Size: " << nums.size() << endl
		 << "Capacity: " << nums.capacity() << endl
		 << "************************************************************" << endl;
	for (int i = 0; i < nums.size(); i++) {
		cout << nums[i] << " ";
	}
	cout << endl << "************************************************************" << endl;
}

void sortVector(vector<int> nums) {
	sort(nums.begin(),nums.end()); 
}

void bubbleSort(vector<int> nums) {
    for (int i = 0; i < nums.size(); i++) {
        for (int j = 0; j < nums.size() - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                swap(nums[j], nums[j + 1]);
            }
        }
    }
}

int binarySearch(vector<int> nums, int searchNum) {
    int first = 0;
    int last = nums.size() - 1;
    int middle = (first + last) / 2;

    while (first < last) {
        if (searchNum == nums[middle]) {
            return middle;
        }

        if (searchNum < nums[middle]) {
            last = middle;
            middle = (first + last) / 2;
        } else {
            first = middle + 1;
            middle = (first + last) / 2;
        }
    }
    return -1;
}

void deleteDuplicates() {

}

int main() {
    input();
    showVectors(randomNums, "Unsorted Vector");
    cout << "Search num: " << binarySearch(randomNums, 3);
}
