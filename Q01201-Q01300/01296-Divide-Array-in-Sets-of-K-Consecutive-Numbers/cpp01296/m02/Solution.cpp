// C++17
// Runtime: 208 ms, faster than 28.87% of C++ online submissions for Divide Array in Sets of K Consecutive Numbers.
// Memory Usage: 49.9 MB, less than 64.86% of C++ online submissions for Divide Array in Sets of K Consecutive Numbers.

// slower than c++ version.
class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {

        map<int,int> help;

        for (int num: nums) {
            help[num]++;
        }

        for (auto& [num, acc] : help) {
            if (acc > 0) {

               for (int i = num + 1; i < num + k; i++) {
                if (help.count(i) && help[i] > acc - 1) {
                    help[i] -= acc;
                } else {
                    return false;
                }
               }
            }

        }

        return true;

    }
};