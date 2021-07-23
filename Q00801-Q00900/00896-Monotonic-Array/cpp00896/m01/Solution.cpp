class Solution {
public:
    bool isMonotonic(vector<int>& nums) {
        int pre = nums[0];
        int flag = 0;
        for(int i = 1; i < nums.size(); i++) {

            if (flag == 0 && pre != nums[i]) {
                flag = nums[i] > pre ? 1 : -1;
            }

            if (!(flag > 0 ? nums[i] >= pre : nums[i] <= pre)) {
                return false;
            }

            pre = nums[i];
        }

        return true;
    }
};