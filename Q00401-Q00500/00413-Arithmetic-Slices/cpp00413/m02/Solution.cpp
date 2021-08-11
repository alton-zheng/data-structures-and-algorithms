// 优化方法一写法
// 其核心思想为 DP
class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int len = nums.size();

        if (len < 3) {
            return 0;
        }

        int slices = 0;
        int cnt = 0;
        for (int i = 2; i < nums.size(); i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cnt++;
                slices += cnt;
            } else {
                cnt = 0;
            }
        }

        return slices;

    }
};