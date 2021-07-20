// Runtime: 32 ms, faster than 99.82% of C++ online submissions for Sort an Array.
// Memory Usage: 34.1 MB, less than 28.43% of C++ online submissions for Sort an Array.
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int BOUND = 50000;
        vector<int> help(2 * BOUND + 2);
        int minValue = BOUND, maxValue = -BOUND;

        for (int num: nums) {
            help[num + BOUND]++;
            minValue = min(minValue, num);
            maxValue = max(maxValue, num);
        }

        int cur = 0;
        for (int i = minValue + BOUND; i <= maxValue + BOUND; i++) {
            while (help[i] > 0) {
                nums[cur++] = i - BOUND;
                help[i]--;
            }
        }

        return nums;
    }
};