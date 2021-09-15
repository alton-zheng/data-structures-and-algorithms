class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int len = nums.size();
        int left = -1;

        for (int i = 0; i < len; i++) {
            if ((i == 0 || nums[i] > left) && (i + 1 == len || nums[i] > nums[i + 1])) {
                return i;
            } else {
                left = nums[i];
            }
        }

        return -1;
    }
};