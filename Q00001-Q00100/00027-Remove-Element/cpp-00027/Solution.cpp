#include <iostream>
#include <vector>
#include <cassert>
#include <stdexcept>

using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (!nums.size()) {
         return 0;
        }

        int start = 0;
        int i = 0;
        while (i < nums.size()) {
            if (nums[i] != val) {
                nums[start++] = nums[i];
            }
            ++i;
        }

        return start;
    }
};