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
                -   added in input() for inputting the total numbers in a vector
                    and the limit value of the numbers in the vector
                -   added debugging function showFlow()
                -   added randomGenerator() to randomly add value to the vector 
                    based on the limit value and the srand(time(0)) to make it truly 
                    random by using the current time each time.
        -   03/01/22 - v2:
                -   added sortVector() to sort a vector with the built-in sorting 
                    function in the <algorithm> library and a bubbleSort() function
                    utilizing the bubble sort algorithm
                -   a searchNumInput() and searchNum() to take input from user and 
                    find a number with the binary search algorithm
        -   03/03/22 - v3:
                -   also a searchFirstOccurence() and searchLastOccurence(), as well
                    as countDuplicates() and deleteDuplicates() that utilize the binary
                    search algorithm to find duplicates of each number value in a vector
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
    showFlow("randomGenerator");
    srand(time(0));

    for (int i = 0; i < size; i++)
    {
        nums.push_back(rand() % limit + 1);
    }
    showFlow("LEAVING randomGenerator");
} // randomGenerator

void input(vector<int> &randomNums, int &totalNums, int &valueLimit)
{
    showFlow("input");
    cout << "Welcome to the random number generator!" << endl
         << "How many numbers would you like to generate? ";
    cin >> totalNums;

    cout << "What number range should the numbers be in? (1 - 20): " ;
    cin >> valueLimit;

    randomGenerator(randomNums, totalNums, valueLimit);
    showFlow("LEAVING input");
}

void showVectors(vector<int> &nums, string vectorName)
{
    showFlow("showVectors");
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

    showFlow("LEAVING showVectors");
}

void sortVector(vector<int> &nums)
{
    showFlow("sortVector");
    sort(nums.begin(), nums.end());
    showFlow("LEAVING sortVector");
}

void bubbleSort(vector<int> &nums)
{
    showFlow("bubbleSort");
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
    showFlow("LEAVING bubbleSort");
}

int searchNumInput()
{
    showFlow("searchNumInput");
    cout << "\nWhat number would you like to search for? ";

    int num;
    cin >> num;

    showFlow("LEAVING searchNumInput");
    return num;
}

int searchNum(vector<int> nums, int searchNum)
{
    showFlow("searchNum");
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
        cout << "+ The number \"" << searchNum << "\""
             << " couldn't be found in the vector" << endl;
    }
    else
    {
        cout << "+ The number \"" << searchNum << "\""
             << " is found at index " << location << endl;
    }
    showFlow("LEAVING searchNum");
    return location;
}

int searchFirstOccurence(vector<int> nums, int searchNum)
{
    showFlow("searchFirstOccurence");
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
    showFlow("LEAVING searchFirstOccurence");
    return -1;
}

int searchLastOccurence(vector<int> nums, int searchNum)
{
    showFlow("searchLastOccurence");
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
    showFlow("LEAVING searchLastOccurence");
    return -1;
}

void countDuplicates(vector<int> nums, int searchNum, int location)
{
    showFlow("countDuplicates");
    if (location != -1){
        cout << "+ The number \"" << searchNum
         << "\" could be found "
         << searchLastOccurence(nums, searchNum) - searchFirstOccurence(nums, searchNum) + 1
         << " times throughout the vector" << endl;
    }
    showFlow("LEAVING countDuplicates");
}

void deleteDuplicates(vector<int> &nums)
{
    showFlow("deleteDuplicates");
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
    showFlow("LEAVING deleteDuplicates");
}

int main()
{
    showFlow("main");

    vector<int> randomNums;
    int totalNums;
    int valueLimit;

    input(randomNums, totalNums, valueLimit);

    showVectors(randomNums, "Random Unsorted Vector");
    sortVector(randomNums);
    showVectors(randomNums, "Random Built-in Sorted Vector");

    vector<int> copyNums;
    copyNums = randomNums;

    bubbleSort(copyNums);
    showVectors(copyNums, "Copied Bubble Sorted Vector");

    for (int i = 0; i < 5; i++)
    {
        int num = searchNumInput();
        int location = searchNum(randomNums, num);
        countDuplicates(randomNums, num, location);
    }

    deleteDuplicates(randomNums);
    showVectors(randomNums, "Duplicate Deleted Vector");

    showFlow("LEAVING main");
}
