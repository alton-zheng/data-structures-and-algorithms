

// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Arithmetic Slices.
// Memory Usage: 7.4 MB, less than 52.91% of C++ online submissions for Arithmetic Slices.
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int len = nums.size();

        if (len < 3) {
            return 0;
        }

        int slices = 0;
        int cnt = 2;
        int pre = nums[1] - nums[0];
        for (int i = 2; i < nums.size(); i++) {
            int temp = nums[i] - nums[i - 1];
            if (temp == pre) {
                cnt++;
                slices += cnt == 3 ? 1 : cnt - 2;
            } else {
                cnt = 2;
                pre = temp;
            }
        }

        return slices;

    }
};