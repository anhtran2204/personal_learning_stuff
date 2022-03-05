// UTD-SearchingSorting.cpp : This file contains the 'main' function. Program
// execution begins and ends there.
//

/*
    Name: Anh Tran
    Program name: WordSearch
    Date Created: 02/09//22
    Notes:
        -   be able to generate fully random numbers in a vector
        -   be able to sort a vector both by using the built-in function
            and the bubble sort algorithm
        -   be able to implement binary search algorithm to find a number
            within a vector as well as be able to count duplicates of that number
        -   also be able to delete the duplicates of that number
    Changelog:
        -   02/28/22 - v1:
                -
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <random>

using namespace std;

bool debugging = false;

void showFlow(string location)
{
    if (debugging)
    {
        cout << "---- " << location << " ----" << endl;
        system("pause");
    }
} // showFlow

void randomGenerator(vector<int> &nums, int size, int limit)
{
    srand(time(0));

    for (int i = 0; i < size; i++)
    {
        nums.push_back(rand() % limit + 1);
    }
}

void input(vector<int> &randomNums, int &totalNums, int &valueLimit)
{
    cout << "Welcome to the random number generator!" << endl
         << "How many numbers would you like to generate?" << endl;
    cin >> totalNums;

    cout << "What number range should the numbers be in? (1 - 20)" << endl;
    cin >> valueLimit;

    randomGenerator(randomNums, totalNums, valueLimit);
}

void showVectors(vector<int> &nums, string vectorName)
{
    cout << endl
         << vectorName << ":\n"
         << "Size: " << nums.size() << endl
         << "Capacity: " << nums.capacity() << endl
         << "************************************************************" << endl;
    for (int i = 0; i < nums.size(); i++)
    {
        cout << nums[i] << " ";
    }
    cout << endl
         << "************************************************************" << endl;
}

void sortVector(vector<int> &nums)
{
    sort(nums.begin(), nums.end());
}

void bubbleSort(vector<int> &nums)
{
    for (int i = 0; i < nums.size(); i++)
    {
        for (int j = 0; j < nums.size() - 1; j++)
        {
            if (nums[j] > nums[j + 1])
            {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }
}

int searchNumInput()
{
    cout << "What number would you like to search for? ";

    int num;
    cin >> num;

    return num;
}

int searchNum(vector<int> nums, int searchNum)
{
    int first = 0;
    int last = nums.size() - 1;

    int location = -1;
    while (first <= last)
    {
        int middle = (first + last) / 2;

        if (searchNum == nums[middle])
        {
            location = middle;
            break;
        }

        if (searchNum < nums[middle])
        {
            last = middle - 1;
        }
        else
        {
            first = middle + 1;
        }
    }

    if (location == -1)
    {
        cout << "The number \"" << searchNum << "\""
             << " couldn't be found in the vector" << endl;
    }
    else
    {
        cout << "The number \"" << searchNum << "\""
             << " is found at index " << location << endl;
    }
    return location;
}

int searchFirstOccurence(vector<int> nums, int searchNum)
{
    int first = 0;
    int last = nums.size() - 1;

    while (first <= last)
    {
        int middle = (first + last) / 2;

        if (searchNum == nums[middle])
        {
            if (nums[middle - 1] != searchNum)
            {
                return middle;
            }
            else
            {
                last = middle - 1;
            }
        }
        else if (searchNum < nums[middle])
        {
            last = middle - 1;
        }
        else
        {
            first = middle + 1;
        }
    }
    return -1;
}

int searchLastOccurence(vector<int> nums, int searchNum)
{
    int first = 0;
    int last = nums.size() - 1;

    while (first <= last)
    {
        int middle = (first + last) / 2;

        if (searchNum == nums[middle])
        {
            if (nums[middle + 1] != searchNum)
            {
                return middle;
            }
            else {
                first = middle + 1;
            }
        }
        else if (searchNum < nums[middle])
        {
            last = middle - 1;
        }
        else
        {
            first = middle + 1;
        }
    }
    return -1;
}

void countDuplicates(vector<int> nums, int searchNum, int location)
{
    if (location != -1){
        cout << "The number \"" << searchNum
         << "\" could be found "
         << searchLastOccurence(nums, searchNum) - searchFirstOccurence(nums, searchNum) + 1
         << " times throughout the vector" << endl;
    }
}

void deleteDuplicates(vector<int> &nums)
{
    int valueLimit = nums.size() - 1;
    int count = 0;
    int num = 1;
    int index = 0;

    while (num <= valueLimit)
    {
        if (nums[index] == num)
        {
            count++;
            if (count > 1)
            {
                if (index == nums.size())
                {
                    break;
                }
                nums.erase(nums.begin() + index);
            }
            else
            {
                index++;
            }
        }
        else
        {
            num++;
            count = 0;
        }
    }
}

int main()
{
    vector<int> randomNums;
    int totalNums;
    int valueLimit;

    input(randomNums, totalNums, valueLimit);

    showVectors(randomNums, "Random Unsorted Vector");
    sortVector(randomNums);
    showVectors(randomNums, "Random Sorted Vector");

    vector<int> copyNums;
    copyNums = randomNums;

    bubbleSort(copyNums);
    showVectors(copyNums, "Copied Bubble Sorted Vector");

    for (int i = 0; i < 5; i++)
    {
        int num = searchNumInput();
        int location = searchNum(randomNums, num);
        countDuplicates(randomNums, num, location);
        cout << endl;
    }

    deleteDuplicates(randomNums);
    showVectors(randomNums, "Duplicate Deleted Vector");
}
