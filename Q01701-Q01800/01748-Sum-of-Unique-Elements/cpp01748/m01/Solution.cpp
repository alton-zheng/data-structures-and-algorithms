// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sum of Unique Elements.
// Memory Usage: 7.9 MB, less than 76.12% of C++ online submissions for Sum of Unique Elements.
class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        vector<int> help(101);

        int sum = 0;

        for (int num: nums) {
            help[num]++;
            sum += num;
        }

        for (int i = 1; i <= 100; i++) {
            if (help[i] > 1) {
                sum -= help[i]*i;
            }
        }

        return sum;
    }
};