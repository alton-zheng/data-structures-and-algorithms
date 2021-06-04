// Runtime: 76 ms, faster than 91.16% of C++ online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
// Memory Usage: 35.3 MB, less than 45.12% of C++ online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
class Solution {
public:
    int minDifference(vector<int>& nums) {

        // get length for nums
        int len = nums.size();

        /**
         * when a given array is no longer than 4
         * we can always make all the numbers the same,
         * so let's consider arrays of length greater than 4.
         */
        if (len <= 4) {
            return 0;
        }


        // Notice that each change has to be either to make the maximum smaller or to make the minimum larger,
        // so that the difference between the maximum and the minimum is as small as possible.
        vector<int> maximums(4, -1e9), minimums(4, 1e9);

        int four;

        for (int i = 0; i < len; i++) {
            four = 0;

            while (four < 4 && maximums[four] > nums[i]) {
                four++;
            }

            if (four < 4) {
               for (int j = 3; j > four; j--) {
                maximums[j] = maximums[j - 1];
               }
               maximums[four] = nums[i];
            }

            four = 0;

            while (four < 4 && minimums[four] < nums[i]) {
                four++;
            }

            if (four < 4) {
                for (int j = 3; j > four; j--) {
                    minimums[j] = minimums[j - 1];
                }
                minimums[four] = nums[i];
            }
        }

        int res = 2e9;

        for (int i = 0; i < 4; i++) {
            res = min(res, maximums[i] - minimums[3 - i]);
        }

        return res;

    }
};