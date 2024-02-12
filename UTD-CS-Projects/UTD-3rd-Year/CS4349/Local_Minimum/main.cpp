#include <iostream>
#include <vector>

using namespace std;

void local_minimum(vector<int> arr, vector<int> &local_mins, int low, int high);

int main() {
    vector<int> arr = {9, 7, 7, 2, 1, 3, 7, 5, 4, 7, 3, 3, 4, 8, 6, 9};

    vector<int> local_min = {};

    local_minimum(arr, local_min, 0, arr.size());

    for (auto i : local_min) {
        cout << i << " " << endl;
    }

    return 0;
}

void local_minimum(vector<int> arr, vector<int> &local_mins, int low, int high) {
    int mid = low + (high - low)/2;
    if (((mid - 1) < 0) || ((mid + 1) >= arr.size())) {
        return;
    }
    if (arr.at(mid - 1) >= arr.at(mid) && arr.at(mid) <= arr.at(mid + 1)) {
        local_mins.push_back(arr.at(mid));
    }

    if (arr.at(mid) > arr.at(mid - 1)) {
        local_minimum(arr, local_mins, low, mid - 1);
    } else {
        local_minimum(arr, local_mins, mid + 1, high);
    }
}