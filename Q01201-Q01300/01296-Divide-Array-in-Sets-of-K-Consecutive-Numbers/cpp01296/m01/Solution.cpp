// C++
// Runtime: 156 ms, faster than 80.33% of C++ online submissions for Divide Array in Sets of K Consecutive Numbers.
// Memory Usage: 50 MB, less than 41.58% of C++ online submissions for Divide Array in Sets of K Consecutive Numbers.
class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {

        map<int, int> help;

        for(int num: nums) {
            help[num]++;
        }

        for (auto iter = help.begin(); iter != help.end(); iter++) {
            int num = iter -> first;
            int acc = iter -> second;

            if (acc > 0) {

                auto it = next(iter);

                for (int i = 1; i < k; i++,it++) {
                    if (it != help.end() && it -> first == num + i && it -> second > acc - 1) {
                        it -> second -= acc;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;

    }
};