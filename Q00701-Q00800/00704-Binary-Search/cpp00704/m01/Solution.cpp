class Solution {
public:
    int search(vector<int>& nums, int target) {

        int len = nums.size();
        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
};